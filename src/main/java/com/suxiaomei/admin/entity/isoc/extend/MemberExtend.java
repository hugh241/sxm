package com.suxiaomei.admin.entity.isoc.extend;

import com.suxiaomei.admin.entity.isoc.Member;

public class MemberExtend extends Member{
	private static final long serialVersionUID = 1L;
	private String isocname;//家协名称
	public String getIsocname() {
		return isocname;
	}
	public void setIsocname(String isocname) {
		this.isocname = isocname;
	}
}
