package com.suxiaomei.admin.entity.common;

import com.suxiaomei.admin.entity.BaseEntity;

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
public class OrderFamilyMember extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	orderfamilymemberid;
	private int	ordertypeid;
	private int	familymemberid;
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
}
