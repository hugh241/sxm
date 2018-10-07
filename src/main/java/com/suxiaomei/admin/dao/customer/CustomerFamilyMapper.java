package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerFamily;

public interface CustomerFamilyMapper {
    int deleteByPrimaryKey(Integer customerfamilyid);

    int insert(CustomerFamily record);

    int insertSelective(CustomerFamily record);

    CustomerFamily selectByPrimaryKey(Integer customerfamilyid);

    int updateByPrimaryKeySelective(CustomerFamily record);

    int updateByPrimaryKey(CustomerFamily record);
}