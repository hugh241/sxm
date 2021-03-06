package com.suxiaomei.admin.entity.business;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 企业已购买的产品
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
public class BusinessGoods extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	businessgoodsid;//企业产品id
	private int	businessid;//企业id
	private int	isocgoodsid;//家协产品id
	private int	total;//购买数量
	private int	consume;//消耗数量
	public int getBusinessgoodsid() {
		return businessgoodsid;
	}
	public void setBusinessgoodsid(int businessgoodsid) {
		this.businessgoodsid = businessgoodsid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public int getIsocgoodsid() {
		return isocgoodsid;
	}
	public void setIsocgoodsid(int isocgoodsid) {
		this.isocgoodsid = isocgoodsid;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getConsume() {
		return consume;
	}
	public void setConsume(int consume) {
		this.consume = consume;
	}
}
