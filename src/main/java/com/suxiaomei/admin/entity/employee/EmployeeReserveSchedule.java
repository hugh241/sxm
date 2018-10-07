package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 员工档期预定关联
 * @author zl
 *
 */
public class EmployeeReserveSchedule implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	employeereservescheduleid;
	private int	customerreserveid;
	private int	employeescheduleid;
	public EmployeeReserveSchedule(){}
	public EmployeeReserveSchedule(int customerreserveid,int employeescheduleid){
		this.customerreserveid = customerreserveid;
		this.employeescheduleid = employeescheduleid;
	}
	public int getEmployeereservescheduleid() {
		return employeereservescheduleid;
	}
	public void setEmployeereservescheduleid(int employeereservescheduleid) {
		this.employeereservescheduleid = employeereservescheduleid;
	}
	public int getCustomerreserveid() {
		return customerreserveid;
	}
	public void setCustomerreserveid(int customerreserveid) {
		this.customerreserveid = customerreserveid;
	}
	public int getEmployeescheduleid() {
		return employeescheduleid;
	}
	public void setEmployeescheduleid(int employeescheduleid) {
		this.employeescheduleid = employeescheduleid;
	}
}
