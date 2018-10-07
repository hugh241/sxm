package com.suxiaomei.admin.entity.common.extend;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;
import com.suxiaomei.admin.entity.isoc.IsocOrderGoods;

/**
 * 家协购买系统产品的订单
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
 * 2018年9月28日 下午4:44:42
 */
public class IsocGoodsOrder extends IsocExamineOrder{
	private static final long serialVersionUID = 1L;
	private String isocname;
	List<IsocOrderGoods> isocOrderGoods;
	public String getIsocname() {
		return isocname;
	}
	public void setIsocname(String isocname) {
		this.isocname = isocname;
	}
	public List<IsocOrderGoods> getIsocOrderGoods() {
		return isocOrderGoods;
	}
	public void setIsocOrderGoods(List<IsocOrderGoods> isocOrderGoods) {
		this.isocOrderGoods = isocOrderGoods;
	}
}
