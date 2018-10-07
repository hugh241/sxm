package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeSchedule;

public interface EmployeeScheduleMapper {
    int deleteByPrimaryKey(Integer employeescheduleid);

    int insert(EmployeeSchedule record);

    int insertSelective(EmployeeSchedule record);

    EmployeeSchedule selectByPrimaryKey(Integer employeescheduleid);

    int updateByPrimaryKeySelective(EmployeeSchedule record);

    int updateByPrimaryKey(EmployeeSchedule record);
}