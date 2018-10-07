package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationRecord;

public interface EmployeeIdentificationRecordMapper {
    int deleteByPrimaryKey(Integer employeeidentificationrecordid);

    int insert(EmployeeIdentificationRecord record);

    int insertSelective(EmployeeIdentificationRecord record);

    EmployeeIdentificationRecord selectByPrimaryKey(Integer employeeidentificationrecordid);

    int updateByPrimaryKeySelective(EmployeeIdentificationRecord record);

    int updateByPrimaryKey(EmployeeIdentificationRecord record);
}