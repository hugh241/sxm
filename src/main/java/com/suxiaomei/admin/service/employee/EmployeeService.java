package com.suxiaomei.admin.service.employee;

import java.util.List;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.common.IdentificationLog;
import com.suxiaomei.admin.entity.employee.extend.EmployeeExd;
import com.suxiaomei.admin.util.QueryResult;

public interface EmployeeService {
	/**
	 * 分页查询员工列表
	 * 1.管理系统阿姨管理
	 * 2.家协端 会员企业所有阿姨查询
	 * @param condition
	 * @param cUser
	 * @return
	 */
	QueryResult<EmployeeExd> findByPageList(String condition, User cUser);
	/**
	 * 根据护理员id查询护理员详细信息
	 * 1.管理系统阿姨管理
	 * 2.家协端 会员企业所有阿姨查询
	 * @param id
	 * @param cUser
	 * @return
	 */
	EmployeeExd findById(int id, User cUser);
	/**
	 * 根据员工工种id查询改工种的操作记录
	 * @param id 员工工种id
	 * @return
	 */
	List<IdentificationLog> findPLog(int id);
}
