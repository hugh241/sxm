package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 企业认证申请订单
 * @author zl
 */
public class IsocBusinessOrder extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderid;
	private Integer	isocid;
	private Integer type;//0企业 1培训学校
	private Integer	businessid;
	private String level = "";//星级 1-5
	private String begindate = "0000-00-00";//开始时间
	private String enddate = "0000-00-00";//结束时间
	private String result = "";//反馈结果
	private Integer	auditstatus;//审核状态 0审核中 1审核通过 2驳回
	public int getIsocbusinessorderid() {
		return isocbusinessorderid;
	}
	public void setIsocbusinessorderid(int isocbusinessorderid) {
		this.isocbusinessorderid = isocbusinessorderid;
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
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public Integer getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(Integer auditstatus) {
		this.auditstatus = auditstatus;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
