package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

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
public class EmployeeCreditCard implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	employeecreditcardid;
	private int	employeeid;
	private int	isocid;
	private int	isocqrcodeid;//二维码id
	private String fronturl = "";//正面地址
	private String behindurl = "";//反面地址
	private String validitytime = "0000-00-00";//有效到期时间
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getEmployeecreditcardid() {
		return employeecreditcardid;
	}
	public void setEmployeecreditcardid(int employeecreditcardid) {
		this.employeecreditcardid = employeecreditcardid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public int getIsocqrcodeid() {
		return isocqrcodeid;
	}
	public void setIsocqrcodeid(int isocqrcodeid) {
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
