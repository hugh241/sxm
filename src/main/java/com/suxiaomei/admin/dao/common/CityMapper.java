package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.City;

public interface CityMapper {
    int deleteByPrimaryKey(Integer cityid);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer cityid);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
    /**
     * 根据省份id查询该省份下的所有城市
     * @param provinceid
     * @return
     */
	List<City> findByProvinceid(int provinceid);
}