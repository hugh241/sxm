package com.suxiaomei.admin.entity.customer;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 家庭成员 工具关联
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
 * 2018年7月3日 下午1:59:44
 */
public class FamilyMemberTools extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	familymembertoolsid;
	private int	familymemberid;
	private int	toolsid;
	public int getFamilymembertoolsid() {
		return familymembertoolsid;
	}
	public void setFamilymembertoolsid(int familymembertoolsid) {
		this.familymembertoolsid = familymembertoolsid;
	}
	public int getFamilymemberid() {
		return familymemberid;
	}
	public void setFamilymemberid(int familymemberid) {
		this.familymemberid = familymemberid;
	}
	public int getToolsid() {
		return toolsid;
	}
	public void setToolsid(int toolsid) {
		this.toolsid = toolsid;
	}
}
