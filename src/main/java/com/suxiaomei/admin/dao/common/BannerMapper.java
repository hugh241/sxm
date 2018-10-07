package com.suxiaomei.admin.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.Banner;

public interface BannerMapper {
    int deleteByPrimaryKey(Integer bannerid);

    int insert(Banner record);

    int insertSelective(Banner record);

    Banner selectByPrimaryKey(Integer bannerid);

    int updateByPrimaryKeySelective(Banner record);

    int updateByPrimaryKey(Banner record);
    /**
     * 根据类型查询banner 
     * @param type -1不根据类型查询
     * @return
     */
	List<Banner> findByType(@Param("type")Integer type);
}