package com.suxiaomei.admin.entity.account;

import java.io.Serializable;

/**
 * 联系人
 * @author zl
 */
public class Contact implements Serializable{
	private int	contactid;
	private int type;//3企业 5家协
	private int relationid;
	private String name;
	private String phone;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
