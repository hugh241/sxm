package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 护理员工种
 * @author zl
 */
public class EmployeePosition extends BaseEntity{
	private int	employeepositionid;
	private int	employeeid;
	private int	type;//工种savevalue
	private String price = "0";//价格
	private String introduce = "";//个人介绍
	private String creditcardurl = "";//信誉卡地址
	private static final long serialVersionUID = 1L;
	public int getEmployeepositionid() {
		return employeepositionid;
	}
	public void setEmployeepositionid(int employeepositionid) {
		this.employeepositionid = employeepositionid;
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
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getCreditcardurl() {
		return creditcardurl;
	}
	public void setCreditcardurl(String creditcardurl) {
		this.creditcardurl = creditcardurl;
	}
}
