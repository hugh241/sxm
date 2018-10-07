package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeTrain;

public interface EmployeeTrainMapper {
    int deleteByPrimaryKey(Integer employeetrainid);

    int insert(EmployeeTrain record);

    int insertSelective(EmployeeTrain record);

    EmployeeTrain selectByPrimaryKey(Integer employeetrainid);

    int updateByPrimaryKeySelective(EmployeeTrain record);

    int updateByPrimaryKey(EmployeeTrain record);
}