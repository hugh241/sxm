package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.Module;

/**
 * 菜单管理模块
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
 * 2018年9月25日 下午1:05:57
 */
public interface ModuleService {
	/**
	 * 根据当前登录账号查询出当前角色的功能菜单
	 * 1.管理端菜单查询
	 * @param cUser
	 * @return
	 */
	List<Module> getMenu(User cUser);
	/**
	 * 根据角色、模块查询该角色是否有当前模块的权限
	 * 1.后台登录拦截器调用
	 * @param role
	 * @param module
	 * @return
	 */
	boolean isRight(Role role, String module);
	/**
	 * 更具角色id查询该角色系统下的所有菜单，并查询出该角色是否对菜单有权限
	 * 1.管理端角色管理
	 * @param id
	 * @return module List :check is true has right
	 */
	List<Module> getAllModulesByRoleid(int id);
}
