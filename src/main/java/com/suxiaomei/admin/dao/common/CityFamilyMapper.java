package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.CityFamily;

public interface CityFamilyMapper {
    int deleteByPrimaryKey(Integer cityfamilyid);

    int insert(CityFamily record);

    int insertSelective(CityFamily record);

    CityFamily selectByPrimaryKey(Integer cityfamilyid);

    int updateByPrimaryKeySelective(CityFamily record);

    int updateByPrimaryKey(CityFamily record);
}