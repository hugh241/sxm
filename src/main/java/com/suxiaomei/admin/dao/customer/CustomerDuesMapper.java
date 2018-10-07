package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerDues;

public interface CustomerDuesMapper {
    int deleteByPrimaryKey(Integer customerduesid);

    int insert(CustomerDues record);

    int insertSelective(CustomerDues record);

    CustomerDues selectByPrimaryKey(Integer customerduesid);

    int updateByPrimaryKeySelective(CustomerDues record);

    int updateByPrimaryKey(CustomerDues record);
}