package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;
/**
 * 阿姨账号申述表
 * @author zl
 */
public class EmployeeAppeal implements Serializable{
	private int employeeappealid;
	private int employeeid;
	private String appealtime;
	private String newname;
	private String newidcard;
	private int status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getEmployeeappealid() {
		return employeeappealid;
	}
	public void setEmployeeappealid(int employeeappealid) {
		this.employeeappealid = employeeappealid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getAppealtime() {
		return appealtime;
	}
	public void setAppealtime(String appealtime) {
		this.appealtime = appealtime;
	}
	public String getNewname() {
		return newname;
	}
	public void setNewname(String newname) {
		this.newname = newname;
	}
	public String getNewidcard() {
		return newidcard;
	}
	public void setNewidcard(String newidcard) {
		this.newidcard = newidcard;
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
