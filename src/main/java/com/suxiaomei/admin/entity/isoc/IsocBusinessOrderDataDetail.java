package com.suxiaomei.admin.entity.isoc;

import java.io.Serializable;

/**
 * 企业认证审核项目详细（多张图片地址）
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
public class IsocBusinessOrderDataDetail implements Serializable{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderdatadetailid;
	private int	isocbusinessorderdataid;
	private String url;//图片地址
	private int	status = 1;
	private String createtime;
	private String updatetime;
	public int getIsocbusinessorderdatadetailid() {
		return isocbusinessorderdatadetailid;
	}
	public void setIsocbusinessorderdatadetailid(int isocbusinessorderdatadetailid) {
		this.isocbusinessorderdatadetailid = isocbusinessorderdatadetailid;
	}
	public int getIsocbusinessorderdataid() {
		return isocbusinessorderdataid;
	}
	public void setIsocbusinessorderdataid(int isocbusinessorderdataid) {
		this.isocbusinessorderdataid = isocbusinessorderdataid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
