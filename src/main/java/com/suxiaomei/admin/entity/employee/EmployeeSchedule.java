package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

public class EmployeeSchedule implements Serializable{
	private int	employeescheduleid;
	private int	employeeid;
	private int contractid;
	private int customerid;
	private int relationid;//关联id 预定金订单档期 普通订单档期 3企业id
	private int type;//1预定金档期 2普通订单档期 3自定义档期
	private String begindate;
	private String enddate;
	private String remark = "";
	private String name;//占用人
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public EmployeeSchedule(){}
	public EmployeeSchedule(int employeeid,String begindate,String enddate){
		this.status = 1;
		this.enddate = enddate;
		this.begindate = begindate;
		this.employeeid = employeeid;
	}
	public EmployeeSchedule(int employeescheduleid,int employeeid,String begindate,String enddate){
		this.status = 1;
		this.enddate = enddate;
		this.begindate = begindate;
		this.employeeid = employeeid;
		this.employeescheduleid = employeescheduleid;
	}
	public int getEmployeescheduleid() {
		return employeescheduleid;
	}
	public void setEmployeescheduleid(int employeescheduleid) {
		this.employeescheduleid = employeescheduleid;
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
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
