package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeSkill;

public interface EmployeeSkillMapper {
    int deleteByPrimaryKey(Integer employeeskillid);

    int insert(EmployeeSkill record);

    int insertSelective(EmployeeSkill record);

    EmployeeSkill selectByPrimaryKey(Integer employeeskillid);

    int updateByPrimaryKeySelective(EmployeeSkill record);

    int updateByPrimaryKey(EmployeeSkill record);
}