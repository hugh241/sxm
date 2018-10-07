package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 城市之家
 * @author zl
 */
public class CityFamily implements Serializable{
	private int	cityfamilyid;
	private int	addressid;
	private String detailedaddress;//详细地址
	private String longitude;//经度
	private String latitude;//维度
	private String mobile;
	private String director;//负责人
	private String createdate;//创建时间
	private String summary;//简介
	private int	bedtotal;//床位数
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getCityfamilyid() {
		return cityfamilyid;
	}
	public void setCityfamilyid(int cityfamilyid) {
		this.cityfamilyid = cityfamilyid;
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
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public int getBedtotal() {
		return bedtotal;
	}
	public void setBedtotal(int bedtotal) {
		this.bedtotal = bedtotal;
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
}
