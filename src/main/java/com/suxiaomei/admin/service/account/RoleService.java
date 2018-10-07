package com.suxiaomei.admin.service.account;

import java.util.List;

import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.account.extend.RoleModuleExtend;

public interface RoleService {
	/**
	 * 根据当前登录用户查询该用户所属系统下的普通角色列表
	 * 1.管理端角色管理
	 * @param cUser
	 * @return
	 */
	List<Role> findNormalRoleByCUser(User cUser);
	/**
	 * 根据当前登录账号新增角色
	 * 1.管理端角色管理
	 * @param role
	 * @param user
	 * @return
	 */
	int add(Role role, User user);
	/**
	 * 修改角色
	 * 1.管理端角色管理
	 * @param role
	 * @return
	 */
	int update(Role role);
	/**
	 * 删除角色，根据角色id将角色设置为删除状态，并将角色下的所有用户设置未删除状态
	 * 1.管理端角色管理
	 * @param roleId
	 * @return
	 */
	int delete(int roleId);
	/**
	 * 跟新角色权限
	 * 1.管理端角色管理
	 * @param roleModule
	 * @return
	 */
	int updateImpower(RoleModuleExtend roleModule);

}
