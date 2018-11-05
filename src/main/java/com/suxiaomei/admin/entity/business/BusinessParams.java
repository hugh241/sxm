package com.suxiaomei.admin.entity.business;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 企业配置类别信息
 * @author zl
 */
public class BusinessParams extends BaseEntity{
	private int	businessparamsid;
	private int	businessid;//企业编号
	private int	type;//1渠道 2 销售机会 3 合同类型 4 工作组 5移出原因 6输单原因 7移出天数配置（每个系统最多1条）8渠道来源 9增员奖励分层层级 10转介绍奖励分层层级 11.收款渠道
	private String name;//名称
	private int	isdefault;//1是 0不是
	private String vkey = "";//如果为渠道的情况下 0普通 1客户转介绍 2阿姨转介绍 3其他  移出天数：天数 增员转介绍层级：层级
	private String value = "";
	private static final long serialVersionUID = 1L;
	public int getBusinessparamsid() {
		return businessparamsid;
	}
	public void setBusinessparamsid(int businessparamsid) {
		this.businessparamsid = businessparamsid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsdefault() {
		return isdefault;
	}
	public void setIsdefault(int isdefault) {
		this.isdefault = isdefault;
	}
	public String getVkey() {
		return vkey;
	}
	public void setVkey(String vkey) {
		this.vkey = vkey;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
