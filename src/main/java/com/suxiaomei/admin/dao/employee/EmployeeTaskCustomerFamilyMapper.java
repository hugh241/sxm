package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeTaskCustomerFamily;

public interface EmployeeTaskCustomerFamilyMapper {
    int deleteByPrimaryKey(Integer employeetaskcustomerfamilyid);

    int insert(EmployeeTaskCustomerFamily record);

    int insertSelective(EmployeeTaskCustomerFamily record);

    EmployeeTaskCustomerFamily selectByPrimaryKey(Integer employeetaskcustomerfamilyid);

    int updateByPrimaryKeySelective(EmployeeTaskCustomerFamily record);

    int updateByPrimaryKey(EmployeeTaskCustomerFamily record);
}