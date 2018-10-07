package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;

import com.suxiaomei.admin.entity.account.User;

public class CustomerUser implements Serializable{
	private int	customeruserid;
	private int	customerid;
	private int	userid;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	private User user;
	public int getCustomeruserid() {
		return customeruserid;
	}
	public void setCustomeruserid(int customeruserid) {
		this.customeruserid = customeruserid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
