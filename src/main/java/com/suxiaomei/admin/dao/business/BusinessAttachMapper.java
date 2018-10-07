package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessAttach;

public interface BusinessAttachMapper {
    int deleteByPrimaryKey(Integer businessattachid);

    int insert(BusinessAttach record);

    int insertSelective(BusinessAttach record);

    BusinessAttach selectByPrimaryKey(Integer businessattachid);

    int updateByPrimaryKeySelective(BusinessAttach record);

    int updateByPrimaryKey(BusinessAttach record);
}