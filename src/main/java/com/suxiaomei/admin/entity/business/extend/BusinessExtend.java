package com.suxiaomei.admin.entity.business.extend;

import java.util.List;

import com.suxiaomei.admin.entity.account.Contact;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.business.Business;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;

public class BusinessExtend extends Business{
	private static final long serialVersionUID = 1L;
	private Integer identificationstatus;//企业认证状态 1已认证 2未认证 ！1！2未知
	private User user;
	private List<IsocIdentificationBusinessExtend> isocBusinesses;
	private List<Contact> contacts;
	public Integer getIdentificationstatus() {
		return identificationstatus;
	}
	public void setIdentificationstatus(Integer identificationstatus) {
		this.identificationstatus = identificationstatus;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<IsocIdentificationBusinessExtend> getIsocBusinesses() {
		return isocBusinesses;
	}
	public void setIsocBusinesses(List<IsocIdentificationBusinessExtend> isocBusinesses) {
		this.isocBusinesses = isocBusinesses;
	}
	public List<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
}
