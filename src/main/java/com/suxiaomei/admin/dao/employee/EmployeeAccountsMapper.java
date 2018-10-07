package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeAccounts;

public interface EmployeeAccountsMapper {
    int deleteByPrimaryKey(Integer employeeaccountsid);

    int insert(EmployeeAccounts record);

    int insertSelective(EmployeeAccounts record);

    EmployeeAccounts selectByPrimaryKey(Integer employeeaccountsid);

    int updateByPrimaryKeySelective(EmployeeAccounts record);

    int updateByPrimaryKey(EmployeeAccounts record);
}