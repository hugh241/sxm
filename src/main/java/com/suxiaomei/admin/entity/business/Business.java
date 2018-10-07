package com.suxiaomei.admin.entity.business;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 母婴商户
 * @author zl
 */
public class Business extends BaseEntity{
	private int	businessid;
	private int sxmsystemid = 3;
	private String fullname = "";//商家全名
	private String shortname = "";//简称
	private String corporations = "";//法人
	private String license = "";//印业执照
	private String phone = "";//联系电话
	private String address = "";//地址
	private String email = "";//邮箱
	private String logo = "";//头像
	private String url = "";//网址
	private String summary = "";//简介
	private String accredittime = "0000-00-00";//授权时间
	private static final long serialVersionUID = 1L;
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname != null?fullname:"";
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getCorporations() {
		return corporations;
	}
	public void setCorporations(String corporations) {
		this.corporations = corporations;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone != null ? phone : "";
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAccredittime() {
		return accredittime;
	}
	public void setAccredittime(String accredittime) {
		this.accredittime = accredittime;
	}
	public int getSxmsystemid() {
		return sxmsystemid;
	}
	public void setSxmsystemid(int sxmsystemid) {
		this.sxmsystemid = sxmsystemid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address != null ? address : "";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email != null ? email : "";
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url != null ? url : "";
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary != null ? summary : "";
	}
}
