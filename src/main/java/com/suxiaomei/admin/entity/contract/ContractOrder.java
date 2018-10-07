package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 合同订单
 * @author zl
 */
public class ContractOrder implements Serializable{
	private int	contractorderid;
	private int	contractid;
	private String begindate;//开始时间
	private String enddate;//结束时间
	private int holiday;//假期
	private int employeeid;
	private double salary;//服务每月工资
	private int checkouttype = 1;//结算方式 1带薪休假 2工作日结算
	private int	whenlong;//工资每月计算天数
	private int wagestype = 1;//阿姨工资结算方式 1比例分成 2固定工资
	private double wages = 0.00;//阿姨实际每月工资 如果时比例以2位数记，计算时除以100
	private double totalsalary = 0.0;//阿姨总工资
	private double servicecharge;//服务金额（天工资乘以世纪天数）
	private double specialservicecharge;//特别服务金额
	private double totalamount;//订单总金额
	private double receivedmoney;//实收金额
	private int type;//0月嫂订单 1育儿嫂订单
	private String ordernum;
	private int	orderstatus;//-1待审核 0待付款 1已付款 2已完成 3已关闭 4已驳回
	private int auditstatus = 1;//是否需要审核 0不需要 1需要
	private String remark = "";//备注
	private int auditingstatus;
	private int updownstatus;//上下户状态 0初始状态 1可上户 2已上户 3可下户 4已下户
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getContractorderid() {
		return contractorderid;
	}
	public void setContractorderid(int contractorderid) {
		this.contractorderid = contractorderid;
	}
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public int getWhenlong() {
		return whenlong;
	}
	public void setWhenlong(int whenlong) {
		this.whenlong = whenlong;
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
	public int getHoliday() {
		return holiday;
	}
	public void setHoliday(int holiday) {
		this.holiday = holiday;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getCheckouttype() {
		return checkouttype;
	}
	public void setCheckouttype(int checkouttype) {
		this.checkouttype = checkouttype;
	}
	public int getWagestype() {
		return wagestype;
	}
	public void setWagestype(int wagestype) {
		this.wagestype = wagestype;
	}
	public double getWages() {
		return wages;
	}
	public void setWages(double wages) {
		this.wages = wages;
	}
	public double getServicecharge() {
		return servicecharge;
	}
	public void setServicecharge(double servicecharge) {
		this.servicecharge = servicecharge;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public double getSpecialservicecharge() {
		return specialservicecharge;
	}
	public void setSpecialservicecharge(double specialservicecharge) {
		this.specialservicecharge = specialservicecharge;
	}
	public double getTotalsalary() {
		return totalsalary;
	}
	public void setTotalsalary(double totalsalary) {
		this.totalsalary = totalsalary;
	}
	public double getReceivedmoney() {
		return receivedmoney;
	}
	public void setReceivedmoney(double receivedmoney) {
		this.receivedmoney = receivedmoney;
	}
	public int getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
	}
	public int getAuditingstatus() {
		return auditingstatus;
	}
	public void setAuditingstatus(int auditingstatus) {
		this.auditingstatus = auditingstatus;
	}
	public int getUpdownstatus() {
		return updownstatus;
	}
	public void setUpdownstatus(int updownstatus) {
		this.updownstatus = updownstatus;
	}
}
