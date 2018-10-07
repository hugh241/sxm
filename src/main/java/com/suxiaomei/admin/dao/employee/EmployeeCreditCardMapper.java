package com.suxiaomei.admin.dao.employee;

import com.suxiaomei.admin.entity.employee.EmployeeCreditCard;

public interface EmployeeCreditCardMapper {
    int deleteByPrimaryKey(Integer employeecreditcardid);

    int insert(EmployeeCreditCard record);

    int insertSelective(EmployeeCreditCard record);

    EmployeeCreditCard selectByPrimaryKey(Integer employeecreditcardid);

    int updateByPrimaryKeySelective(EmployeeCreditCard record);

    int updateByPrimaryKey(EmployeeCreditCard record);
}