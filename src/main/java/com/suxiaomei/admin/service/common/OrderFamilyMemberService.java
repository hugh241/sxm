package com.suxiaomei.admin.service.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.OrderFamilyMember;
import com.suxiaomei.admin.entity.common.OrderType;
import com.suxiaomei.admin.entity.common.extend.OrderFamilyMemberExtend;
import com.suxiaomei.admin.entity.customer.FamilyMember;
/**
 * 订单类型系统成员管理
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
 * 2018年10月7日 下午2:21:23
 */
public interface OrderFamilyMemberService {
	/**
	 * 查询订单类型列表
	 * 1.管理端订单类型成员管理
	 * @return
	 */
	List<OrderType> findOrderTypeList();
	/**
	 * 查询所有系统成员列表
	 * 1.管理端订单类型成员管理
	 * @return
	 */
	List<FamilyMember> findFamilyMemberList();
	/**
	 * 查询订单类型系统成员关联列表
	 * 1.管理端订单类型成员管理
	 * @return
	 */
	List<OrderFamilyMemberExtend> findList();
	/**
	 * 添加关联
	 * 1.管理端订单类型成员管理
	 * @param orderFamilyMember
	 * @return
	 */
	int add(OrderFamilyMember orderFamilyMember);
	/**
	 * 删除关联
	 * 1.管理端订单类型成员管理
	 * @param id
	 * @return
	 */
	int delete(int id);

}
