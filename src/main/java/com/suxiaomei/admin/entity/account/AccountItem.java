package com.suxiaomei.admin.entity.account;

import java.io.Serializable;


/**
 * 
 * @ClassName:     AccountItem.java
 * @Description:    账户详情表
 * @author         JenpoLee
 * @version        V1.0  
 * @Date           2018年4月20日 上午10:25:27
 */
public class AccountItem implements Serializable{
	private int accountitemid; //账户详情id 自增
	private int accountid; //账户id
	private String serialnumber; //流水号
	private int type; //类型：  1 一般订单     2 预定金订单  0 无订单关联 3护理员扣款
	private Integer relationid; // 关联id： type1 一般订单      type2 预定金订单
	private double quantity; // 金额
	private String recorddate; // 获取时间
	private String reason; // 获取原因
	private String salesman;//交易对象
	private int balanceflag;//结算类型 0 未结算 1已结算
	private String balancetime;//结算时间
	private int auditstatus = 1;//0审核中 1审核通过 2审核驳回
	private int creator;//申请人/创建人 userid
	private int auditor;//审核人 userid
	private String remark = "";//备注
	private String result = "";//结果
	private int status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getAccountitemid() {
		return accountitemid;
	}
	public void setAccountitemid(int accountitemid) {
		this.accountitemid = accountitemid;
	}
	public int getAccountid() {
		return accountid;
	}
	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}
	public String getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Integer getRelationid() {
		return relationid;
	}
	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	public String getRecorddate() {
		return recorddate;
	}
	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public int getBalanceflag() {
		return balanceflag;
	}
	public void setBalanceflag(int balanceflag) {
		this.balanceflag = balanceflag;
	}
	public String getBalancetime() {
		return balancetime;
	}
	public void setBalancetime(String balancetime) {
		this.balancetime = balancetime;
	}
	public int getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public int getAuditor() {
		return auditor;
	}
	public void setAuditor(int auditor) {
		this.auditor = auditor;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
