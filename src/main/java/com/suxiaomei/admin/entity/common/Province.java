package com.suxiaomei.admin.entity.common;

import java.io.Serializable;
import java.util.List;
/**
 * 省
 * @author zl
 */
public class Province implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	provinceid;
	private String province;
	private List<City> cityList;
	public int getProvinceid() {
		return provinceid;
	}
	public void setProvinceid(int provinceid) {
		this.provinceid = provinceid;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public List<City> getCityList() {
		return cityList;
	}
	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}
}
