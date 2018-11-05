package com.suxiaomei.admin.entity.isoc.extend;

import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.entity.isoc.IsocGoods;

public class IsocGoodsExtend extends IsocGoods{
	private static final long serialVersionUID = 1L;
	private Goods goods;//系统产品
	private int nums;//剩余总数
	private String name;//产品名称
	private int oPrice;//原价
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
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
	public int getoPrice() {
		return oPrice;
	}
	public void setoPrice(int oPrice) {
		this.oPrice = oPrice;
	}
}
