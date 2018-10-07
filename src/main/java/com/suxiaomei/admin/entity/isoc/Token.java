package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;

public class Token extends BaseEntity{
	private int	tokenid;
	private int	isocid;
	private String tokenname = "access_token";
	private String tokenvalue = "";
	private static final long serialVersionUID = 1L;
	public int getTokenid() {
		return tokenid;
	}
	public void setTokenid(int tokenid) {
		this.tokenid = tokenid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public String getTokenname() {
		return tokenname;
	}
	public void setTokenname(String tokenname) {
		this.tokenname = tokenname;
	}
	public String getTokenvalue() {
		return tokenvalue;
	}
	public void setTokenvalue(String tokenvalue) {
		this.tokenvalue = tokenvalue;
	}
}
