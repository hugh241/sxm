package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeTask;

public interface EmployeeTaskMapper {
    int deleteByPrimaryKey(Integer employeetaskid);

    int insert(EmployeeTask record);

    int insertSelective(EmployeeTask record);

    EmployeeTask selectByPrimaryKey(Integer employeetaskid);

    int updateByPrimaryKeySelective(EmployeeTask record);

    int updateByPrimaryKey(EmployeeTask record);
}