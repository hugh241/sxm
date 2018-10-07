package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 合同原件表
 * @author zl
 */
public class ContractChildbirth implements Serializable{
	private int	contractchildbirthid;
	private int	contractid;
	private String url;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getContractchildbirthid() {
		return contractchildbirthid;
	}
	public void setContractchildbirthid(int contractchildbirthid) {
		this.contractchildbirthid = contractchildbirthid;
	}
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
