package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;

/**
 * 销售机会跟新记录
 * @author zl
 */
public class SellChanceAbutment implements Serializable{
	private int	sellchanceabutmentid;
	private int	sellchancescheduleid;//销售机会进度id
	private String	typestr;//跟进类型
	private String abutmenttime;//跟进时间
	private String remark;//跟进备注
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getSellchanceabutmentid() {
		return sellchanceabutmentid;
	}
	public void setSellchanceabutmentid(int sellchanceabutmentid) {
		this.sellchanceabutmentid = sellchanceabutmentid;
	}
	public int getSellchancescheduleid() {
		return sellchancescheduleid;
	}
	public void setSellchancescheduleid(int sellchancescheduleid) {
		this.sellchancescheduleid = sellchancescheduleid;
	}
	public String getTypestr() {
		return typestr;
	}
	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}
	public String getAbutmenttime() {
		return abutmenttime;
	}
	public void setAbutmenttime(String abutmenttime) {
		this.abutmenttime = abutmenttime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
