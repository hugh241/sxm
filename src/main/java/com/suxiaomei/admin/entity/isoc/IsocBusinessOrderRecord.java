package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 企业认证审核记录
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
public class IsocBusinessOrderRecord implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderrecordid;
	private int	isocbusinessorderid;
	private String result;
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getIsocbusinessorderrecordid() {
		return isocbusinessorderrecordid;
	}
	public void setIsocbusinessorderrecordid(int isocbusinessorderrecordid) {
		this.isocbusinessorderrecordid = isocbusinessorderrecordid;
	}
	public int getIsocbusinessorderid() {
		return isocbusinessorderid;
	}
	public void setIsocbusinessorderid(int isocbusinessorderid) {
		this.isocbusinessorderid = isocbusinessorderid;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
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
