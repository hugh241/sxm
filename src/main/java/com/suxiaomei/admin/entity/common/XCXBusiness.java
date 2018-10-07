package com.suxiaomei.admin.entity.common;

import com.suxiaomei.admin.entity.BaseEntity;

/**
 * 企业工种关联
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
 * 2018年9月18日 下午3:09:35
 */
public class XCXBusiness extends BaseEntity{
	private static final long serialVersionUID = 1L;
	private Integer xcxbusinessid;
    private Integer businessid;
    private Byte type;
    public Integer getXcxbusinessid() {
        return xcxbusinessid;
    }
    public void setXcxbusinessid(Integer xcxbusinessid) {
        this.xcxbusinessid = xcxbusinessid;
    }
    public Integer getBusinessid() {
        return businessid;
    }
    public void setBusinessid(Integer businessid) {
        this.businessid = businessid;
    }
    public Byte getType() {
        return type;
    }
    public void setType(Byte type) {
        this.type = type;
    }
}