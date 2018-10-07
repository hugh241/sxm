package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;

public interface IsocBusinessOrderDataMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderdataid);

    int insert(IsocBusinessOrderData record);

    int insertSelective(IsocBusinessOrderData record);

    IsocBusinessOrderData selectByPrimaryKey(Integer isocbusinessorderdataid);

    int updateByPrimaryKeySelective(IsocBusinessOrderData record);

    int updateByPrimaryKey(IsocBusinessOrderData record);
}