package com.suxiaomei.admin.service.account;

import java.util.List;

import com.suxiaomei.admin.entity.account.Role;
import com.suxiaomei.admin.entity.account.User;

public interface RoleService {
	/**
	 * 根据当前登录用户查询该用户所属系统下的普通角色列表
	 * @param cUser
	 * @return
	 */
	List<Role> findNormalRoleByCUser(User cUser);
	/**
	 * 根据当前登录账号新增角色
	 * @param role
	 * @param user
	 * @return
	 */
	int add(Role role, User user);
	/**
	 * 修改角色
	 * @param role
	 * @return
	 */
	int update(Role role);
	/**
	 * 删除角色，根据角色id将角色设置为删除状态，并将角色下的所有用户设置未删除状态
	 * @param roleId
	 * @return
	 */
	int delete(int roleId);

}
