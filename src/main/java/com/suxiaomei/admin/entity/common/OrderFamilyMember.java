package com.suxiaomei.admin.entity.common;

import java.io.Serializable;

/**
 * 订单类型-家庭成员关联表
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
 * 2018年7月2日 下午2:46:05
 */
public class OrderFamilyMember implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	orderfamilymemberid;
	private int	ordertypeid;
	private int	familymemberid;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getOrderfamilymemberid() {
		return orderfamilymemberid;
	}
	public void setOrderfamilymemberid(int orderfamilymemberid) {
		this.orderfamilymemberid = orderfamilymemberid;
	}
	public int getOrdertypeid() {
		return ordertypeid;
	}
	public void setOrdertypeid(int ordertypeid) {
		this.ordertypeid = ordertypeid;
	}
	public int getFamilymemberid() {
		return familymemberid;
	}
	public void setFamilymemberid(int familymemberid) {
		this.familymemberid = familymemberid;
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
