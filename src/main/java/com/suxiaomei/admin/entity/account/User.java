package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;

public class User extends BaseEntity {
	private int	userid;
	private int roleid;
	private String name;
	private String username;
	private String password = "";
	private String mobile;
	private String remark = "";//备注  企业员工账户时：如果需要该员工接收客户，则为1
	private Integer type;//当前账户类型
	private Role role;//角色
	private static final long serialVersionUID = 1L;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
