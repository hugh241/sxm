package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 家协购买产品订单-每个产品购买的详细
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
 * 2018年7月27日 上午10:48:28
 */
public class IsocOrderGoods extends BaseEntity{
	private int	isocordergoodsid;
	private int	isocexamineorderid;
	private int	goodsid;
	private int	num;//购买数量
	private int	unitprice;//单价
	private int	totalprice;//总价
	private static final long serialVersionUID = 1L;
	public int getIsocordergoodsid() {
		return isocordergoodsid;
	}
	public void setIsocordergoodsid(int isocordergoodsid) {
		this.isocordergoodsid = isocordergoodsid;
	}
	public int getIsocexamineorderid() {
		return isocexamineorderid;
	}
	public void setIsocexamineorderid(int isocexamineorderid) {
		this.isocexamineorderid = isocexamineorderid;
	}
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
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
