package com.suxiaomei.admin.service.account;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.UserExtend;

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
	 * 1.管理端登录
	 * @param user
	 * @return
	 */
	JSONObject findByUsernameAndPassword(User user);
	/**
	 * 注销当前登录用户
	 * 1.管理端注销
	 * @param cUser
	 * @return
	 */
	int logout(User user);
	/**
	 * 修改密码
	 * 1.管理端
	 * @param pp 
	 * @param user 当前登录账号
	 * @return
	 */
	int updatePassword(UserExtend pp, User cUser);
	/**
	 * 根据当前登录账号查询该账号所属系统下的所有普通用户列表（不查询管理员列表）
	 * 1.管理端 查询所有正常状态下的用户（不查询删除状态下的用户）
	 * @param user 当前登录账号
	 * @return
	 */
	List<User> findAll(User user);
	/**
	 * 新增用户账号
	 * 1.管理系统新增用户
	 * @param user
	 * @return
	 */
	int add(User user);
	/**
	 * 重置密码
	 * 1.管理系统用户管理
	 * @param user
	 * @return
	 */
	int resetPassword(UserExtend user);
	/**
	 * 修改用户状态
	 * 1.管理系统删除用户（将用户的状态设置为0）
	 * @param userid
	 * @param status
	 * @return
	 */
	int updateUserStatus(int userid, int status);
}
