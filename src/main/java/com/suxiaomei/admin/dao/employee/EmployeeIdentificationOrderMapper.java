package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;

public interface EmployeeIdentificationOrderMapper {
    int deleteByPrimaryKey(Integer employeeidentificationorderid);

    int insert(EmployeeIdentificationOrder record);

    int insertSelective(EmployeeIdentificationOrder record);

    EmployeeIdentificationOrder selectByPrimaryKey(Integer employeeidentificationorderid);

    int updateByPrimaryKeySelective(EmployeeIdentificationOrder record);

    int updateByPrimaryKey(EmployeeIdentificationOrder record);
}