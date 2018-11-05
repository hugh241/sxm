package com.suxiaomei.admin.entity.business;

import com.suxiaomei.admin.entity.BaseEntity;

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
public class BusinessOrderGoods extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	businessordergoodsid;
	private int	businessexamineorderid;//购买订单id
	private int	isocgoodsid;//家协产品id
	private int	num;//购买数量
	private int	unitprice;//单价
	private int	totalprice;//总价
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
}
