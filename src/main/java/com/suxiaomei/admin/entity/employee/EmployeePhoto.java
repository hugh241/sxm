package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 员工照片
 * @author zl
 */
public class EmployeePhoto extends BaseEntity{
	private int	employeephotoid;
	private Integer	employeeid;
	private String photoname;
	private String photourl;//当前路径
	private String shortUrl = "";//历史路劲
	private Integer	type;//0头像 1生活照 2证件照
	private Integer auditingstatus;//0待审核 1 审核通过 2驳回
	private static final long serialVersionUID = 1L;
	public int getEmployeephotoid() {
		return employeephotoid;
	}
	public void setEmployeephotoid(int employeephotoid) {
		this.employeephotoid = employeephotoid;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public String getPhotoname() {
		return photoname;
	}
	public void setPhotoname(String photoname) {
		this.photoname = photoname;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getAuditingstatus() {
		return auditingstatus;
	}
	public void setAuditingstatus(Integer auditingstatus) {
		this.auditingstatus = auditingstatus;
	}
}
