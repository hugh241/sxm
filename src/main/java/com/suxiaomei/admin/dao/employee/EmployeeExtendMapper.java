package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeExtend;

public interface EmployeeExtendMapper {
    int deleteByPrimaryKey(Integer employeeextendid);

    int insert(EmployeeExtend record);

    int insertSelective(EmployeeExtend record);

    EmployeeExtend selectByPrimaryKey(Integer employeeextendid);

    int updateByPrimaryKeySelective(EmployeeExtend record);

    int updateByPrimaryKey(EmployeeExtend record);
}