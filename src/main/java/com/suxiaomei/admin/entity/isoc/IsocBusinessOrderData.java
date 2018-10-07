package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;
/**
 * 企业认证审核项目
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
 * 2018年7月25日 下午2:56:40
 */
public class IsocBusinessOrderData implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderdataid;
	private int	relationid;//关联id
	private int type;//类型 0企业认证 1护理员认证
	private String name;
	private int auditstatus;//审核状态 0审核中 1通过 2驳回
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getIsocbusinessorderdataid() {
		return isocbusinessorderdataid;
	}
	public void setIsocbusinessorderdataid(int isocbusinessorderdataid) {
		this.isocbusinessorderdataid = isocbusinessorderdataid;
	}
	public int getRelationid() {
		return relationid;
	}
	public void setRelationid(int relationid) {
		this.relationid = relationid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAuditstatus() {
		return auditstatus;
	}
	public void setAuditstatus(int auditstatus) {
		this.auditstatus = auditstatus;
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
