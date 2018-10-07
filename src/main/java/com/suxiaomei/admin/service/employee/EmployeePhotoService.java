package com.suxiaomei.admin.service.employee;

import com.suxiaomei.admin.entity.employee.EmployeePhoto;
import com.suxiaomei.admin.util.QueryResult;

public interface EmployeePhotoService {
	/**
	 * 根据条件分页查询护理员图片信息（type1：生活照 2证件照）
	 * 1.管理系统护理员详细
	 * @param condition
	 * @return
	 */
	QueryResult<EmployeePhoto> findByCondition(String condition);
}
