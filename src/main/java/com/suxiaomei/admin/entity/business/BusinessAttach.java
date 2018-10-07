package com.suxiaomei.admin.entity.business;

import java.io.Serializable;

/**
 * 订单附加项
 * @author zl
 */
public class BusinessAttach implements Serializable{
	private int	businessattachid;
	private int	businessid;
	private String name;//附加项名称
	private int	checkouttype = 1;//结算方式1指定金额2指定比例
	private double percentage;//提成金额/比例
	private int	timestype = 1;//计时方式1指定天数2和订单一致
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getBusinessattachid() {
		return businessattachid;
	}
	public void setBusinessattachid(int businessattachid) {
		this.businessattachid = businessattachid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCheckouttype() {
		return checkouttype;
	}
	public void setCheckouttype(int checkouttype) {
		this.checkouttype = checkouttype;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public int getTimestype() {
		return timestype;
	}
	public void setTimestype(int timestype) {
		this.timestype = timestype;
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
