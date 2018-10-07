package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 客户预约
 * @author zl
 */
public class CustomerBespeak implements Serializable{
	private int	customerbespeakid;
	private int	customerid;
	private int	employeeid;
	private String fullname;
	private String mobile;
	private String begindate;
	private String enddate;
	private String predate;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getCustomerbespeakid() {
		return customerbespeakid;
	}
	public void setCustomerbespeakid(int customerbespeakid) {
		this.customerbespeakid = customerbespeakid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
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
	public String getPredate() {
		return predate;
	}
	public void setPredate(String predate) {
		this.predate = predate;
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
		return "CustomerBespeak [customerbespeakid=" + customerbespeakid
				+ ", customerid=" + customerid + ", employeeid=" + employeeid
				+ ", fullname=" + fullname + ", mobile=" + mobile
				+ ", begindate=" + begindate + ", enddate=" + enddate
				+ ", predate=" + predate + ", status=" + status
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ "]";
	}
}
