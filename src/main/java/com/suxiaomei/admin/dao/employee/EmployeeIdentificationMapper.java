package com.suxiaomei.admin.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.employee.EmployeeIdentification;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationExtend;

public interface EmployeeIdentificationMapper {
    int deleteByPrimaryKey(Integer employeeidentificationid);

    int insert(EmployeeIdentification record);

    int insertSelective(EmployeeIdentification record);

    EmployeeIdentification selectByPrimaryKey(Integer employeeidentificationid);

    int updateByPrimaryKeySelective(EmployeeIdentification record);

    int updateByPrimaryKey(EmployeeIdentification record);
    /**
     * 根据护理员id和工种savevalue值查询护理员改工种的认证信息
     * @param findByEmployeeidAndWorktype
     * @param worktype
     * @return
     */
    List<EmployeeIdentificationExtend> findByEmployeeidAndWorktype(@Param("employeeid") Integer employeeid,@Param("worktype") Integer worktype);
    /**
     * 查询护理员该工种最新有效的认证记录
     * @param employeeid
     * @param worktype
     * @return
     */
    EmployeeIdentificationExtend findNewestByEmployeeidAndWorktype(@Param("employeeid") Integer employeeid,@Param("worktype") Integer worktype);
    /**
     * 查询该护理员在当前家协下对当前工种最后认证的记录
     * @param employeeid
     * @param isocid
     * @param worktype
     * @return
     */
	EmployeeIdentification findEmployeeLastEnddate(@Param("employeeid")int employeeid,@Param("isocid")int isocid,@Param("worktype")Integer worktype);
}