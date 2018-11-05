package com.suxiaomei.admin.entity.isoc;

import com.suxiaomei.admin.entity.BaseEntity;

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
public class IsocBusinessOrderDataDetail extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private int	isocbusinessorderdatadetailid;
	private int	isocbusinessorderdataid;
	private String url;//图片地址
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
}
