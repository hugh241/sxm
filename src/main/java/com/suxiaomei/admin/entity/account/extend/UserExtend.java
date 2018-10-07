package com.suxiaomei.admin.entity.account.extend;

import com.suxiaomei.admin.entity.account.User;

public class UserExtend extends User{
	private static final long serialVersionUID = 1L;
	private int id;
	private String newPassword;//新密码
	private String oldPassword;//旧密码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
}
