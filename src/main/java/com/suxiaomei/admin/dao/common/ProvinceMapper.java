package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.Province;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer provinceid);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer provinceid);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
    /**
     * 查询所有省份
     * @return
     */
	List<Province> findAll();
}