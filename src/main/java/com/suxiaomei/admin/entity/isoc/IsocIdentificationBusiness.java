package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 认证企业管理表
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
 * 2018年7月24日 下午4:46:14
 */
public class IsocIdentificationBusiness implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	isocidentificationbusinessid;
	private int	isocmemberid;
	private int	isocid;
	private int	businessid;
	private String	level;//星级评定A-AAAAA星
	private String enddate;//认证到期时间
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getIsocidentificationbusinessid() {
		return isocidentificationbusinessid;
	}
	public void setIsocidentificationbusinessid(int isocidentificationbusinessid) {
		this.isocidentificationbusinessid = isocidentificationbusinessid;
	}
	public int getIsocmemberid() {
		return isocmemberid;
	}
	public void setIsocmemberid(int isocmemberid) {
		this.isocmemberid = isocmemberid;
	}
	public int getIsocid() {
		return isocid;
	}
	public void setIsocid(int isocid) {
		this.isocid = isocid;
	}
	public int getBusinessid() {
		return businessid;
	}
	public void setBusinessid(int businessid) {
		this.businessid = businessid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
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
