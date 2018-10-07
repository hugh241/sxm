package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 员工账号关联
 * @author zl
 */
public class EmployeeAccounts implements Serializable{
	private static final long serialVersionUID = 1L;
	private int employeeaccountsid;
	private int employeeid;
	private int accountsid;
	public int getEmployeeaccountsid() {
		return employeeaccountsid;
	}
	public void setEmployeeaccountsid(int employeeaccountsid) {
		this.employeeaccountsid = employeeaccountsid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getAccountsid() {
		return accountsid;
	}
	public void setAccountsid(int accountsid) {
		this.accountsid = accountsid;
	}
}
