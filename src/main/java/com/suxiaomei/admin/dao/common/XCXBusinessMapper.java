package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.XCXBusiness;

public interface XCXBusinessMapper {
    int deleteByPrimaryKey(Integer xcxbusinessid);

    int insert(XCXBusiness record);

    int insertSelective(XCXBusiness record);

    XCXBusiness selectByPrimaryKey(Integer xcxbusinessid);

    int updateByPrimaryKeySelective(XCXBusiness record);

    int updateByPrimaryKey(XCXBusiness record);
}