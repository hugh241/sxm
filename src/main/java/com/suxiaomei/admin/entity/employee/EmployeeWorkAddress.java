package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 工作地址
 * @author zl
 */
public class EmployeeWorkAddress implements Serializable{
	private int	employeeworkaddressid;
	private int	addressid;
	private int	employeeid;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public EmployeeWorkAddress(){}
	public EmployeeWorkAddress(int addressid, int employeeid, int i) {
		this.addressid = addressid;
		this.employeeid = employeeid;
		this.status = i;
	}
	public int getEmployeeworkaddressid() {
		return employeeworkaddressid;
	}
	public void setEmployeeworkaddressid(int employeeworkaddressid) {
		this.employeeworkaddressid = employeeworkaddressid;
	}
	public int getAddressid() {
		return addressid;
	}
	public void setAddressid(int addressid) {
		this.addressid = addressid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
		return "EmployeeWorkAddress [employeeworkaddressid="
				+ employeeworkaddressid + ", addressid=" + addressid
				+ ", employeeid=" + employeeid + ", status=" + status
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ "]";
	}
}
