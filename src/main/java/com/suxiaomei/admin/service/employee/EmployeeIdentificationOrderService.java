package com.suxiaomei.admin.service.employee;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationOrderExtend;
import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;
import com.suxiaomei.admin.util.QueryResult;

public interface EmployeeIdentificationOrderService {
	/**
	 * 查询阿姨认证申请记录
	 * 1.家协端 待认证家政人员申请 
	 * 2.家协端 历史认证家政人员申请
	 * 3.企业端 家政人员认证申请管理
	 * @param condition
	 * @param status 0待认证 1历史认证 3根据每一个审核状态查询（0，1，2，3，4，5，6）
	 * @param user 当前登录用户
	 * @return
	 */
	QueryResult<EmployeeIdentificationOrderExtend> findByCondition(String condition, int status, User user);
	/**
	 * 通过/不通过 企业/护理员认证申请子项
	 * 1.家协端 认证企业申请管理
	 * 2.家协端 待认证护理员管理
	 * @param data
	 * @return
	 */
	int authIsocOrderItem(IsocBusinessOrderData data);
	/**
	 * 护理员背景调查
	 * 1.家协端 待认证护理员管理
	 * @param order
	 * @return 调查成功，返回调查结果，失败返回错误码
	 */
	Object backgroundCheck(EmployeeIdentificationOrder order);
	/**
	 * 审核认证申请
	 * 1.家协端 待认证护理员管理
	 * @param order
	 * @return
	 */
	int authApply(EmployeeIdentificationOrder order);
	/**
	 * 创建护理员工种认证申请订单
	 * 1.企业端 家政人员认证申请管理
	 * @param order
	 * @return 正数：错误码  负数：新增的订单id
	 */
	int createEmployeeIdentificationOrder(EmployeeIdentificationOrder order);
	/**
	 * 根据id查询护理员认证订单
	 * 1.企业端 家政人员认证申请管理
	 * @param employeeidentificationorderid
	 * @return
	 */
	EmployeeIdentificationOrder selectByPrimaryKey(int employeeidentificationorderid);
	/**
	 * 重新编辑提交护理员认证申请
	 * @param order
	 * @return
	 */
	int reApply(EmployeeIdentificationOrder order);
}
