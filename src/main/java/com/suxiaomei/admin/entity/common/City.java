package com.suxiaomei.admin.entity.common;

import java.io.Serializable;
import java.util.List;
/**
 * 城市
 * @author zl
 */
public class City implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	cityid;
	private int	provinceid;
	private String city;
	private List<County> countyList;
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<County> getCountyList() {
		return countyList;
	}
	public void setCountyList(List<County> countyList) {
		this.countyList = countyList;
	}
}
