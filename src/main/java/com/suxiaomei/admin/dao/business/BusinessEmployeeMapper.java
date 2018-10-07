package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessEmployee;

public interface BusinessEmployeeMapper {
    int deleteByPrimaryKey(Integer businessemployeeid);

    int insert(BusinessEmployee record);

    int insertSelective(BusinessEmployee record);

    BusinessEmployee selectByPrimaryKey(Integer businessemployeeid);

    int updateByPrimaryKeySelective(BusinessEmployee record);

    int updateByPrimaryKey(BusinessEmployee record);
}