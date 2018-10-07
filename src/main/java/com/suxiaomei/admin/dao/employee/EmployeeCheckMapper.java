package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeCheck;

public interface EmployeeCheckMapper {
    int deleteByPrimaryKey(Integer employeecheckid);

    int insert(EmployeeCheck record);

    int insertSelective(EmployeeCheck record);

    EmployeeCheck selectByPrimaryKey(Integer employeecheckid);

    int updateByPrimaryKeySelective(EmployeeCheck record);

    int updateByPrimaryKeyWithBLOBs(EmployeeCheck record);

    int updateByPrimaryKey(EmployeeCheck record);
}