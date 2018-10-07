package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;
/**
 * 护理员认证订单
 * @author zl
 */
public class EmployeeIdentificationOrder implements Serializable{
	private int	employeeidentificationorderid;
	private String ordernum;
	private int	employeeid;
	private int	businessid;
	private int	isocempowerfirmid;
	private Integer employeecheckid;//背调id
	private String worktype;//保存家协产品id字符串，逗号隔开
	private int	identificationstatus = 0;//0首次提交 1第一次驳回 2第二次提交 3第二次驳回 4第三次提交 5第三次驳回 6认证通过
	private String adopttime = "0000-00-00";
	private String result = "";
	private String remark = "";
	private String school = "";//培训学校
	private double exercisesscore = 0.0;//理论分数
	private double theoryscore = 0.0;//实操分数
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getEmployeeidentificationorderid() {
		return employeeidentificationorderid;
	}
	public void setEmployeeidentificationorderid(int employeeidentificationorderid) {
		this.employeeidentificationorderid = employeeidentificationorderid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public int getIsocempowerfirmid() {
		return isocempowerfirmid;
	}
	public void setIsocempowerfirmid(int isocempowerfirmid) {
		this.isocempowerfirmid = isocempowerfirmid;
	}
	public String getWorktype() {
		return worktype;
	}
	public void setWorktype(String worktype) {
		this.worktype = worktype;
	}
	public int getIdentificationstatus() {
		return identificationstatus;
	}
	public void setIdentificationstatus(int identificationstatus) {
		this.identificationstatus = identificationstatus;
	}
	public String getAdopttime() {
		return adopttime;
	}
	public void setAdopttime(String adopttime) {
		this.adopttime = adopttime;
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
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Integer getEmployeecheckid() {
		return employeecheckid;
	}
	public void setEmployeecheckid(Integer employeecheckid) {
		this.employeecheckid = employeecheckid;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getExercisesscore() {
		return exercisesscore;
	}
	public void setExercisesscore(double exercisesscore) {
		this.exercisesscore = exercisesscore;
	}
	public double getTheoryscore() {
		return theoryscore;
	}
	public void setTheoryscore(double theoryscore) {
		this.theoryscore = theoryscore;
	}
}
