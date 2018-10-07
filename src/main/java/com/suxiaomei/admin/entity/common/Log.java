package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

public class Log implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//编号
	private String userid;//登陆账号+id
	private String module;//执行模块
	private String method;//执行的方法
	private String responseData;//响应时间
	private String ip;//ip地址
	private String date;//执行时间
	private String commite;//执行描述
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getResponseData() {
		return responseData;
	}
	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCommite() {
		return commite;
	}
	public void setCommite(String commite) {
		this.commite = commite;
	}
}
