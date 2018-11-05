package com.suxiaomei.admin.entity.business.extend;

import com.suxiaomei.admin.entity.business.BusinessGoods;

public class BusinessGoodsExtend extends BusinessGoods{
	private static final long serialVersionUID = 1L;
	private int nums;//剩余总数
	private String name;//产品名称
	private int price;//价格
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
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
}
