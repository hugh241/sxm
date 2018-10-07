package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 客户移除占有日志
 * @author zl
 */
public class CustomerAllotLog implements Serializable{
	private int	customerallotlogid;
	private int customerid;
	private int userid;
	private int type;//0新增并占有 1占有 2指派 3移出
	private String remark;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getCustomerallotlogid() {
		return customerallotlogid;
	}
	public void setCustomerallotlogid(int customerallotlogid) {
		this.customerallotlogid = customerallotlogid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
}
