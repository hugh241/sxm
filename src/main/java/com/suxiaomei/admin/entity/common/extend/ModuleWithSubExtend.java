package com.suxiaomei.admin.entity.common.extend;

import com.suxiaomei.admin.entity.common.Module;

public class ModuleWithSubExtend extends Module{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private int roleid;
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
}
