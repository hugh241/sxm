package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 联系人
 * @author zl
 */
public class Contact extends BaseEntity{
	private int	contactid;
	private int type;//3企业 5家协
	private int relationid;//家协id或企业id
	private String name;
	private String phone;
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
}
