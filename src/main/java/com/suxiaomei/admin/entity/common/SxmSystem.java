package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 系统表
 * @author zl
 */
public class SxmSystem implements Serializable{
	private int	sxmsystemid;
	private String name;
	private int	status;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getSxmsystemid() {
		return sxmsystemid;
	}

	public void setSxmsystemid(int sxmsystemid) {
		this.sxmsystemid = sxmsystemid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return "SxmSystem [sxmsystemid=" + sxmsystemid + ", name=" + name
				+ ", status=" + status + ", createtime=" + createtime
				+ ", updatetime=" + updatetime + "]";
	}
}
