package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 护理员认证审核记录表
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
 * 2018年7月27日 下午1:23:29
 */
public class EmployeeIdentificationOrderRecord extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	employeeidentificationorderrecordid;
	private int	employeeidentificationorderid;
	private String result;
	public int getEmployeeidentificationorderrecordid() {
		return employeeidentificationorderrecordid;
	}
	public void setEmployeeidentificationorderrecordid(int employeeidentificationorderrecordid) {
		this.employeeidentificationorderrecordid = employeeidentificationorderrecordid;
	}
	public int getEmployeeidentificationorderid() {
		return employeeidentificationorderid;
	}
	public void setEmployeeidentificationorderid(int employeeidentificationorderid) {
		this.employeeidentificationorderid = employeeidentificationorderid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
