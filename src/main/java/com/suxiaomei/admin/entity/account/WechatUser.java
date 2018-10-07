package com.suxiaomei.admin.entity.account;

import java.io.Serializable;

/**
 * 微信账号
 * @author zl
 * @param <T>
 */
public class WechatUser implements Serializable{
	private int	wechatuserid;
	private String openId;
	private String nickname;
	private int	sex;//性别 0：未知、1：男、2：女
	private String city;
	private String province;
	private String country;
	private String headimgurl;
	private String unionid;
	private int	status = 1;
	private String	createtime;
	private String	updatetime;
	private static final long serialVersionUID = 1L;
	public int getWechatuserid() {
		return wechatuserid;
	}
	public void setWechatuserid(int wechatuserid) {
		this.wechatuserid = wechatuserid;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getUnionid() {
		return unionid;
	}
	public void setUnionid(String unionid) {
		this.unionid = unionid;
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
