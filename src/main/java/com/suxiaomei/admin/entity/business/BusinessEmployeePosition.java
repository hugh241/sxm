package com.suxiaomei.admin.entity.business;

import java.io.Serializable;

/**
 * 阿姨企业工种关联表
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
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
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
 * 2018年5月24日 下午5:13:37
 */
public class BusinessEmployeePosition implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	businessemployeepositionid;
	private int	businessemployeeid;//企业阿姨关联id
	private int	employeepositionid;//阿姨工种id
	private double price = 0.0;//工种价格
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getBusinessemployeepositionid() {
		return businessemployeepositionid;
	}
	public void setBusinessemployeepositionid(int businessemployeepositionid) {
		this.businessemployeepositionid = businessemployeepositionid;
	}
	public int getBusinessemployeeid() {
		return businessemployeeid;
	}
	public void setBusinessemployeeid(int businessemployeeid) {
		this.businessemployeeid = businessemployeeid;
	}
	public int getEmployeepositionid() {
		return employeepositionid;
	}
	public void setEmployeepositionid(int employeepositionid) {
		this.employeepositionid = employeepositionid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
