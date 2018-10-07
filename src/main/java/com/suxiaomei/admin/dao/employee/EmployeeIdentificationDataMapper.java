package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationData;

public interface EmployeeIdentificationDataMapper {
    int deleteByPrimaryKey(Integer employeeidentificationdataid);

    int insert(EmployeeIdentificationData record);

    int insertSelective(EmployeeIdentificationData record);

    EmployeeIdentificationData selectByPrimaryKey(Integer employeeidentificationdataid);

    int updateByPrimaryKeySelective(EmployeeIdentificationData record);

    int updateByPrimaryKey(EmployeeIdentificationData record);
}