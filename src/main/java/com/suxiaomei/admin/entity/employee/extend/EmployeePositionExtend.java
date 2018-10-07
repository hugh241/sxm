package com.suxiaomei.admin.entity.employee.extend;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.suxiaomei.admin.entity.employee.EmployeePosition;

@JsonIgnoreProperties(value = {"handler"})
public class EmployeePositionExtend extends EmployeePosition{
	private static final long serialVersionUID = 1L;
	private String positionName;//工种名称
	private EmployeeIdentificationExtend employeeIdentification;//该工种最新有效的认证记录
	public String getPositionName() {
		return positionName;
	}
	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}
	public EmployeeIdentificationExtend getEmployeeIdentification() {
		return employeeIdentification;
	}
	public void setEmployeeIdentification(EmployeeIdentificationExtend employeeIdentification) {
		this.employeeIdentification = employeeIdentification;
	}
}
