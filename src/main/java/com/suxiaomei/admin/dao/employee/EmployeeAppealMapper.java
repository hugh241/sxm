package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeAppeal;

public interface EmployeeAppealMapper {
    int deleteByPrimaryKey(Integer employeeappealid);

    int insert(EmployeeAppeal record);

    int insertSelective(EmployeeAppeal record);

    EmployeeAppeal selectByPrimaryKey(Integer employeeappealid);

    int updateByPrimaryKeySelective(EmployeeAppeal record);

    int updateByPrimaryKey(EmployeeAppeal record);
}