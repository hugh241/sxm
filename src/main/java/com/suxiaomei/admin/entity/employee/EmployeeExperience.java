package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 工作经历
 * @author zl
 */
public class EmployeeExperience implements Serializable{
	private int	employeeexperienceid;
	private int	employeeid;
	private String begindate;
	private String enddate;
	private String name;
	private String mobile;
	private String remark;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public EmployeeExperience(){}
	public int getEmployeeexperienceid() {
		return employeeexperienceid;
	}
	public void setEmployeeexperienceid(int employeeexperienceid) {
		this.employeeexperienceid = employeeexperienceid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	@Override
	public String toString() {
		return "EmployeeExperience [employeeexperienceid="
				+ employeeexperienceid + ", employeeid=" + employeeid
				+ ", begindate=" + begindate + ", enddate=" + enddate
				+ ", name=" + name + ", mobile=" + mobile + ", remark="
				+ remark + ", status=" + status + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + "]";
	}
}
