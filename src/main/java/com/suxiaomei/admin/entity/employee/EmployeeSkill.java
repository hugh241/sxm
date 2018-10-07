package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 员工技能
 * @author zl
 */
public class EmployeeSkill implements Serializable{
	private int	employeeskillid;
	private int	employeeid;
	private int	type;
	private int	skillnum;
	private int	level;
	private String learneddate;//进修时间
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public EmployeeSkill(){}
	public int getEmployeeskillid() {
		return employeeskillid;
	}
	public void setEmployeeskillid(int employeeskillid) {
		this.employeeskillid = employeeskillid;
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
	public int getSkillnum() {
		return skillnum;
	}
	public void setSkillnum(int skillnum) {
		this.skillnum = skillnum;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
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
	public String getLearneddate() {
		return learneddate;
	}
	public void setLearneddate(String learneddate) {
		this.learneddate = learneddate;
	}
	@Override
	public String toString() {
		return "EmployeeSkill [employeeskillid=" + employeeskillid
				+ ", employeeid=" + employeeid + ", type=" + type
				+ ", skillnum=" + skillnum + ", level=" + level
				+ ", learneddate=" + learneddate + ", status=" + status
				+ ", createtime=" + createtime + ", updatetime=" + updatetime
				+ "]";
	}
}
