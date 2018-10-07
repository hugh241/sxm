package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeFamily;

public interface EmployeeFamilyMapper {
    int deleteByPrimaryKey(Integer employeefamilyid);

    int insert(EmployeeFamily record);

    int insertSelective(EmployeeFamily record);

    EmployeeFamily selectByPrimaryKey(Integer employeefamilyid);

    int updateByPrimaryKeySelective(EmployeeFamily record);

    int updateByPrimaryKey(EmployeeFamily record);
}