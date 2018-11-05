package com.suxiaomei.admin.entity.common;

import java.io.Serializable;
import java.util.List;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 系统模块
 * @author zl
 */
public class Module extends BaseEntity implements Serializable,Comparable<Module> {
	private int	moduleid;
	private int	parentid;
	private int sxmsystemid;//1苏小妹后台 2城市之家 3企业 4培训机构 5家协
	private String name;
	private String icon;
	private String color;
	private int	sort;
	private String url;
	private int type;//类型 0菜单类型 1按钮类型
	private int isautomatic;//是否自动给对应系统下管理员角色授权 0需要权限 1自动为管理员添加
	private List<Module> childsList;
	private boolean check = false;
	private static final long serialVersionUID = 1L;
	public int getModuleid() {
		return moduleid;
	}
	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}
	public int getParentid() {
		return parentid;
	}
	public void setParentid(int parentid) {
		this.parentid = parentid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getSxmsystemid() {
		return sxmsystemid;
	}
	public void setSxmsystemid(int sxmsystemid) {
		this.sxmsystemid = sxmsystemid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getIsautomatic() {
		return isautomatic;
	}
	public void setIsautomatic(int isautomatic) {
		this.isautomatic = isautomatic;
	}
	public List<Module> getChildsList() {
		return childsList;
	}
	public void setChildsList(List<Module> childsList) {
		this.childsList = childsList;
	}
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Module){
			return ((Module)obj).getModuleid() == this.moduleid;
		}
		return false;
	}
	@Override
	public int compareTo(Module m) {
		return this.sort - m.sort;
	}
}
