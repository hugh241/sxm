package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 合同
 * @author zl
 */
public class Contract implements Serializable{
	private int	contractid;
	private int	sellchancescheduleid;//进度id
	private String signdate;//签订时间
	private String contractnum;//合同编号
	private String begindate;//开始日期
	private String enddate;//结束日期
	private String name;//客户姓名
	private String mobile;//客户电话
	private String idcard;//客户身份证号
	private String address;//服务地址
	private int	contractstatus;//0执行中 1已关闭
	private String typestr;//合同类型
	private String remark = "";
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getContractid() {
		return contractid;
	}
	public void setContractid(int contractid) {
		this.contractid = contractid;
	}
	public int getSellchancescheduleid() {
		return sellchancescheduleid;
	}
	public void setSellchancescheduleid(int sellchancescheduleid) {
		this.sellchancescheduleid = sellchancescheduleid;
	}
	public String getSigndate() {
		return signdate;
	}
	public void setSigndate(String signdate) {
		this.signdate = signdate;
	}
	public String getContractnum() {
		return contractnum;
	}
	public void setContractnum(String contractnum) {
		this.contractnum = contractnum;
	}
	public String getBegindate() {
		return begindate;
	}
	public void setBegindate(String begindate) {
		this.begindate = begindate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public int getContractstatus() {
		return contractstatus;
	}
	public void setContractstatus(int contractstatus) {
		this.contractstatus = contractstatus;
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
		this.createtime = createtime != null && createtime.length()==21?createtime.substring(0, 19):createtime;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime != null && updatetime.length()==21?updatetime.substring(0, 19):updatetime;
	}
	public String getTypestr() {
		return typestr;
	}
	public void setTypestr(String typestr) {
		this.typestr = typestr;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
