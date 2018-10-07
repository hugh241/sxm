package com.suxiaomei.admin.entity.employee.extend;

import com.suxiaomei.admin.entity.employee.EmployeeIdentification;

public class EmployeeIdentificationExtend extends EmployeeIdentification{
	private static final long serialVersionUID = 1L;
	private String isocname;//认证的家协名称
	public String getIsocname() {
		return isocname;
	}
	public void setIsocname(String isocname) {
		this.isocname = isocname;
	}
}
