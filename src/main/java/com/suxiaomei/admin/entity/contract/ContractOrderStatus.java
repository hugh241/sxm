package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 合同订单状态记录
 * @author zl
 */
public class ContractOrderStatus implements Serializable{
	private int	contractorderstatusid;
	private int	type;//1预定金订单 2普通订单
	private int relationid;//关联id 预定金订单或普通订单id
	private String operationtime;//操作时间
	private int orderstatus;//订单状态  0未付款 1已付款 2已完成 3已转换
	private String remark;//备注
	private Integer userid;//操作人
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getContractorderstatusid() {
		return contractorderstatusid;
	}
	public void setContractorderstatusid(int contractorderstatusid) {
		this.contractorderstatusid = contractorderstatusid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public String getOperationtime() {
		return operationtime;
	}
	public void setOperationtime(String operationtime) {
		this.operationtime = operationtime;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
}
