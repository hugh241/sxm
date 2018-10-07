package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 员工家庭信息
 * @author zl
 */
public class EmployeeFamily implements Serializable{
	private int	employeefamilyid;
	private int	employeeid;
	private int	relation;
	private String name;
	private String birthday;
	private int	education;
	private String work;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public EmployeeFamily(){}
	public int getEmployeefamilyid() {
		return employeefamilyid;
	}
	public void setEmployeefamilyid(int employeefamilyid) {
		this.employeefamilyid = employeefamilyid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getRelation() {
		return relation;
	}
	public void setRelation(int relation) {
		this.relation = relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getEducation() {
		return education;
	}
	public void setEducation(int education) {
		this.education = education;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
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
	@Override
	public String toString() {
		return "EmployeeFamily [employeefamilyid=" + employeefamilyid
				+ ", employeeid=" + employeeid + ", relation=" + relation
				+ ", name=" + name + ", birthday=" + birthday + ", education="
				+ education + ", work=" + work + ", status=" + status
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ "]";
	}
}
