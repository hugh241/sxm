package com.suxiaomei.admin.entity.business;

import java.io.Serializable;
/**
 * 工作组员工关联记录
 * @author zl
 */
public class BusinessWorkGroupUsers implements Serializable{
	private int	businessworkgroupusersid;
	private int	businessparamsid;
	private int	userid;
	private int	type;//0组员 1组长
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getBusinessworkgroupusersid() {
		return businessworkgroupusersid;
	}
	public void setBusinessworkgroupusersid(int businessworkgroupusersid) {
		this.businessworkgroupusersid = businessworkgroupusersid;
	}
	public int getBusinessparamsid() {
		return businessparamsid;
	}
	public void setBusinessparamsid(int businessparamsid) {
		this.businessparamsid = businessparamsid;
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
