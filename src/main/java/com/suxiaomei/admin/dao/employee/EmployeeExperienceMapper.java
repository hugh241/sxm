package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeExperience;

public interface EmployeeExperienceMapper {
    int deleteByPrimaryKey(Integer employeeexperienceid);

    int insert(EmployeeExperience record);

    int insertSelective(EmployeeExperience record);

    EmployeeExperience selectByPrimaryKey(Integer employeeexperienceid);

    int updateByPrimaryKeySelective(EmployeeExperience record);

    int updateByPrimaryKey(EmployeeExperience record);
}