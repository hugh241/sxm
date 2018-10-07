package com.suxiaomei.admin.entity.account;

import java.math.BigDecimal;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 账户表（员工、企业、客户）
 * 员工默认账户为身份证号 密码为身份证后6位
 * @author zl
 */
public class Account extends BaseEntity{
	private Integer accountid;
    private Integer introducerid;//介绍人id
    private Byte type;//0普通账户 1预定金账户
    private String accountnum;//阿姨：businessid+idcard 客户：businessid+mobile+/0正常账户/1预定金账户  一般介绍人：name 企业：username
    private String password;//阿姨：身份证后6为 客户：手机号后六位 一般介绍人：name 企业：password
    private BigDecimal balance;//账户余额
	private static final long serialVersionUID = 1L;
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Integer getIntroducerid() {
		return introducerid;
	}
	public void setIntroducerid(Integer introducerid) {
		this.introducerid = introducerid;
	}
	public Byte getType() {
		return type;
	}
	public void setType(Byte type) {
		this.type = type;
	}
	public String getAccountnum() {
		return accountnum;
	}
	public void setAccountnum(String accountnum) {
		this.accountnum = accountnum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
