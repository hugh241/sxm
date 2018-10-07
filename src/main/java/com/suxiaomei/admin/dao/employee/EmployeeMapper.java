package com.suxiaomei.admin.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.employee.Employee;
import com.suxiaomei.admin.entity.employee.extend.EmployeeExd;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer employeeid);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer employeeid);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
    /**
     * 护理员列表条件分页查询
     * 1.管理系统列表查询
     * @param pageNo
     * @param pageSize
     * @param employee
     * @return
     */
	List<EmployeeExd> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("employee")Employee employee);
	/**
	 * 条件查询护理员数量
	 * @param employee
	 * @return
	 */
	int findCountByCondition(@Param("employee")Employee employee);
	/**
	 * 根据护理员id查询护理员详细信息
	 * @param employeeid
	 * @return
	 */
	EmployeeExd findDetailById(Integer employeeid);
}