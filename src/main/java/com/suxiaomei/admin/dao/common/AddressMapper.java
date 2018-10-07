package com.suxiaomei.admin.dao.common;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer addressid);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    /**
     * 根据省市id查询地址
     * @param provinceid
     * @param cityid
     * @return
     */
	Address findByProvinceidAndCityid(@Param("provinceid")Integer provinceid,@Param("cityid")Integer cityid);
}