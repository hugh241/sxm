package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;
/**
 * 家协二维码地址存储表 包括家协阿姨 和家协会员企业 二维码地址
 * @author zl
 */
public class IsocQrcode implements Serializable{
	private int	isocqrcodeid;
	private int	isocid;
	private int	relationid;
	private int	type;//1企业 2护理员
	private String qrcode;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getIsocqrcodeid() {
		return isocqrcodeid;
	}
	public void setIsocqrcodeid(int isocqrcodeid) {
		this.isocqrcodeid = isocqrcodeid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
