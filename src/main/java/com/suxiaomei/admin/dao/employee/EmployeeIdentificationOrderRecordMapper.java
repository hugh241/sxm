package com.suxiaomei.admin.dao.employee;

import java.util.List;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrderRecord;

public interface EmployeeIdentificationOrderRecordMapper {
    int deleteByPrimaryKey(Integer employeeidentificationorderrecordid);

    int insert(EmployeeIdentificationOrderRecord record);

    int insertSelective(EmployeeIdentificationOrderRecord record);

    EmployeeIdentificationOrderRecord selectByPrimaryKey(Integer employeeidentificationorderrecordid);

    int updateByPrimaryKeySelective(EmployeeIdentificationOrderRecord record);

    int updateByPrimaryKey(EmployeeIdentificationOrderRecord record);
    /**
     * 根据认证订单id查询订单审核记录
     * @param employeeidentificationorderid
     * @return
     */
    List<EmployeeIdentificationOrderRecord> findByEmployeeidentificationorderid(Integer employeeidentificationorderid);
}