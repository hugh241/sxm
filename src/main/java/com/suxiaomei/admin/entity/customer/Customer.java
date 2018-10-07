package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 客户
 * @author zl
 */
public class Customer implements Serializable{
	private int	customerid;
	private int businessid;
	private String numbered;//客户编号 新增时间+整数
	private String name;
	private String idcard = "";
	private String birthday = "0000-00-00";
	private String nativeplace = "";
	private String mobile = "";
	private String wechat = "";//微信号
	private int source;//来源
	private int	sex;//性别 0：未知、1：男、2：女
	private String headurl = "";
	private String address = "";
	private String remark = "";//备注
	private int creator;//创建人
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getNumbered() {
		return numbered;
	}
	public void setNumbered(String numbered) {
		this.numbered = numbered;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
		if(this.birthday == null){
			this.birthday = "0000-00-00";
		}
	}
	public String getNativeplace() {
		return nativeplace;
	}
	public void setNativeplace(String nativeplace) {
		this.nativeplace = nativeplace;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getHeadurl() {
		return headurl;
	}
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public int getSource() {
		return source;
	}
	public void setSource(int source) {
		this.source = source;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
}
