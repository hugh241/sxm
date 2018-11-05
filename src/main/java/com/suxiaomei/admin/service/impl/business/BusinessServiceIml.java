package com.suxiaomei.admin.service.impl.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.account.RoleModuleMapper;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.dao.business.BusinessMapper;
import com.suxiaomei.admin.dao.common.ModuleMapper;
import com.suxiaomei.admin.dao.isoc.IsocEmpowerFirmMapper;
import com.suxiaomei.admin.dao.isoc.MemberMapper;
import com.suxiaomei.admin.entity.account.RoleModule;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.business.extend.BusinessExtend;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;
import com.suxiaomei.admin.entity.isoc.Member;
import com.suxiaomei.admin.service.business.BusinessService;
import com.suxiaomei.admin.util.QueryResult;

import net.sf.json.JSONObject;

@Service
@Transactional
public class BusinessServiceIml implements BusinessService{
	@Autowired
	private BusinessMapper businessDao;
	@Autowired
	private MemberMapper memberDao;
	@Autowired
	private GlobalConfig config;
	@Autowired
	private IsocEmpowerFirmMapper isocEmpowerFirmDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private RoleModuleMapper roleModuleDao;
	@Autowired
	private ModuleMapper moduleDao;
	
	@Override
	public QueryResult<BusinessExtend> findByPageList(String condition) {
		JSONObject json = JSONObject.fromObject(condition);
		BusinessExtend business = new BusinessExtend();
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				business.setFullname(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("identificationstatus") && whereObj.getString("identificationstatus") != null){
				business.setIdentificationstatus(whereObj.getInt("identificationstatus"));
			}
		}
		QueryResult<BusinessExtend> businessQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		businessQ.setList(businessDao.findByPageList((businessQ.getPageIndex()-1)*businessQ.getPageSize(),businessQ.getPageSize(),business));
		businessQ.setTotalRow(businessDao.findCountByCondition(business));
		return businessQ;
	}

	@Override
	public BusinessExtend findDetailByBusinessid(int id) {
		return businessDao.findDetailByBusinessid(id);
	}

	@Override
	public BusinessExtend findDetailByMemberid(int memberid) {
		Member member = memberDao.selectByPrimaryKey(memberid);
		return findDetailByBusinessid(member.getBusinessid());
	}

	@Override
	public QueryResult<Business> findBAuthBusiness(String condition, User user, int type) {
		JSONObject json = JSONObject.fromObject(condition);
		Map<String,Object> map = new HashMap<>();
		if(user.getRole().getType() == config.INT_ISOCNO){
			map.put("isocid", user.getRole().getRelationid());
		}
		map.put("type", type);
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("fullname") && whereObj.getString("fullname") != null){
				map.put("fullname", whereObj.getString("fullname").trim());
			}
		}
		QueryResult<Business> businessQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		businessQ.setList(businessDao.findBAuthByPageList((businessQ.getPageIndex()-1)*businessQ.getPageSize(),businessQ.getPageSize(),map));
		businessQ.setTotalRow(businessDao.findBAuthCountByCondition(map));
		return businessQ;
	}

	@Override
	public int authBusiness(int id, Integer status, User user) {
		Business business = businessDao.selectByPrimaryKey(id);
		if(business == null){
			return 426;
		}
		//查询该企业是否是授权单位
		int isocid = 0;
		if(user.getRole().getType() == config.INT_ISOCNO) {//家协操作
			isocid = user.getRole().getRelationid();
		}else {//没有权限进行本次操作
			return 425;
		}
		IsocEmpowerFirm ief = isocEmpowerFirmDao.findByIsocidAndBusinessid(isocid, id);
		if(status != null && status == 1) {//授权
			if(ief != null && ief.getStatus() == 1) {//当前企业存在授权
				return 426;
			}else if(ief != null && ief.getStatus() == 0){
				ief.setStatus(1);
				isocEmpowerFirmDao.updateByPrimaryKey(ief);
			}else{//为当前企业添加授权
				ief = new IsocEmpowerFirm();
				ief.setBusinessid(id);
				ief.setIsocid(isocid);
				ief.setName(business.getFullname());
				ief.setType(1);
				isocEmpowerFirmDao.insert(ief);
			}
		}else {//取消授权
			if(ief == null) {//当前企业没有授权
				return 426;
			}else if(ief != null && ief.getStatus() == 0){//已取消授权
				return 426;
			}else{//将当前授权设置为删除状态
				ief.setStatus(0);
				isocEmpowerFirmDao.updateByPrimaryKey(ief);
			}
		}
		User buser = userDao.findByBusinessid(id);
		if(ief.getStatus() == 1) {//授权
			for (int i = 0; i < config.STR_B_CEAUDIT_MODULENAME.size(); i++) {
				RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(buser.getRoleid(), config.STR_B_CEAUDIT_MODULENAME.get(i), config.INT_BUSINESS);
				if(rm == null) {//添加授权
					Module module = moduleDao.findByUrlAndSxmsystemid(config.STR_B_CEAUDIT_MODULENAME.get(i), config.INT_BUSINESS);
					rm = new RoleModule(buser.getRoleid(), module.getModuleid());
					roleModuleDao.insert(rm);
				}
			}
		}else {//取消授权
			//检测当前企业是否是其他家协的有效授权单位
			List<IsocEmpowerFirm> list = isocEmpowerFirmDao.findByBusinessid(id);
			if(list == null) {//不是 删除菜单权限
				for (int i = 0; i < config.STR_B_CEAUDIT_MODULENAME.size(); i++) {
					RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(buser.getRoleid(), config.STR_B_CEAUDIT_MODULENAME.get(i), config.INT_BUSINESS);
					if(rm != null) {//删除授权
						roleModuleDao.deleteByPrimaryKey(rm.getRolemoduleid());
					}
				}
			}
		}
		return 1;
	}

	@Override
	public int compalteBusinessInfo(Integer businessid, String fullname, String phone, String email, String url,
			String address, String summary, String path) {
		Business business = businessDao.selectByPrimaryKey(businessid);
		if(business == null) {
			return 426;
		}
		business.setFullname(fullname);
		business.setPhone(phone);
		business.setEmail(email);
		business.setUrl(url);
		business.setAddress(address);
		business.setSummary(summary);
		if(path != null) {
			business.setLogo(path);
		}
		return businessDao.updateByPrimaryKey(business);
	}
}
