package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 销售机会 面试记录
 * @author zl
 */
public class SellChanceInterview implements Serializable{
	private int	sellchanceinterviewid;
	private int	employeeid;//阿姨id
	private int	sellchancescheduleid;//进度id
	private int	type;//面试方式 0门店面试 1视频面试
	private int	schedule;//面试进度 0准备面试 1结果待定 2面试成功 3面试失败 4面试失效
	private String date;//面试日期
	private String time;//面试时间
	private String remark = "";
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getSellchancescheduleid() {
		return sellchancescheduleid;
	}
	public void setSellchancescheduleid(int sellchancescheduleid) {
		this.sellchancescheduleid = sellchancescheduleid;
	}
	public int getSchedule() {
		return schedule;
	}
	public void setSchedule(int schedule) {
		this.schedule = schedule;
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
	public int getSellchanceinterviewid() {
		return sellchanceinterviewid;
	}
	public void setSellchanceinterviewid(int sellchanceinterviewid) {
		this.sellchanceinterviewid = sellchanceinterviewid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
}
