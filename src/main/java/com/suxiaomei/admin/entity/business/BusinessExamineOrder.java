package com.suxiaomei.admin.entity.business;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 企业向家协购买产品的订单
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
 * 2018年8月9日 下午12:01:11
 */
public class BusinessExamineOrder extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	businessexamineorderid;
	private Integer businessid;
	private Integer	isocid;
	private String ordernum;
	private int	totalprice;//总价
	private int	concessionalprice;//优惠价
	private String paytime = "0000-00-00 00:00:00";//通过/付款时间
	private int	orderstatus;//0 审核中 1审核通过
	public int getBusinessexamineorderid() {
		return businessexamineorderid;
	}
	public void setBusinessexamineorderid(int businessexamineorderid) {
		this.businessexamineorderid = businessexamineorderid;
	}
	public Integer getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getConcessionalprice() {
		return concessionalprice;
	}
	public void setConcessionalprice(int concessionalprice) {
		this.concessionalprice = concessionalprice;
	}
	public String getPaytime() {
		return paytime;
	}
	public void setPaytime(String paytime) {
		this.paytime = paytime;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
}
