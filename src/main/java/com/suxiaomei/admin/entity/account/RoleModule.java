package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 角色模块关联表
 * @author zl
 */
public class RoleModule extends BaseEntity{
	private int	rolemoduleid;
	private int	roleid;
	private int	moduleid;
	private static final long serialVersionUID = 1L;
	public int getRolemoduleid() {
		return rolemoduleid;
	}
	public void setRolemoduleid(int rolemoduleid) {
		this.rolemoduleid = rolemoduleid;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
}
