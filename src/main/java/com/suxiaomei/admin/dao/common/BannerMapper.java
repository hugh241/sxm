package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer bannerid);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bannerid);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
}