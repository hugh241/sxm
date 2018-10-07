package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.School;

public interface SchoolMapper {
    int deleteByPrimaryKey(Integer schoolid);

    int insert(School record);

    int insertSelective(School record);

    School selectByPrimaryKey(Integer schoolid);

    int updateByPrimaryKeySelective(School record);

    int updateByPrimaryKey(School record);
}