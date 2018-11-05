package com.suxiaomei.admin.service.impl.isoc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.account.RoleMapper;
import com.suxiaomei.admin.dao.account.RoleModuleMapper;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.dao.common.AddressMapper;
import com.suxiaomei.admin.dao.common.ModuleMapper;
import com.suxiaomei.admin.dao.employee.EmployeeIdentificationOrderMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessDataConfigureMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderDataDetailMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderDataMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderMapper;
import com.suxiaomei.admin.dao.isoc.IsocBusinessOrderRecordMapper;
import com.suxiaomei.admin.dao.isoc.IsocEmpowerFirmMapper;
import com.suxiaomei.admin.dao.isoc.IsocIdentificationBusinessMapper;
import com.suxiaomei.admin.dao.isoc.IsocMapper;
import com.suxiaomei.admin.dao.isoc.IsocMemberMapper;
import com.suxiaomei.admin.dao.isoc.TokenMapper;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.RoleModule;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Address;
import com.suxiaomei.admin.entity.common.Module;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderRecord;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;
import com.suxiaomei.admin.entity.isoc.IsocIdentificationBusiness;
import com.suxiaomei.admin.entity.isoc.IsocMember;
import com.suxiaomei.admin.entity.isoc.Token;
import com.suxiaomei.admin.entity.isoc.extend.IsocBusinessOrderExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocEmpowerExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.DateUtil;
import com.suxiaomei.admin.util.Md5;
import com.suxiaomei.admin.util.QueryResult;
import com.suxiaomei.admin.util.Util;
import com.suxiaomei.admin.util.file.FileUploadUtil;
import com.suxiaomei.admin.util.wx.WeixinUtil;

import net.sf.json.JSONObject;
/**
 * 家协服务
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月20日 下午5:13:38
 */
@Service
@Transactional
public class IsocServiceImpl implements IsocService{
	@Autowired
	private IsocMapper isocDao;
	@Autowired
	private TokenMapper tokenDao;
	@Autowired
	private UserMapper userDao;
	@Autowired
	private AddressMapper addressDao;
	@Autowired
	private IsocEmpowerFirmMapper isocEmpowerFirmDao;
	@Autowired
	private RoleMapper roleDao;
	@Autowired
	private RoleModuleMapper roleModuleDao;
	@Autowired
	private IsocBusinessDataConfigureMapper isocBusinessDataConfigureDao;
	@Autowired
	private GlobalConfig config;
	@Autowired
	private IsocBusinessOrderMapper isocBusinessOrderDao;
	@Autowired
	private IsocBusinessOrderDataMapper isocBusinessOrderDataDao;
	@Autowired
	private IsocBusinessOrderRecordMapper isocBusinessOrderRecordDao;
	@Autowired
	private IsocIdentificationBusinessMapper isocIdentificationBusinessDao;
	@Autowired
	private IsocMemberMapper isocMemberDao;
	@Autowired
	private ModuleMapper moduleDao;
	@Autowired
	private IsocBusinessOrderDataDetailMapper isocBusinessOrderDataDetailDao;
	@Autowired
	private EmployeeIdentificationOrderMapper employeeIdentificationOrderDao;
	
	@Override
	public void updateAllToken() {
		//查询出所有家协
		List<Isoc> isoc = isocDao.selectWhoHasAppidAndAppSecrect();
		for (int i = 0;isoc != null && i < isoc.size(); i++) {
			//查询是否存在该家协的token
			Token token = tokenDao.findByIsocid(isoc.get(i).getIsocid());
			//得到家协appid和secret
			String tokenStr = WeixinUtil.getToken(isoc.get(i).getAppid(), isoc.get(i).getAppsecret());
			JSONObject obj = JSONObject.fromObject(tokenStr);
			if(obj.containsKey("expires_in") && "7200".equals(obj.getString("expires_in")) && obj.containsKey("access_token")){
				if(token == null) {
					token = new Token();
					token.setIsocid(isoc.get(i).getIsocid());
					token.setTokenvalue(obj.getString("access_token"));
					tokenDao.insertSelective(token);
				}else {
					token.setTokenvalue(obj.getString("access_token"));
					tokenDao.updateByPrimaryKeySelective(token);
				}
			}
		}
	}

