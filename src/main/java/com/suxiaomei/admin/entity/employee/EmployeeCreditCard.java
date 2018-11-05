package com.suxiaomei.admin.entity.employee;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 员工信誉卡
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年8月13日 下午5:40:05
 */
public class EmployeeCreditCard extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer	employeecreditcardid;
	private Integer	employeeid;
	private Integer	isocid;
	private Integer	isocqrcodeid;//二维码id
	private String fronturl = "";//正面地址
	private String behindurl = "";//反面地址
	private String validitytime = "0000-00-00";//有效到期时间
	public Integer getEmployeecreditcardid() {
		return employeecreditcardid;
	}
	public void setEmployeecreditcardid(Integer employeecreditcardid) {
		this.employeecreditcardid = employeecreditcardid;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public Integer getIsocqrcodeid() {
		return isocqrcodeid;
	}
	public void setIsocqrcodeid(Integer isocqrcodeid) {
		this.isocqrcodeid = isocqrcodeid;
	}
	public String getFronturl() {
		return fronturl;
	}
	public void setFronturl(String fronturl) {
		this.fronturl = fronturl;
	}
	public String getBehindurl() {
		return behindurl;
	}
	public void setBehindurl(String behindurl) {
		this.behindurl = behindurl;
	}
	public String getValiditytime() {
		return validitytime;
	}
	public void setValiditytime(String validitytime) {
		this.validitytime = validitytime;
	}
}
