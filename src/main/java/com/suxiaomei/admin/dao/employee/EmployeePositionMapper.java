package com.suxiaomei.admin.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
    /**
     * 根据员工id和工种类型查询护理员工种记录
     * @param employeeid
     * @param type
     * @return
     */
	EmployeePosition findByEmployeeidAndType(@Param("employeeid")int employeeid,@Param("type")int type);
}