package com.suxiaomei.admin.dao.employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.employee.EmployeeIdentificationOrder;
import com.suxiaomei.admin.entity.employee.extend.EmployeeIdentificationOrderExtend;

public interface EmployeeIdentificationOrderMapper {
    int deleteByPrimaryKey(Integer employeeidentificationorderid);

    int insert(EmployeeIdentificationOrder record);

    int insertSelective(EmployeeIdentificationOrder record);

    EmployeeIdentificationOrder selectByPrimaryKey(Integer employeeidentificationorderid);

    int updateByPrimaryKeySelective(EmployeeIdentificationOrder record);
    
    int updateByPrimaryKey(EmployeeIdentificationOrder record);
    /**
     * 根据主键id查询详细
     * @param employeeidentificationorderid
     * @return
     */
    EmployeeIdentificationOrderExtend findDetailByPrimaryKey(Integer employeeidentificationorderid);
    /**
     * 根据认证子项id查询出护理员认证订单
     * @param isocbusinessorderdataid
     * @return
     */
	EmployeeIdentificationOrder findByIsocbusinessorderdataid(Integer isocbusinessorderdataid);
	/**
	 * 条件分页查询阿姨认证订单
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	List<EmployeeIdentificationOrderExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("con") Map<String, Object> map);
	/**
	 * 条件查询阿姨认证订单数量
	 * @param map
	 * @return
	 */
	Integer findCountByCondition(@Param("con")Map<String, Object> map);
	/**
	 * 根据认证项详细id查询护理员认证订单
	 * @param isocbusinessorderdatadetailid
	 * @return
	 */
	EmployeeIdentificationOrder findByIsocbusinessorderdatadetailid(int isocbusinessorderdatadetailid);
	/**
	 * 根据订单id查询订单详细和订单下的所有认证项
	 * @param employeeidentificationorderid
	 * @return
	 */
	EmployeeIdentificationOrderExtend findDatasDetailByPrimaryKey(int employeeidentificationorderid);
}