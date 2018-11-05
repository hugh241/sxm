package com.suxiaomei.admin.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.employee.EmployeeCreditCard;

public interface EmployeeCreditCardMapper {
    int deleteByPrimaryKey(Integer employeecreditcardid);

    int insert(EmployeeCreditCard record);

    int insertSelective(EmployeeCreditCard record);

    EmployeeCreditCard selectByPrimaryKey(Integer employeecreditcardid);

    int updateByPrimaryKeySelective(EmployeeCreditCard record);

    int updateByPrimaryKey(EmployeeCreditCard record);
    /**
     * 根据家协id查询家协下所有护理员信誉卡
     * @param isocid
     * @return
     */
	List<EmployeeCreditCard> findByIsocid(Integer isocid);
	/**
	 * 根据家协id和护理员id查询护理员身份卡
	 * @param isocid
	 * @param employeeid
	 * @return
	 */
	EmployeeCreditCard findByIsocidAndEmployeeid(@Param("isocid")Integer isocid,@Param("employeeid")Integer employeeid);
}