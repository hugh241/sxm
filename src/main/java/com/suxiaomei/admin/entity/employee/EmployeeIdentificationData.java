package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;
/**
 * 护理员认证资料表
 * @author zl
 */
public class EmployeeIdentificationData implements Serializable{
	private int	employeeidentificationdataid;
	private int	employeeidentificationorderid;
	private int	type;//1身份证 2职业资格证 3体检证明
	private String name;
	private String content = "";
	private String url;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getEmployeeidentificationdataid() {
		return employeeidentificationdataid;
	}
	public void setEmployeeidentificationdataid(int employeeidentificationdataid) {
		this.employeeidentificationdataid = employeeidentificationdataid;
	}
	public int getEmployeeidentificationorderid() {
		return employeeidentificationorderid;
	}
	public void setEmployeeidentificationorderid(int employeeidentificationorderid) {
		this.employeeidentificationorderid = employeeidentificationorderid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
