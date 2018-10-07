package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 预定金订单
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
 * 2018年6月28日 下午5:52:07
 */
public class ContractDepositOrder implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	contractdepositorderid;
	private String ordernum;//订单号
	private int	contractid;//合同id
	private int	employeeid;//阿姨id
	private String startdate;//开始日期
	private String enddate;//结束日期
	private double price;//金额 单价
	private double money;//金额 总价 预定金金额
	private int	usestatus;//使用状态1已使用0未使用
	private int orderstatus;//预定金订单状态 0未付款 1已付款 2已完成 3已转换
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getContractdepositorderid() {
		return contractdepositorderid;
	}
	public void setContractdepositorderid(int contractdepositorderid) {
		this.contractdepositorderid = contractdepositorderid;
	}
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate != null && startdate.length()==21?startdate.substring(0, 19):startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate != null && enddate.length()==21?enddate.substring(0, 19):enddate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getUsestatus() {
		return usestatus;
	}
	public void setUsestatus(int usestatus) {
		this.usestatus = usestatus;
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
		this.createtime = createtime != null && createtime.length()==21?createtime.substring(0, 19):createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime != null && updatetime.length()==21?updatetime.substring(0, 19):updatetime;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
}
