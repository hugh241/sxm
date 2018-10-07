package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeDataConsummate;

public interface EmployeeDataConsummateMapper {
    int deleteByPrimaryKey(Integer employeedataconsummateid);

    int insert(EmployeeDataConsummate record);

    int insertSelective(EmployeeDataConsummate record);

    EmployeeDataConsummate selectByPrimaryKey(Integer employeedataconsummateid);

    int updateByPrimaryKeySelective(EmployeeDataConsummate record);

    int updateByPrimaryKey(EmployeeDataConsummate record);
}