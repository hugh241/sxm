package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 照片审核记录
 * @author zl
 *
 */
public class EmployeePhotoAuditing implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	employeephotoauditingid;
	private int	employeephotoid;
	private String content;
	private int	result;
	private int	status;
	private String createtime;
	private String updatetime;
	public int getEmployeephotoauditingid() {
		return employeephotoauditingid;
	}
	public void setEmployeephotoauditingid(int employeephotoauditingid) {
		this.employeephotoauditingid = employeephotoauditingid;
	}
	public int getEmployeephotoid() {
		return employeephotoid;
	}
	public void setEmployeephotoid(int employeephotoid) {
		this.employeephotoid = employeephotoid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
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
