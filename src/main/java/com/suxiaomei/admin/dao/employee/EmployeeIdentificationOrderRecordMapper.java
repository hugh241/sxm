package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrderRecord;

public interface EmployeeIdentificationOrderRecordMapper {
    int deleteByPrimaryKey(Integer employeeidentificationorderrecordid);

    int insert(EmployeeIdentificationOrderRecord record);

    int insertSelective(EmployeeIdentificationOrderRecord record);

    EmployeeIdentificationOrderRecord selectByPrimaryKey(Integer employeeidentificationorderrecordid);

    int updateByPrimaryKeySelective(EmployeeIdentificationOrderRecord record);

    int updateByPrimaryKey(EmployeeIdentificationOrderRecord record);
}