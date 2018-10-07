package com.suxiaomei.admin.service.account;

import com.suxiaomei.admin.common.paramer.UserParamer;
import com.suxiaomei.admin.entity.account.User;

import net.sf.json.JSONObject;
/**
 * 用户账号
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
 * 2018年9月19日 下午4:13:36
 */
public interface UserService {
	/**
	 * 根据用户名、密码查询用户信息
	 * @param user
	 * @return
	 */
	JSONObject findByUsernameAndPassword(User user);
	/**
	 * 注销当前登录用户
	 * @param cUser
	 * @return
	 */
	int logout(User user);
	/**
	 * 修改密码
	 * @param pp 
	 * @param user 当前登录账号
	 * @return
	 */
	int updatePassword(UserParamer pp, User cUser);
}
