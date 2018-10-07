package com.suxiaomei.admin.entity.contract;

import java.io.Serializable;
/**
 * 订单预定金订单关联
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月18日 上午10:26:40
 */
public class ContractOrderDeposit implements Serializable{
	private static final long serialVersionUID = 1L;
	private int contractorderdepositid;
	private int contractorderid;//订单id
	private int contractdepositorderid;//预定金订单编号
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getContractorderdepositid() {
		return contractorderdepositid;
	}
	public void setContractorderdepositid(int contractorderdepositid) {
		this.contractorderdepositid = contractorderdepositid;
	}
	public int getContractorderid() {
		return contractorderid;
	}
	public void setContractorderid(int contractorderid) {
		this.contractorderid = contractorderid;
	}
	public int getContractdepositorderid() {
		return contractdepositorderid;
	}
	public void setContractdepositorderid(int contractdepositorderid) {
		this.contractdepositorderid = contractdepositorderid;
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
