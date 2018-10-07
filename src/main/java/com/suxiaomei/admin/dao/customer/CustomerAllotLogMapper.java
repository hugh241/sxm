package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerAllotLog;

public interface CustomerAllotLogMapper {
    int deleteByPrimaryKey(Integer customerallotlogid);

    int insert(CustomerAllotLog record);

    int insertSelective(CustomerAllotLog record);

    CustomerAllotLog selectByPrimaryKey(Integer customerallotlogid);

    int updateByPrimaryKeySelective(CustomerAllotLog record);

    int updateByPrimaryKey(CustomerAllotLog record);
}