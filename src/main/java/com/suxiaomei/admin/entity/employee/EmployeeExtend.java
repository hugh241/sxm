package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 员工延伸信息
 * @author zl
 */
public class EmployeeExtend implements Serializable{
	private static final long serialVersionUID = 1L;
	private int employeeextendid;
	private int employeeid;
	private String workinglife = "0000-00-00";
	private int servicenum;
	public int getEmployeeextendid() {
		return employeeextendid;
	}
	public void setEmployeeextendid(int employeeextendid) {
		this.employeeextendid = employeeextendid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getWorkinglife() {
		return workinglife;
	}
	public void setWorkinglife(String workinglife) {
		this.workinglife = workinglife;
	}
	public int getServicenum() {
		return servicenum;
	}
	public void setServicenum(int servicenum) {
		this.servicenum = servicenum;
	}
}
