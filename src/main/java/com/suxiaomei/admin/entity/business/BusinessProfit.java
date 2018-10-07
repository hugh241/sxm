package com.suxiaomei.admin.entity.business;

import java.io.Serializable;

/**
 * 
 * @ClassName: BusinessProfit.java
 * @Description: 企业现金流及利润统计表
 * 
 * @author JenpoLee
 * @version V1.0
 * @Date 2018年4月28日 下午3:33:04
 */
public class BusinessProfit implements Serializable {
	private int businessprofitid;
	private int businessid; // 企业id
	private Integer accountitemid; // 账户详情id
	private Integer relationid; // 来源类型 0一般订单id 1预定金订单id 2会费id 3.null
	private Integer sourcetype; // 来源类型 0一般订单 1预定金订单 2会费 3.第三方结算
	private String recorddate;// 记账日期
	private int type;// 类型 1为现金流记录 2为利润记录
	private double quantity;// 金额
	private String reason;// 交易类型 文字和账户详情一致
	private int paymentstype;// 收支类型 金额正数为收 金额负数为支 1为收 2为支
	private String salesman;// 交易对象 文字
	private String serialnumber;// 流水号
	private int status = 1;// 状态1有效0无效
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public BusinessProfit() {
		super();
	}

	public BusinessProfit(int businessprofitid, int businessid, Integer accountitemid, Integer relationid, Integer sourcetype, String recorddate, int type, double quantity,
			String reason, int paymentstype, String salesman, String serialnumber, int status, String createtime, String updatetime) {
		super();
		this.businessprofitid = businessprofitid;
		this.businessid = businessid;
		this.accountitemid = accountitemid;
		this.relationid = relationid;
		this.sourcetype = sourcetype;
		this.recorddate = recorddate;
		this.type = type;
		this.quantity = quantity;
		this.reason = reason;
		this.paymentstype = paymentstype;
		this.salesman = salesman;
		this.serialnumber = serialnumber;
		this.status = status;
		this.createtime = createtime;
		this.updatetime = updatetime;
	}

	public int getBusinessprofitid() {
		return businessprofitid;
	}

	public void setBusinessprofitid(int businessprofitid) {
		this.businessprofitid = businessprofitid;
	}

	public int getBusinessid() {
		return businessid;
	}

	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}

	public Integer getAccountitemid() {
		return accountitemid;
	}

	public void setAccountitemid(Integer accountitemid) {
		this.accountitemid = accountitemid;
	}

	public Integer getRelationid() {
		return relationid;
	}

	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}

	public Integer getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(Integer sourcetype) {
		this.sourcetype = sourcetype;
	}

	public String getRecorddate() {
		return recorddate;
	}

	public void setRecorddate(String recorddate) {
		this.recorddate = recorddate;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getPaymentstype() {
		return paymentstype;
	}

	public void setPaymentstype(int paymentstype) {
		this.paymentstype = paymentstype;
	}

	public String getSalesman() {
		return salesman;
	}

	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}

	public String getSerialnumber() {
		return serialnumber;
	}

	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
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
