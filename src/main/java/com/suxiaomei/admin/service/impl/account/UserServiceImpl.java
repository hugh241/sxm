package com.suxiaomei.admin.service.impl.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.UserExtend;
import com.suxiaomei.admin.service.account.UserService;
import com.suxiaomei.admin.util.Md5;
import com.suxiaomei.admin.util.redis.TokenUtil;

import net.sf.json.JSONObject;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userDao;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private GlobalConfig config;

	@Override
	public JSONObject findByUsernameAndPassword(User user) {
		User u = userDao.selectByUsername(user.getUsername());
		if(u != null && u.getPassword().equals(Md5.Bit32(user.getUsername()+Md5.Bit32(user.getPassword())))){
			return takeCareLoginInfo(u);
		}
		return null;
	}

	@Override
	public int logout(User user) {
		TokenUtil.deleteToken(redisTemplate, user.getUsername());
		return 1;
	}

	@Override
	public int updatePassword(UserExtend pp, User cUser) {
		User user = userDao.selectByPrimaryKey(cUser.getUserid());
		if(pp.getOldPassword() != null && user.getPassword().equals(Md5.Bit32(user.getUsername()+Md5.Bit32(pp.getOldPassword())))){
			TokenUtil.deleteToken(redisTemplate, user.getUsername());
			user.setPassword(Md5.Bit32(user.getUsername()+Md5.Bit32(pp.getNewPassword())));
			return userDao.updateByPrimaryKeySelective(user);
		}
		return 2;
	}

	@Override
	public List<User> findAll(User user) {
		if(user.getRole().getType() == config.INT_SXM) {//查询所有正常状态的用户
			List<User> list = userDao.findNormalUserBySystemidAndTypeAndStatus(config.INT_SXM,config.INT_SXM,1);
			return list;
		}
		return null;
	}

	@Override
	public int add(User user) {
		//1.判断当前用户名是否存在
		User tU = userDao.selectByUsername(user.getUsername());
		if(tU != null){
			return 423;//存在当前新增用户名的用户
		}
		//2.判断手机号是否已注册
		if(user.getMobile() != null && !"".equals(user.getMobile())) {
			tU = userDao.findByMobile(user.getMobile());
			if(tU != null) {
				return 437;
			}
		}
		if(user.getRoleid() <= 0) {
			return 426;
		}
		//新增用户
		user.setPassword(Md5.Bit32(user.getUsername()+Md5.Bit32(user.getPassword())));
		if(user.getName() == null || "".equals(user.getName())) user.setName(user.getUsername());
		userDao.insertSelective(user);
		return 1;
	}

	@Override
	public int resetPassword(UserExtend user) {
		User tU = userDao.selectByPrimaryKey(user.getId());
		if(tU != null){
			tU.setPassword(Md5.Bit32(tU.getUsername()+Md5.Bit32(user.getNewPassword())));
			userDao.updateByPrimaryKeySelective(tU);
			TokenUtil.deleteToken(redisTemplate, user.getUsername());
			return 1;
		}
		return 426;
	}

	@Override
	public int updateUserStatus(int userid, int status) {
		User tU = userDao.selectByPrimaryKey(userid);
		if(tU != null){
			tU.setStatus(status);
			userDao.updateByPrimaryKeySelective(tU);
			return 1;
		}
		return 426;
	}

	@Override
	public JSONObject findByMobile(String mobile,int type) {
		User u = userDao.findByMobile(mobile);
		if(u != null) {
			if(type == 0) {
				return takeCareLoginInfo(u);
			}
			return JSONObject.fromObject(u);
		}
		return null;
	}
	/**
	 * 处理登录后的返回用户信息
	 * @param u
	 * @return
	 */
	public JSONObject takeCareLoginInfo(User u) {
		u.setType(u.getRole().getType());
		JSONObject json = JSONObject.fromObject(u);
		json.remove("password");
		//得到token,并将user信息保存到redis
		String token = TokenUtil.createUserToken(redisTemplate,u.getUsername(),u,config.TIMESTAMP.get(0));
		json.put("token", token);
		json.remove("handler");
		return json;
	}
}
