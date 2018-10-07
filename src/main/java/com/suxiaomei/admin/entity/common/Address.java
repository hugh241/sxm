package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 地址
 * @author zl
 */
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	addressid;
	private Integer	provinceid;//省
	private Integer	cityid;//市
	private Integer	countyid;//区县
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
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
	public Integer getCountyid() {
		return countyid;
	}
	public void setCountyid(Integer countyid) {
		this.countyid = countyid;
	}
//	public String getProvince() {
//		return province;
//	}
//	public void setProvince(String province) {
//		this.province = province;
//	}
//	public String getCity() {
//		return city;
//	}
//	public void setCity(String city) {
//		this.city = city;
//	}
//	public String getCounty() {
//		return county;
//	}
//	public void setCounty(String county) {
//		this.county = county;
//	}
}
