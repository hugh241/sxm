package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 区县
 * @author zl
 */
public class County implements Serializable{
	
	private int	countyid;
	private int	cityid;
	private String county;
	
	private static final long serialVersionUID = 1L;

	public int getCountyid() {
		return countyid;
	}

	public void setCountyid(int countyid) {
		this.countyid = countyid;
	}

	public int getCityid() {
		return cityid;
	}

	public void setCityid(int cityid) {
		this.cityid = cityid;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	@Override
	public String toString() {
		return "county [countyid=" + countyid + ", cityid=" + cityid
				+ ", county=" + county + "]";
	}
}
