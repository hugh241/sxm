package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;

/**
 * 订单评价 一个订单对应一个评价
 * @author zl
 */
public class ContractOrderEmployeeAssessment implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	contractorderemployeeassessmentid;
	private int	customerid;//客户id
	private int	employeeid;//员工id
	private int	contractorderid;//订单id
	private double assessmentresult;//评价平均分数
	private String assessmenttime;//评价日期
	private int	skill;//专业技能分数
	private int	health;//个人卫生分数
	private int	discuss;//沟通能力分数
	private int	lore;//知识指导分数
	private int	ethics;//职业道德分数
	private int	showstatus = 1;//展示状态 0默认不展示 1展示
	private int	assessmentstatus;//企业处理状态 0未处理 1已处理
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getContractorderemployeeassessmentid() {
		return contractorderemployeeassessmentid;
	}
	public void setContractorderemployeeassessmentid(
			int contractorderemployeeassessmentid) {
		this.contractorderemployeeassessmentid = contractorderemployeeassessmentid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getContractorderid() {
		return contractorderid;
	}
	public void setContractorderid(int contractorderid) {
		this.contractorderid = contractorderid;
	}
	public double getAssessmentresult() {
		return assessmentresult;
	}
	public void setAssessmentresult(double assessmentresult) {
		this.assessmentresult = assessmentresult;
	}
	public String getAssessmenttime() {
		return assessmenttime;
	}
	public void setAssessmenttime(String assessmenttime) {
		this.assessmenttime = assessmenttime;
	}
	public int getSkill() {
		return skill;
	}
	public void setSkill(int skill) {
		this.skill = skill;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDiscuss() {
		return discuss;
	}
	public void setDiscuss(int discuss) {
		this.discuss = discuss;
	}
	public int getLore() {
		return lore;
	}
	public void setLore(int lore) {
		this.lore = lore;
	}
	public int getEthics() {
		return ethics;
	}
	public void setEthics(int ethics) {
		this.ethics = ethics;
	}
	public int getShowstatus() {
		return showstatus;
	}
	public void setShowstatus(int showstatus) {
		this.showstatus = showstatus;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getAssessmentstatus() {
		return assessmentstatus;
	}
	public void setAssessmentstatus(int assessmentstatus) {
		this.assessmentstatus = assessmentstatus;
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
