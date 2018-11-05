package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 家协二维码地址存储表 包括家协阿姨 和家协会员企业 二维码地址
 * @author zl
 */
public class IsocQrcode extends BaseEntity{
	private Integer	isocqrcodeid;
	private Integer	isocid;
	private Integer	relationid;
	private Integer	type;//1企业 2护理员
	private String qrcode;
	private static final long serialVersionUID = 1L;
	public Integer getIsocqrcodeid() {
		return isocqrcodeid;
	}
	public void setIsocqrcodeid(Integer isocqrcodeid) {
		this.isocqrcodeid = isocqrcodeid;
	}
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public Integer getRelationid() {
		return relationid;
	}
	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
}
