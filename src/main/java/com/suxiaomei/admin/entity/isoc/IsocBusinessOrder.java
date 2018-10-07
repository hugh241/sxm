package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 企业认证申请记录
 * @author zl
 */
public class IsocBusinessOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderid;
	private int	isocid;
	private Integer	businessid;
	private String level = "";//星级 1-5
	private String begindate = "0000-00-00";//开始时间
	private String enddate = "0000-00-00";//结束时间
	private String result = "";//反馈结果
	private int	auditstatus;//审核状态 0审核中 1审核通过 2驳回
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getIsocbusinessorderid() {
		return isocbusinessorderid;
	}
	public void setIsocbusinessorderid(int isocbusinessorderid) {
		this.isocbusinessorderid = isocbusinessorderid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public Integer getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
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
