package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

public class IdentificationLog implements Serializable{
	private int	identificationlogid;
	private int	employeepositionid;
	private int	worktype;//工种savevalue
	private String operationtime;
	private String operationcontent;
	private String operationremark;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public IdentificationLog(){}
	public IdentificationLog(int employeepositionid,int worktype,String operationtime,String operationcontent,String operationremark){
		this.employeepositionid = employeepositionid;
		this.worktype = worktype;
		this.operationtime = operationtime;
		this.operationcontent = operationcontent;
		this.operationremark = operationremark;
	}
	public int getIdentificationlogid() {
		return identificationlogid;
	}
	public void setIdentificationlogid(int identificationlogid) {
		this.identificationlogid = identificationlogid;
	}
	public int getEmployeepositionid() {
		return employeepositionid;
	}
	public void setEmployeepositionid(int employeepositionid) {
		this.employeepositionid = employeepositionid;
	}
	public int getWorktype() {
		return worktype;
	}
	public void setWorktype(int worktype) {
		this.worktype = worktype;
	}
	public String getOperationtime() {
		return operationtime;
	}
	public void setOperationtime(String operationtime) {
		this.operationtime = operationtime;
	}
	public String getOperationcontent() {
		return operationcontent;
	}
	public void setOperationcontent(String operationcontent) {
		this.operationcontent = operationcontent;
	}
	public String getOperationremark() {
		return operationremark;
	}
	public void setOperationremark(String operationremark) {
		this.operationremark = operationremark;
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
