package com.suxiaomei.admin.entity.common;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * Banner
 * @author zl
 */
public class Banner extends BaseEntity{
	private int	bannerid;
	private int	type;//0pc 1小程序
	private String name = "";
	private String imgurl;//图片地址
	private String url;//跳转地址
	private int	sort;
	private String remark = "";
	private static final long serialVersionUID = 1L;
	public int getBannerid() {
		return bannerid;
	}
	public void setBannerid(int bannerid) {
		this.bannerid = bannerid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
