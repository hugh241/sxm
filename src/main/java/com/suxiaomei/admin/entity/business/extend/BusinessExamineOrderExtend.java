package com.suxiaomei.admin.entity.business.extend;

import java.util.List;

import com.suxiaomei.admin.entity.business.BusinessExamineOrder;
import com.suxiaomei.admin.entity.business.BusinessOrderGoods;

public class BusinessExamineOrderExtend extends BusinessExamineOrder{
	private static final long serialVersionUID = 1L;
	private List<BusinessOrderGoods> businessOrderGoods;//企业订单产品
	private String businessname;//购买企业名称（这里是当前家协下的会员名称）
	private String isocname;//家协名称
	public List<BusinessOrderGoods> getBusinessOrderGoods() {
		return businessOrderGoods;
	}
	public void setBusinessOrderGoods(List<BusinessOrderGoods> businessOrderGoods) {
		this.businessOrderGoods = businessOrderGoods;
	}
	public String getBusinessname() {
		return businessname;
	}
	public void setBusinessname(String businessname) {
		this.businessname = businessname;
	}
	public String getIsocname() {
		return isocname;
	}
	public void setIsocname(String isocname) {
		this.isocname = isocname;
	}
}
