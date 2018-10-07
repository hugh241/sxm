package com.suxiaomei.admin.entity.employee;

import java.io.Serializable;

/**
 * 上户记录 客户成员关联表
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
 * 2018年7月5日 下午2:02:15
 */
public class EmployeeTaskCustomerFamily implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	employeetaskcustomerfamilyid;
	private int	employeetaskid;
	private int	customerfamilyid;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getEmployeetaskcustomerfamilyid() {
		return employeetaskcustomerfamilyid;
	}
	public void setEmployeetaskcustomerfamilyid(int employeetaskcustomerfamilyid) {
		this.employeetaskcustomerfamilyid = employeetaskcustomerfamilyid;
	}
	public int getEmployeetaskid() {
		return employeetaskid;
	}
	public void setEmployeetaskid(int employeetaskid) {
		this.employeetaskid = employeetaskid;
	}
	public int getCustomerfamilyid() {
		return customerfamilyid;
	}
	public void setCustomerfamilyid(int customerfamilyid) {
		this.customerfamilyid = customerfamilyid;
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
