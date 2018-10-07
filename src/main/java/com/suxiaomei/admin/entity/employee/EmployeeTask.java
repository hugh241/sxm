package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;
/**
 * 上下户记录
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
 * 2018年6月29日 下午2:34:09
 */
public class EmployeeTask implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	employeetaskid;
	private int	employeeid;
	private int	customerid;
	private int contractorderid;//订单id
	private int	type;//1上户 2下户
	private int ordertype;//0月嫂 1育儿嫂
	private int	confirmstatus;//确认状态  上户：0未确认 1已确认 2已驳回 3已完成 下户：0未确认 1已确认
	private String confirmtime = "0000-00-00 00:00:00";//确定/驳回时间
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getEmployeetaskid() {
		return employeetaskid;
	}
	public void setEmployeetaskid(int employeetaskid) {
		this.employeetaskid = employeetaskid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getConfirmstatus() {
		return confirmstatus;
	}
	public void setConfirmstatus(int confirmstatus) {
		this.confirmstatus = confirmstatus;
	}
	public String getConfirmtime() {
		return confirmtime;
	}
	public void setConfirmtime(String confirmtime) {
		this.confirmtime = confirmtime;
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
	public int getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(int ordertype) {
		this.ordertype = ordertype;
	}
	public int getContractorderid() {
		return contractorderid;
	}
	public void setContractorderid(int contractorderid) {
		this.contractorderid = contractorderid;
	}
}
