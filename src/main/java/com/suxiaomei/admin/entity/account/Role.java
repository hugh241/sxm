package com.suxiaomei.admin.entity.account;

import com.suxiaomei.admin.entity.BaseEntity;
/**
 * 后台管理角色
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
 * 2018年9月20日 上午9:35:21
 */
public class Role extends BaseEntity {
	private int	roleid;
	private Integer relationid;//关联系统id
	private Integer type;//关联系统类型  1苏小妹后台 2城市之家 3企业 4培训机构 5家协
	private Integer ismanager;//是否是管理员，管理员角色不能操作 0普通角色 1管理员角色
	private String name;//角色名称
	private String description;
	private static final long serialVersionUID = 1L;
	public Role(){}
	public Role(int relationid,int type,int ismanager,String name,String description){
		this.relationid = relationid;
		this.type = type;
		this.name = name;
		this.description = description;
		this.ismanager = ismanager;
	}
	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public Integer getRelationid() {
		return relationid;
	}
	public void setRelationid(Integer relationid) {
		this.relationid = relationid;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getIsmanager() {
		return ismanager;
	}
	public void setIsmanager(Integer ismanager) {
		this.ismanager = ismanager;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
