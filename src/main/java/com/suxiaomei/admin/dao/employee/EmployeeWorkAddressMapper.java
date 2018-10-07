package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeWorkAddress;

public interface EmployeeWorkAddressMapper {
    int deleteByPrimaryKey(Integer employeeworkaddressid);

    int insert(EmployeeWorkAddress record);

    int insertSelective(EmployeeWorkAddress record);

    EmployeeWorkAddress selectByPrimaryKey(Integer employeeworkaddressid);

    int updateByPrimaryKeySelective(EmployeeWorkAddress record);

    int updateByPrimaryKey(EmployeeWorkAddress record);
}