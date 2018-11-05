package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 介绍人
 * @author zl
 */
public class Introducer extends BaseEntity{
	private int	introducerid;
	private Integer businessparamsid;//渠道编号
	private String name;
	private String mobile = "";
	private Integer parentid;//介绍人
	private int type;//0一般机构 1阿姨 2客户 3公司 4其他
	private int relationid;//关联id
	private static final long serialVersionUID = 1L;
	public int getIntroducerid() {
		return introducerid;
	}
	public void setIntroducerid(int introducerid) {
		this.introducerid = introducerid;
	}
	public Integer getBusinessparamsid() {
		return businessparamsid;
	}
	public void setBusinessparamsid(Integer businessparamsid) {
		this.businessparamsid = businessparamsid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Integer getParentid() {
		return parentid;
	}
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
}
