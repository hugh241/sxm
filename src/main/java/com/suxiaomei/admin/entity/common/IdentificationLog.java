package com.suxiaomei.admin.entity.common;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 工种操作记录
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年10月15日 下午5:50:19
 */
public class IdentificationLog extends BaseEntity{
	private int	identificationlogid;
	private int	employeepositionid;
	private int	worktype;//工种savevalue
	private String operationtime;
	private String operationcontent;
	private String operationremark;
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
}