	@Override
	public QueryResult<IsocExtend> findByPageList(String condition) {
		JSONObject json = JSONObject.fromObject(condition);
		Isoc isoc = new Isoc();
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				isoc.setName(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("status")){
				isoc.setStatus(whereObj.getInt("status"));
			}else {
				isoc.setStatus(-1);
			}
		}
		QueryResult<IsocExtend> isocQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		isocQ.setList(isocDao.findByPageList((isocQ.getPageIndex()-1)*isocQ.getPageSize(),isocQ.getPageSize(),isoc));
		isocQ.setTotalRow(isocDao.findCountByCondition(isoc));
		return isocQ;
	}

	@Override
	public int add(IsocExtend ie) {
		if(ie.getProvinceid() == null) {
			return 426;
		}
		//根据家协名称或归属地查询是否存在同名或相同归属地的家协
		Isoc isoc = isocDao.findByName(ie.getName());
		if(isoc != null) {
			return 450;
		}
		Address address = addressDao.findByProvinceidAndCityid(ie.getProvinceid(),ie.getCityid());
		if(address == null) {
			return 455;
		}
		isoc = isocDao.findByAddressid(address.getAddressid());
		if(isoc != null) {
			return 456;
		}
		if(ie.getUsername() == null || "".equals(ie.getUsername())) {
			return 426;
		}
		//根据登录名称查询账号
		User user = userDao.selectByUsername(ie.getUsername());
		if(user != null){
			return 423;
		}

		//新增家协
		isoc = new Isoc();
		isoc.setName(ie.getName());
		isoc.setAppid(ie.getAppid());
		isoc.setAppsecret(ie.getAppsecret());
		isoc.setAddressid(address.getAddressid());
		isocDao.insertSelective(isoc);
		if(ie.getAppid() != null && !"".equals(ie.getAppid()) && ie.getAppsecret() != null && !"".equals(ie.getAppsecret())){
			updateToken(isoc);//跟新家协token
		}
		//为当前家协新增一个家协本身的授权单位
		IsocEmpowerFirm ief = new IsocEmpowerFirm(isoc.getIsocid(),isoc.getName());
		isocEmpowerFirmDao.insertSelective(ief);
		//新增家协管理员角色
		Role role = new Role(isoc.getIsocid(),config.INT_ISOCNO,1,config.STR_MANAGER, config.STR_ISOCROLEDESC);
		roleDao.insertSelective(role);
		//查询出家协系统下的所有模块
		roleModuleDao.insertByRoleidAndSxmsystemid(role.getRoleid());
		//新增家协账号
		user = new User();
		user.setUsername(ie.getUsername());
		user.setPassword(Md5.Bit32(user.getUsername()+Md5.Bit32(ie.getPassword())));
		user.setRoleid(role.getRoleid());
		user.setName(ie.getName());
		userDao.insertSelective(user);
		return 1;
	}

	@Override
	public int update(IsocExtend ie) {
		Isoc isoc = isocDao.selectByPrimaryKey(ie.getIsocid());
		if(isoc == null){
			return 426;
		}
		Isoc tIsoc = isocDao.findByName(ie.getName());
		if(tIsoc != null && tIsoc.getIsocid() != isoc.getIsocid()) {//家协名称重复
			return 450;
		}
		Address address = addressDao.findByProvinceidAndCityid(ie.getProvinceid(), ie.getCityid());
		if(address == null) {//地址不存在
			return 455;
		}
		tIsoc = isocDao.findByAddressid(address.getAddressid());
		if(tIsoc != null && tIsoc.getIsocid() != isoc.getIsocid()) {//已存在相同归属地的家协
			return 456;
		}
		User iUser = userDao.findByIsocId(isoc.getIsocid());
		//判断用户名称是否重复
		User user = userDao.selectByUsername(ie.getUsername());
		if(user != null && user.getUserid() != iUser.getUserid()){
			return 423;
		}
		
		if(ie.getAppid() != null && !"".equals(ie.getAppid()) && ie.getAppsecret() != null && !"".equals(ie.getAppsecret())){
			updateToken(isoc);//跟新家协token
		}
		
		boolean flag = false;
		//修改授权单位名称和用户名称
		if(!isoc.getName().equals(ie.getName())) {
			IsocEmpowerFirm ief = isocEmpowerFirmDao.findSelfFirmByIsocid(isoc.getIsocid());
			ief.setName(ie.getName());
			isocEmpowerFirmDao.updateByPrimaryKeySelective(ief);
			flag = true;
			iUser.setName(ie.getName());
		}
		
		if(!iUser.getUsername().equals(ie.getUsername())){
			flag = true;
			iUser.setUsername(ie.getUsername());
		}
		if(flag) {//修改家协账号信息
			userDao.updateByPrimaryKeySelective(iUser);
		}
		
		//修改家协基本信息
		isoc.setName(ie.getName());
		isoc.setAppid(ie.getAppid());
		isoc.setAppsecret(ie.getAppsecret());
		isoc.setAddressid(address.getAddressid());
		isocDao.updateByPrimaryKeySelective(isoc);
		return 1;
	}
	/**
	 * 跟新家协的token信息
	 * @param isoc
	 */
	private void updateToken(Isoc isoc) {
		//查询是否存在该家协的token
		Token token = tokenDao.findByIsocid(isoc.getIsocid());
		if(token == null) {
			token = new Token();
			token.setIsocid(isoc.getIsocid());
		}
		//得到家协appid和secret
		String tokenStr = WeixinUtil.getToken(isoc.getAppid(), isoc.getAppsecret());
		JSONObject obj = JSONObject.fromObject(tokenStr);
		if(obj.containsKey("expires_in") && "7200".equals(obj.getString("expires_in")) && obj.containsKey("access_token")){
			token.setTokenvalue(obj.getString("access_token"));
		}
		if(token.getTokenid() > 0){
			//得到家协appid和secret
			tokenDao.updateByPrimaryKeySelective(token);
		}else{
			tokenDao.insertSelective(token);
		}
	}

	@Override
	public int updateStatus(int id) {
		Isoc isoc = isocDao.selectByPrimaryKey(id);
		if(isoc == null){
			return 426;
		}
		isoc.setStatus(Math.abs(isoc.getStatus()-1));
		isocDao.updateByPrimaryKeySelective(isoc);
		User user = userDao.findByIsocId(isoc.getIsocid());
		user.setStatus(isoc.getStatus());
		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int updatePassword(IsocExtend ie) {
		User user = userDao.findByIsocId(ie.getIsocid());
		if(user == null){
			return 426;
		}
		user.setPassword(Md5.Bit32(user.getUsername()+Md5.Bit32(ie.getPassword())));
		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public List<IsocBusinessDataConfigure> findConfigByIsocid(int isocid) {
		return isocBusinessDataConfigureDao.findByIsocid(isocid, null);
	}

	@Override
	public int addConfig(IsocBusinessDataConfigure config) {
		Isoc isoc = isocDao.selectByPrimaryKey(config.getIsocid());
		if(isoc == null){
			return 426;
		}
		return isocBusinessDataConfigureDao.insertSelective(config);
	}

	@Override
	public int updateConfig(IsocBusinessDataConfigure config) {
		IsocBusinessDataConfigure c = isocBusinessDataConfigureDao.selectByPrimaryKey(config.getIsocbusinessdataconfigureid());
		if(c == null){
			return 426;
		}
		c.setRemark(config.getRemark());
		c.setType(config.getType());
		c.setConfigname(config.getConfigname());
		return isocBusinessDataConfigureDao.updateByPrimaryKeySelective(c);
	}

	@Override
	public int deleteConfig(int id) {
		return isocBusinessDataConfigureDao.deleteByPrimaryKey(id);
	}

	@Override
	public IsocExtend findByIsocid(Integer isocid) {
		return isocDao.findDetailByIsocid(isocid);
	}

	@Override
	public Isoc selectByPrimaryKey(Integer isocid) {
		return isocDao.selectByPrimaryKey(isocid);
	}

	@Override
	public int update(Isoc isoc) {
		return isocDao.updateByPrimaryKeySelective(isoc);
	}

	@Override
	public QueryResult<IsocBusinessOrderExtend> findIsocBusinessOrder(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		IsocBusinessOrderExtend order = new IsocBusinessOrderExtend();
		if(user.getRole().getType() == config.INT_ISOCNO) {//家协端查询
			order.setIsocid(user.getRole().getRelationid());
		}else if(user.getRole().getType() == config.INT_BUSINESS) {//企业端查询
			order.setBusinessid(user.getRole().getRelationid());
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				order.setMembername(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("auditstatus") && whereObj.getInt("auditstatus") != -1){//审核状态0审核中 1审核通过 2驳回
				order.setAuditstatus(whereObj.getInt("auditstatus"));
			}
			if(whereObj.containsKey("type") && whereObj.getInt("type") != -1){//审核状态0企业认证 1学校认证
				order.setType(whereObj.getInt("type"));
			}
		}
		QueryResult<IsocBusinessOrderExtend> orderQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		orderQ.setList(isocBusinessOrderDao.findByPageList((orderQ.getPageIndex()-1)*orderQ.getPageSize(),orderQ.getPageSize(),order));
		orderQ.setTotalRow(isocBusinessOrderDao.findCountByCondition(order));
		return orderQ;
	}

	@Override
	public List<IsocBusinessOrderRecord> findIsocBusinessOrderRecord(int isocbusinessorderid) {
		return isocBusinessOrderRecordDao.findByIsocbusinessidorderid(isocbusinessorderid);
	}

	@Override
	public int authIsocBusinessOrder(IsocBusinessOrder order) {
		IsocBusinessOrder ib = isocBusinessOrderDao.selectByPrimaryKey(order.getIsocbusinessorderid());
		if(ib == null || ib.getAuditstatus() != 0){
			return 426;
		}
		List<IsocBusinessOrderData> datas = isocBusinessOrderDataDao.findByRelationidAndType(ib.getIsocbusinessorderid(),0);
		if(datas == null) {
			return 426;
		}
		ib.setAuditstatus(1);
		for (int i = 0;i < datas.size(); i++) {
			if(datas.get(i).getAuditstatus() == 2){//存在驳回项目
				ib.setAuditstatus(2);
				break;
			}else if(datas.get(i).getAuditstatus() == 1){
			}else if(datas.get(i).getAuditstatus() == 0){//存在未确认项目
				return 479;
			}else {//数据有误
				return 426;
			}
		}
		ib.setLevel(order.getLevel());
		if(ib.getAuditstatus() == 1){//审核通过
			//查询出历史认证记录
			IsocIdentificationBusiness iib = isocIdentificationBusinessDao.findByIsocidAndBusinessid(ib.getIsocid(),ib.getBusinessid());
			if(iib != null){
				int days = DateUtil.getDaysByTwoSTRDate(DateUtil.getCurrentDate(), iib.getEnddate());
				if(days > 0){//还未过期 订单开始时间为认证结束时间+1
					ib.setBegindate(DateUtil.addDaysToDateStr(iib.getEnddate(), 1));
				}else{//已过期，订单认证开始时间为当前时间
					ib.setBegindate(DateUtil.getCurrentDate());
				}
			}else{
				iib = new IsocIdentificationBusiness();
				iib.setIsocid(ib.getIsocid());
				iib.setBusinessid(ib.getBusinessid());
				IsocMember member = isocMemberDao.findByIsocidAndBusinessid(ib.getIsocid(),ib.getBusinessid());
				iib.setIsocmemberid(member.getIsocmemberid());
				ib.setBegindate(DateUtil.getCurrentDate());
			}
			ib.setEnddate(DateUtil.addYearsToDateStr(ib.getBegindate(), 1));
			ib.setResult("审核通过");
			
			iib.setLevel(order.getLevel());
			iib.setEnddate(ib.getEnddate());
			if(iib.getIsocidentificationbusinessid() > 0){
				isocIdentificationBusinessDao.updateByPrimaryKey(iib);
			}else{
				isocIdentificationBusinessDao.insert(iib);
			}
		}else{
			ib.setResult(order.getResult());
			ib.setBegindate("0000-00-00");
			ib.setEnddate("0000-00-00");
		}
		isocBusinessOrderDao.updateByPrimaryKey(ib);
		
		if(ib.getAuditstatus() == 1) {//授权通过 查看企业是否有提交护理员认证的权限，如果没有，添加
			User buser = userDao.findByBusinessid(ib.getBusinessid());
			for (int i = 0; i < config.STR_B_SEAUDIT_MODULENAME.size(); i++) {
				RoleModule rm = roleModuleDao.findByRoleidAndModulenameAndSxmsystemtype(buser.getRoleid(), config.STR_B_SEAUDIT_MODULENAME.get(i), config.INT_BUSINESS);
				if(rm == null) {//添加授权
					Module module = moduleDao.findByUrlAndSxmsystemid(config.STR_B_SEAUDIT_MODULENAME.get(i), config.INT_BUSINESS);
					rm = new RoleModule(buser.getRoleid(), module.getModuleid());
					roleModuleDao.insert(rm);
				}
			}
		}
		//添加审核记录
		IsocBusinessOrderRecord record = new IsocBusinessOrderRecord();
		record.setIsocbusinessorderid(ib.getIsocbusinessorderid());
		record.setResult(ib.getResult());
		isocBusinessOrderRecordDao.insert(record);
		return 1;
	}

	@Override
	public QueryResult<IsocIdentificationBusinessExtend> findIsocIdentificationBusiness(String condition, User user) {
		JSONObject json = JSONObject.fromObject(condition);
		IsocIdentificationBusinessExtend iib = new IsocIdentificationBusinessExtend();
		if(user.getRole().getType() == config.INT_ISOCNO) {//家协端查询
			iib.setIsocid(user.getRole().getRelationid());
		}
		if(json.containsKey("where")){
			JSONObject whereObj = json.getJSONObject("where");
			if(whereObj.containsKey("name") && whereObj.getString("name") != null){
				iib.setBusinessname(whereObj.getString("name").trim());
			}
			if(whereObj.containsKey("type") && whereObj.getInt("type") != -1){//审核类型0企业认证 1学校认证
				iib.setType(whereObj.getInt("type"));
			}
		}
		QueryResult<IsocIdentificationBusinessExtend> iibQ = new QueryResult<>((int)json.get("pageNo"), (int)json.get("pageSize"));
		iibQ.setList(isocIdentificationBusinessDao.findByPageList((iibQ.getPageIndex()-1)*iibQ.getPageSize(),iibQ.getPageSize(),iib));
		iibQ.setTotalRow(isocIdentificationBusinessDao.findCountByCondition(iib));
		return iibQ;
	}

	@Override
	public List<Isoc> findIsocWitchNotAuthMember(Integer businessid) {
		return isocDao.findIsocWitchNotAuthMembers(businessid);
	}

	@Override
	public List<Isoc> findIsocWitchAuthMember(Integer businessid) {
		return isocDao.findIsocWitchAuthMember(businessid);
	}

	@Override
	public List<IsocBusinessDataConfigure> findIsocBusinessDataConfiguresForBByIsocid(int isocid, int type) {
		return isocBusinessDataConfigureDao.findByIsocid(isocid,type);
	}

	@Override
	public int createIsocBusinessOrder(IsocBusinessOrder order) {
		Isoc isoc = isocDao.selectByPrimaryKey(order.getIsocid());
		if(isoc == null){
			return 426;
		}
		order.setAuditstatus(0);
		isocBusinessOrderDao.insert(order);
		return -order.getIsocbusinessorderid();
	}

	@Override
	public IsocBusinessOrder findIsocBusinessOrderByIsocbusinessorderid(int isocbusinessorderid) {
		return isocBusinessOrderDao.selectByPrimaryKey(isocbusinessorderid);
	}

	@Override
	public int addIsocBusinessOrderDataItems(int isocbusinessorderid, String name, List<String> pathes,int type) {
		IsocBusinessOrder order = isocBusinessOrderDao.selectByPrimaryKey(isocbusinessorderid);
		if(order == null || order.getAuditstatus() != 0) {
			return 426;
		}
		IsocBusinessOrderData data = new IsocBusinessOrderData();
		data.setRelationid(isocbusinessorderid);
		data.setType(type);
		data.setName(name);
		isocBusinessOrderDataDao.insert(data);
		for (int i = 0;i < pathes.size(); i++) {
			IsocBusinessOrderDataDetail detail = new IsocBusinessOrderDataDetail();
			detail.setIsocbusinessorderdataid(data.getIsocbusinessorderdataid());
			detail.setUrl(pathes.get(i));
			isocBusinessOrderDataDetailDao.insert(detail);
		}
		return 1;
	}

	@Override
	public int deleteIsocBusinessOrderDataDetailByIsocbusinessorderdatadetailid(int isocbusinessorderdatadetailid,int type) {
		if(type == 0){//企业认证详细
			IsocBusinessOrder order = isocBusinessOrderDao.findByIsocbusinessorderdatadetailid(isocbusinessorderdatadetailid);
			if(order == null || order.getAuditstatus() != 2){
				return 426;
			}
		}else if(type == 1){//护理员认证详细
			EmployeeIdentificationOrder order = employeeIdentificationOrderDao.findByIsocbusinessorderdatadetailid(isocbusinessorderdatadetailid);
			if(order == null || (order.getIdentificationstatus() != 1 && order.getIdentificationstatus() != 3)){
				return 426;
			}
		}
		IsocBusinessOrderDataDetail detail = isocBusinessOrderDataDetailDao.selectByPrimaryKey(isocbusinessorderdatadetailid);
		if(detail == null){
			return 426;
		}
		IsocBusinessOrderData data = isocBusinessOrderDataDao.selectByPrimaryKey(detail.getIsocbusinessorderdataid());
		if(data == null || data.getAuditstatus() != 2){//仅能删除驳回的项中的详细信息
			return 426;
		}
		//删除图片
		FileUploadUtil.deleteImg(config.LOCALUPLOADPATH_ORIGINAL+detail.getUrl(), config.LOCALUPLOADPATH_MOBILE+detail.getUrl(), config.LOCALUPLOADPATH_PC+detail.getUrl());
		//删除数据
		isocBusinessOrderDataDetailDao.deleteByPrimaryKey(isocbusinessorderdatadetailid);
		return 1;
	}

	@Override
	public int addIsocBusinessOrderDataDetail(IsocBusinessOrderDataDetail detail, int type) {
		if(type == 0){//企业认证详细
			IsocBusinessOrder order = isocBusinessOrderDao.findByIsocbusinessorderdataid(detail.getIsocbusinessorderdataid());
			if(order == null || order.getAuditstatus() != 2){
				return 426;
			}
		}else if(type == 1){//护理员认证详细
			EmployeeIdentificationOrder order = employeeIdentificationOrderDao.findByIsocbusinessorderdataid(detail.getIsocbusinessorderdataid());
			if(order == null || (order.getIdentificationstatus() != 1 && order.getIdentificationstatus() != 3)){
				return 426;
			}
		}
		IsocBusinessOrderData data = isocBusinessOrderDataDao.selectByPrimaryKey(detail.getIsocbusinessorderdataid());
		if(data == null || data.getAuditstatus() != 2){
			return 426;
		}
		isocBusinessOrderDataDetailDao.insert(detail);
		return -detail.getIsocbusinessorderdatadetailid();
	}

	@Override
	public int reApply(int isocbusinessorderid) {
		IsocBusinessOrder order = isocBusinessOrderDao.selectByPrimaryKey(isocbusinessorderid);
		if(order == null || order.getAuditstatus() != 2){
			return 426;
		}
		order.setAuditstatus(0);
		List<IsocBusinessOrderData> datas = isocBusinessOrderDataDao.findByRelationidAndType(isocbusinessorderid, 0);
		for (int i = 0;i < datas.size(); i++) {
			if(datas.get(i).getAuditstatus() == 2){
				datas.get(i).setAuditstatus(0);
				isocBusinessOrderDataDao.updateByPrimaryKey(datas.get(i));
			}else {
				Util.callBackT();
				return 426;
			}
		}
		isocBusinessOrderDao.updateByPrimaryKey(order);
		return 1;
	}

	@Override
	public List<IsocEmpowerExtend> findIsocEmpower(User user) {
		List<IsocEmpowerExtend> isocList = isocDao.findIsocEmpowerByBusinessid(user.getRole().getRelationid());
		return isocList;
	}
}
