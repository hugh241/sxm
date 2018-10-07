package com.suxiaomei.admin.entity.business;

import java.io.Serializable;

/**
 * 企业购买订单的商品详细
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
public class BusinessOrderGoods implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	businessordergoodsid;
	private int	businessexamineorderid;
	private int	isocgoodsid;
	private int	num;
	private int	unitprice;
	private int	totalprice;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getBusinessordergoodsid() {
		return businessordergoodsid;
	}
	public void setBusinessordergoodsid(int businessordergoodsid) {
		this.businessordergoodsid = businessordergoodsid;
	}
	public int getBusinessexamineorderid() {
		return businessexamineorderid;
	}
	public void setBusinessexamineorderid(int businessexamineorderid) {
		this.businessexamineorderid = businessexamineorderid;
	}
	public int getIsocgoodsid() {
		return isocgoodsid;
	}
	public void setIsocgoodsid(int isocgoodsid) {
		this.isocgoodsid = isocgoodsid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(int unitprice) {
		this.unitprice = unitprice;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
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
