package com.suxiaomei.admin.entity.isoc.extend;

import com.suxiaomei.admin.entity.isoc.IsocIdentificationBusiness;

public class IsocIdentificationBusinessExtend extends IsocIdentificationBusiness{
	private static final long serialVersionUID = 1L;
	private String isocname;
	private String businessname;
	private String mobile;//会员单位联系电话
	public String getIsocname() {
		return isocname;
	}
	public void setIsocname(String isocname) {
		this.isocname = isocname;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
