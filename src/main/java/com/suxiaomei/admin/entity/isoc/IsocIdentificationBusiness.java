package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;

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
public class IsocIdentificationBusiness extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	isocidentificationbusinessid;
	private int type;//0企业 1培训学校
	private Integer	isocmemberid;
	private Integer	isocid;
	private Integer	businessid;
	private String	level;//星级评定A-AAAAA星
	private String enddate;//认证到期时间
	public int getIsocidentificationbusinessid() {
		return isocidentificationbusinessid;
	}
	public void setIsocidentificationbusinessid(int isocidentificationbusinessid) {
		this.isocidentificationbusinessid = isocidentificationbusinessid;
	}
	public Integer getIsocmemberid() {
		return isocmemberid;
	}
	public void setIsocmemberid(Integer isocmemberid) {
		this.isocmemberid = isocmemberid;
	}
	public Integer getIsocid() {
		return isocid;
	}
	public void setIsocid(Integer isocid) {
		this.isocid = isocid;
	}
	public Integer getBusinessid() {
		return businessid;
	}
	public void setBusinessid(Integer businessid) {
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
