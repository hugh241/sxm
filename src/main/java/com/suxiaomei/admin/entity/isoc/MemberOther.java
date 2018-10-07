package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 家协会员企业其他信息
 * @author zl
 */
public class MemberOther implements Serializable{
	private int	memberotherid;
	private int	memberid;//会员单位id
	private String content;//内容
	private int	type;//类型 1商誉资质信息 2奖惩信息
	private int	status = 1;
	private String createtime;
	private String updatetime;
	private static final long serialVersionUID = 1L;
	public int getMemberotherid() {
		return memberotherid;
	}
	public void setMemberotherid(int memberotherid) {
		this.memberotherid = memberotherid;
	}
	public int getMemberid() {
		return memberid;
	}
	public void setMemberid(int memberid) {
		this.memberid = memberid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
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
