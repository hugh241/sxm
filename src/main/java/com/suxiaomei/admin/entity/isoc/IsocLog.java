package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

public class IsocLog implements Serializable{
	private int	isoclogid;
	private String date;
	private String ip;
	private String remark;
	private String commite;
	private int	response_date;
	private int	status = 1;
	private String	createtime;
	private String	updatetime;
	private static final long serialVersionUID = 1L;
	public int getIsoclogid() {
		return isoclogid;
	}
	public void setIsoclogid(int isoclogid) {
		this.isoclogid = isoclogid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getCommite() {
		return commite;
	}
	public void setCommite(String commite) {
		this.commite = commite;
	}
	public int getResponse_date() {
		return response_date;
	}
	public void setResponse_date(int response_date) {
		this.response_date = response_date;
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
