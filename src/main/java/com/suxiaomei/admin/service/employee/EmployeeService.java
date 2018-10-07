package com.suxiaomei.admin.service.employee;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.employee.extend.EmployeeExd;
import com.suxiaomei.admin.util.QueryResult;

public interface EmployeeService {
	/**
	 * 分页查询员工列表
	 * 1.管理系统阿姨管理
	 * @param condition
	 * @param cUser
	 * @return
	 */
	QueryResult<EmployeeExd> findByPageList(String condition, User cUser);
	/**
	 * 根据护理员id查询护理员详细信息
	 * 1.管理系统阿姨管理
	 * @param id
	 * @param cUser
	 * @return
	 */
	EmployeeExd findById(int id, User cUser);
}
