package com.suxiaomei.admin.entity.common;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 产品
 * @author zl
 */
public class Goods extends BaseEntity{
	private int	goodsid;
	private String name;
	private int	price;
	private int	num;
	private int positionid;//工种positiontype savevalue值
	private String introduce;
	private static final long serialVersionUID = 1L;
	public int getGoodsid() {
		return goodsid;
	}
	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		return num;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getPositionid() {
		return positionid;
	}
	public void setPositionid(int positionid) {
		this.positionid = positionid;
	}
}
