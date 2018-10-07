package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.County;

public interface CountyMapper {
    int deleteByPrimaryKey(Integer countyid);

    int insert(County record);

    int insertSelective(County record);

    County selectByPrimaryKey(Integer countyid);

    int updateByPrimaryKeySelective(County record);

    int updateByPrimaryKey(County record);
    /**
     * 根据城市id查询城市下的乡镇
     * @param cityid
     * @return
     */
	List<County> findByCityid(int cityid);
}