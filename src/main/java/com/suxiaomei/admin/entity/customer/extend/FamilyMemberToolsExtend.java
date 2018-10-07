package com.suxiaomei.admin.entity.customer.extend;

import com.suxiaomei.admin.entity.customer.FamilyMemberTools;

public class FamilyMemberToolsExtend extends FamilyMemberTools{
	private static final long serialVersionUID = 1L;
	private String tool;//工具名称
	private String familymember;//成员名称
	public String getTool() {
		return tool;
	}
	public void setTool(String tool) {
		this.tool = tool;
	}
	public String getFamilymember() {
		return familymember;
	}
	public void setFamilymember(String familymember) {
		this.familymember = familymember;
	}
}
