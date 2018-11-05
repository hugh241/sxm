package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 渠道或介绍人分成比例配置
 * @author zl
 */
public class IntroducerConfig extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	introducerconfigid;
	private int	type;//0 介绍人配置 1渠道配置
	private int	relationid;//介绍人或渠道id
	private int tcts;//增员提成天数，默认0天
	private int zjstcts;//转介绍提成天数
	private int	icdeploy;//客户分成设置 0每单分成 1首单分成
	private int	ictype;//客户分成方式 0比例分成 1定额分成
	private double icquota = 0.0;//客户分成比例或定额额度
	private int	iedeploy;//阿姨分成设置 0每单分成 1首单分成
	private int	ietype = 0;//阿姨分成方式 0比例分成 1定额分成
	private double iequota = 0.0;//阿姨分成比例或定额额度
	public int getIntroducerconfigid() {
		return introducerconfigid;
	}
	public void setIntroducerconfigid(int introducerconfigid) {
		this.introducerconfigid = introducerconfigid;
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
	public int getIcdeploy() {
		return icdeploy;
	}
	public void setIcdeploy(int icdeploy) {
		this.icdeploy = icdeploy;
	}
	public int getIctype() {
		return ictype;
	}
	public void setIctype(int ictype) {
		this.ictype = ictype;
	}
	public int getIedeploy() {
		return iedeploy;
	}
	public void setIedeploy(int iedeploy) {
		this.iedeploy = iedeploy;
	}
	public int getIetype() {
		return ietype;
	}
	public void setIetype(int ietype) {
		this.ietype = ietype;
	}
	public double getIcquota() {
		return icquota;
	}
	public void setIcquota(double icquota) {
		this.icquota = icquota;
	}
	public double getIequota() {
		return iequota;
	}
	public void setIequota(double iequota) {
		this.iequota = iequota;
	}
	public int getTcts() {
		return tcts;
	}
	public void setTcts(int tcts) {
		this.tcts = tcts;
	}
	public int getZjstcts() {
		return zjstcts;
	}
	public void setZjstcts(int zjstcts) {
		this.zjstcts = zjstcts;
	}
}
