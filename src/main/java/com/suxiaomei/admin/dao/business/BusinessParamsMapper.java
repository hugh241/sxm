package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessParams;

public interface BusinessParamsMapper {
    int deleteByPrimaryKey(Integer businessparamsid);

    int insert(BusinessParams record);

    int insertSelective(BusinessParams record);

    BusinessParams selectByPrimaryKey(Integer businessparamsid);

    int updateByPrimaryKeySelective(BusinessParams record);

    int updateByPrimaryKey(BusinessParams record);
}