package com.suxiaomei.admin.dao.employee;

import java.util.List;

import com.suxiaomei.admin.entity.employee.EmployeePosition;
import com.suxiaomei.admin.entity.employee.extend.EmployeePositionExtend;

public interface EmployeePositionMapper {
    int deleteByPrimaryKey(Integer employeepositionid);

    int insert(EmployeePosition record);

    int insertSelective(EmployeePosition record);

    EmployeePosition selectByPrimaryKey(Integer employeepositionid);

    int updateByPrimaryKeySelective(EmployeePosition record);

    int updateByPrimaryKey(EmployeePosition record);
    /**
     * 根据护理员id查询护理员所有工种
     * @param employeeid
     * @return
     */
    List<EmployeePositionExtend> findByEmployeeid(Integer employeeid);
}