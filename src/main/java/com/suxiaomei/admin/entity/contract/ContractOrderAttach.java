package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;

public class ContractOrderAttach implements Serializable{
	private static final long serialVersionUID = 1L;
	private int contractorderattachid;
	private int contractorderid;//订单id
	private int businessattachid;//附加项id
	private double price;//单价
	private double total;//总价
	private int times;//时长/天数
	private double percentage;//提成比例 两位整数，计算时除以100
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getContractorderattachid() {
		return contractorderattachid;
	}
	public void setContractorderattachid(int contractorderattachid) {
		this.contractorderattachid = contractorderattachid;
	}
	public int getContractorderid() {
		return contractorderid;
	}
	public void setContractorderid(int contractorderid) {
		this.contractorderid = contractorderid;
	}
	public int getBusinessattachid() {
		return businessattachid;
	}
	public void setBusinessattachid(int businessattachid) {
		this.businessattachid = businessattachid;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
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
