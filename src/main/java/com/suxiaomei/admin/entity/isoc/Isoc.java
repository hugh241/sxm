package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 家协
 * @author zl
 */
public class Isoc extends BaseEntity{
	private int	isocid;
	private int	sxmsystemid = 5;
	private int addressid;
	private String name;//家协名称
	private String mobile = "";//联系电话
	private String logo = "";
	private String caddress = "";//联系地址
	private String email = "";//联系邮箱
	private String introduce = "";//企业简介
	private String appid = "";
	private String appsecret = "";
	private static final long serialVersionUID = 1L;
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public int getSxmsystemid() {
		return sxmsystemid;
	}
	public void setSxmsystemid(int sxmsystemid) {
		this.sxmsystemid = sxmsystemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getCaddress() {
		return caddress;
	}
	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getAppsecret() {
		return appsecret;
	}
	public void setAppsecret(String appsecret) {
		this.appsecret = appsecret;
	}
}
