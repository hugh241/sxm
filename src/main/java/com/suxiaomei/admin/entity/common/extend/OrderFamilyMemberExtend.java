package com.suxiaomei.admin.entity.common.extend;

import com.suxiaomei.admin.entity.common.OrderFamilyMember;

public class OrderFamilyMemberExtend extends OrderFamilyMember{
	private static final long serialVersionUID = 1L;
	private String ordertype;//订单类型名称
	private String familymember;//系统成员名称
	public String getOrdertype() {
		return ordertype;
	}
	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	public String getFamilymember() {
		return familymember;
	}
	public void setFamilymember(String familymember) {
		this.familymember = familymember;
	}
}
