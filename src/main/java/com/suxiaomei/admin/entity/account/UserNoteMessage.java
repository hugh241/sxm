package com.suxiaomei.admin.entity.account;

import java.io.Serializable;

/**
 * 消息
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
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the animal protecting
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
 * 2018年5月15日 下午4:05:53
 */
public class UserNoteMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	usernotemessageid;
	private int	userid;//用户id
	private int	type = 1;//消息类型 1跟进消息 2订单消息 3合同关闭消息 4收款提醒消息
	private int	relationid;//关联id 1销售机会id 2订单id 3合同id 4订单id
	private String title;//标题
	private String content;//内容
	private int	readstatus;//阅读状态 0未读 1已读
	private String reminddate;//开始提醒日期
	private String executedate;//执行日期
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getUsernotemessageid() {
		return usernotemessageid;
	}
	public void setUsernotemessageid(int usernotemessageid) {
		this.usernotemessageid = usernotemessageid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadstatus() {
		return readstatus;
	}
	public void setReadstatus(int readstatus) {
		this.readstatus = readstatus;
	}
	public String getReminddate() {
		return reminddate;
	}
	public void setReminddate(String reminddate) {
		this.reminddate = reminddate;
	}
	public String getExecutedate() {
		return executedate;
	}
	public void setExecutedate(String executedate) {
		this.executedate = executedate;
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
