package com.suxiaomei.admin.entity.customer;

import java.io.Serializable;
/**
 * 销售机会
 * @author zl
 */
public class SellChance implements Serializable{
	private int	sellchanceid;
	private int	customerid;
	private int	userid;
	private String name;//机会名称
	private String typestr;//机会类型字符串
	private int	schedule;//进度状态 0跟进中 1面试中 2签约中 3赢单 4输单
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getSellchanceid() {
		return sellchanceid;
	}
	public void setSellchanceid(int sellchanceid) {
		this.sellchanceid = sellchanceid;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypestr() {
		return typestr;
	}
	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}
	public int getSchedule() {
		return schedule;
	}
	public void setSchedule(int schedule) {
		this.schedule = schedule;
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
