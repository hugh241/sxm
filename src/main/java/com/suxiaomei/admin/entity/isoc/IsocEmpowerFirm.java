package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 家协授权单位
 * @author zl
 *
 */
public class IsocEmpowerFirm extends BaseEntity{
	private int	isocempowerfirmid;
	private int	isocid;
	private Integer businessid;
	private String name;
	private int	type;//授权单位类型 0 家协本身单位 1家协创建单位
	private String corporations = "";//负责人
	private String mobile = "";//联系电话
	private static final long serialVersionUID = 1L;
	public IsocEmpowerFirm(){}
	/**
	 * 构造家协自己授权企业
	 * @param isocid
	 * @param name
	 * @param corporations
	 */
	public IsocEmpowerFirm(int isocid,String name){
		this.isocid = isocid;
		this.name = name;
		this.type = 0;
	}
	/**
	 * 构造一般授权企业
	 * @param isocid
	 * @param businessid
	 * @param name
	 * @param corporations
	 */
	public IsocEmpowerFirm(int isocid,int businessid,String name){
		this.isocid = isocid;
		this.businessid = businessid;
		this.name = name;
		this.type = 1;
	}
	public int getIsocempowerfirmid() {
		return isocempowerfirmid;
	}
	public void setIsocempowerfirmid(int isocempowerfirmid) {
		this.isocempowerfirmid = isocempowerfirmid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCorporations() {
		return corporations;
	}
	public void setCorporations(String corporations) {
		this.corporations = corporations;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public Integer getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Integer businessid) {
		this.businessid = businessid;
	}
}
