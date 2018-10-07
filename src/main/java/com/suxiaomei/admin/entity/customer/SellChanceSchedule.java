package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 销售机会进度记录
 * @author zl
 */
public class SellChanceSchedule implements Serializable{
	private int	sellchancescheduleid;
	private int	sellchanceid;
	private int	schedule;//进度状态 0跟进中 1面试中 2签约中 3赢单 4输单
	private String remark = "";//备注
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
	public int getSellchanceid() {
		return sellchanceid;
	}
	public void setSellchanceid(int sellchanceid) {
		this.sellchanceid = sellchanceid;
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
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
