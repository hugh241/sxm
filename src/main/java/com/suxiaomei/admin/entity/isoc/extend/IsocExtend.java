package com.suxiaomei.admin.entity.isoc.extend;

import com.suxiaomei.admin.entity.isoc.Isoc;

public class IsocExtend extends Isoc{
	private static final long serialVersionUID = 1L;
	private String username;//家协账号名称
	private String address;//分校范围
	private Integer provinceid;//省id
	private Integer cityid;//市id
	private String password;//密码
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}
	public Integer getCityid() {
		return cityid;
	}
	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
