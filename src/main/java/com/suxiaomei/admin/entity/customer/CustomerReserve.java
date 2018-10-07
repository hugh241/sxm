package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 客户预定
 * @author zl
 */
public class CustomerReserve implements Serializable{
	private int	customerreserveid;
	private Integer	customerid;
	private int	employeeid;
	private int	type;//0月嫂
	private String fullname = "";
	private String mobile = "";
	private String deposit;
	private String proofnum = "";
	private String recordperson;
	private String begindate;
	private String enddate;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getCustomerreserveid() {
		return customerreserveid;
	}
	public void setCustomerreserveid(int customerreserveid) {
		this.customerreserveid = customerreserveid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getProofnum() {
		return proofnum;
	}
	public void setProofnum(String proofnum) {
		this.proofnum = proofnum;
	}
	public String getRecordperson() {
		return recordperson;
	}
	public void setRecordperson(String recordperson) {
		this.recordperson = recordperson;
	}
	public Integer getCustomerid() {
		return customerid;
	}
	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
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
	@Override
	public String toString() {
		return "CustomerReserve [customerreserveid=" + customerreserveid
				+ ", customerid=" + customerid + ", employeeid=" + employeeid
				+ ", type=" + type + ", fullname=" + fullname + ", mobile="
				+ mobile + ", deposit=" + deposit + ", proofnum=" + proofnum
				+ ", recordperson=" + recordperson + ", begindate=" + begindate
				+ ", enddate=" + enddate + ", status=" + status
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ "]";
	}
}
