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
import com.suxiaomei.admin.dao.isoc.IsocBusinessDataConfigureMapper;
import com.suxiaomei.admin.dao.isoc.IsocEmpowerFirmMapper;
import com.suxiaomei.admin.dao.isoc.IsocMapper;
import com.suxiaomei.admin.dao.isoc.TokenMapper;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Address;
import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.IsocBusinessDataConfigure;
import com.suxiaomei.admin.entity.isoc.IsocEmpowerFirm;
import com.suxiaomei.admin.entity.isoc.Token;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;
import com.suxiaomei.admin.service.isoc.IsocService;
import com.suxiaomei.admin.util.Md5;
import com.suxiaomei.admin.util.QueryResult;
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
}
