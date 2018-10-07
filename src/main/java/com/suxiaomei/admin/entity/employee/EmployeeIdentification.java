package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 护理员认证表
 * @author zl
 */
public class EmployeeIdentification extends BaseEntity{
	private int	employeeidentificationid;
	private int	employeeid;
	private int	isocid;
	private int	employeeidentificationorderid;
	private int	worktype;//goodsid
	private String adopttime;
	private String begindate;
	private String enddate;
	private static final long serialVersionUID = 1L;
	public int getEmployeeidentificationid() {
		return employeeidentificationid;
	}
	public void setEmployeeidentificationid(int employeeidentificationid) {
		this.employeeidentificationid = employeeidentificationid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public int getEmployeeidentificationorderid() {
		return employeeidentificationorderid;
	}
	public void setEmployeeidentificationorderid(int employeeidentificationorderid) {
		this.employeeidentificationorderid = employeeidentificationorderid;
	}
	public int getWorktype() {
		return worktype;
	}
	public void setWorktype(int worktype) {
		this.worktype = worktype;
	}
	public String getAdopttime() {
		return adopttime;
	}
	public void setAdopttime(String adopttime) {
		this.adopttime = adopttime;
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
}
