package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.CustomerCollection;

public interface CustomerCollectionMapper {
    int deleteByPrimaryKey(Integer customercollectionid);

    int insert(CustomerCollection record);

    int insertSelective(CustomerCollection record);

    CustomerCollection selectByPrimaryKey(Integer customercollectionid);

    int updateByPrimaryKeySelective(CustomerCollection record);

    int updateByPrimaryKey(CustomerCollection record);
}