package com.suxiaomei.admin.service.impl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.common.paramer.UserParamer;
import com.suxiaomei.admin.dao.account.RoleMapper;
import com.suxiaomei.admin.dao.account.UserMapper;
import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;
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
	private RoleMapper roleDao;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private GlobalConfig config;

	@Override
	public JSONObject findByUsernameAndPassword(User user) {
		User u = userDao.selectByUsername(user.getUsername());
		if(u != null && u.getPassword().equals(Md5.Bit32(user.getUsername()+Md5.Bit32(user.getPassword())))){
			Role role = roleDao.selectByPrimaryKey(u.getRoleid());
			if(user.getType() != role.getType()) {
				return null;
			}
			u.setRole(role);
			u.setType(role.getType());
			JSONObject json = JSONObject.fromObject(u);
			json.remove("password");
			//得到token,并将user信息保存到redis
			String token = TokenUtil.createUserToken(redisTemplate,u.getUsername(),u,config.USERINFOSAVETIME);
			json.put("token", token);
			return json;
		}
		return null;
	}

	@Override
	public int logout(User user) {
		TokenUtil.deleteToken(redisTemplate, user.getUsername());
		return 1;
	}

	@Override
	public int updatePassword(UserParamer pp, User cUser) {
		User user = userDao.selectByPrimaryKey(cUser.getUserid());
		if(pp.getOldPassword() != null && user.getPassword().equals(Md5.Bit32(user.getUsername()+Md5.Bit32(pp.getOldPassword())))){
			TokenUtil.deleteToken(redisTemplate, user.getUsername());
			user.setPassword(Md5.Bit32(user.getUsername()+Md5.Bit32(pp.getNewPassword())));
			return userDao.updateByPrimaryKeySelective(user);
		}
		return 2;
	}
}
