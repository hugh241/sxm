package com.suxiaomei.admin.entity.business;

import java.io.Serializable;

/**
 * 数据字典表
 * @author zl
 */
public class BusinessEmployee implements Serializable{
	private int	businessemployeeid;
	private int	businessid;
	private int	employeeid;
	private String entrydate = "0000-00-00";//入职时间
	private String quitdate = "0000-00-00";//离职时间
	private int creator;
	private int showstatus = 0;//健康状态展示状态 0展示 1系统不展示 2客户经理不展示
	private String lastshowtime;//最后活跃日期
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public BusinessEmployee(){}
	public BusinessEmployee(int businessid,int employeeid,String entrydate,int showstatus){
		this.businessid = businessid;
		this.employeeid = employeeid;
		this.entrydate = entrydate==null?"0000-00-00":entrydate;
		this.quitdate = "0000-00-00";
		this.showstatus = showstatus;
	}
	public int getBusinessemployeeid() {
		return businessemployeeid;
	}
	public void setBusinessemployeeid(int businessemployeeid) {
		this.businessemployeeid = businessemployeeid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate==null?"0000-00-00":entrydate;
	}
	public String getQuitdate() {
		return quitdate;
	}
	public void setQuitdate(String quitdate) {
		this.quitdate = quitdate==null?"0000-00-00":quitdate;
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
	public int getShowstatus() {
		return showstatus;
	}
	public void setShowstatus(int showstatus) {
		this.showstatus = showstatus;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public String getLastshowtime() {
		return lastshowtime;
	}
	public void setLastshowtime(String lastshowtime) {
		this.lastshowtime = lastshowtime==null?"0000-00-00":lastshowtime;
	}
}
