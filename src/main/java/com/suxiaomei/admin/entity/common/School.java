package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 培训机构
 * @author zl
 */
public class School implements Serializable{
	private int	schoolid;
	private String name;//名称
	private int	addressid;//地址编号
	private String detailedaddress;//详细地址
	private String mobile;//联系电话
	private String corporation;//负责人
	private String license;//营业执照
	private String dutyparagraph;//税号
	private String logo;//logo
	private String accredittime;//授权时间
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	
	public int getSchoolid() {
		return schoolid;
	}
	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public String getDetailedaddress() {
		return detailedaddress;
	}
	public void setDetailedaddress(String detailedaddress) {
		this.detailedaddress = detailedaddress;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCorporation() {
		return corporation;
	}
	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getDutyparagraph() {
		return dutyparagraph;
	}
	public void setDutyparagraph(String dutyparagraph) {
		this.dutyparagraph = dutyparagraph;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "school [schoolid=" + schoolid + ", name=" + name
				+ ", addressid=" + addressid + ", detailedaddress="
				+ detailedaddress + ", mobile=" + mobile + ", corporation="
				+ corporation + ", license=" + license + ", dutyparagraph="
				+ dutyparagraph + ", logo=" + logo + ", accredittime="
				+ accredittime + ", status=" + status + ", createtime="
				+ createtime + ", updatetime=" + updatetime + "]";
	}
}
