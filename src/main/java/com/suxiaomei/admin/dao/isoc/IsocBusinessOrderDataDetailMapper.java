package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;

public interface IsocBusinessOrderDataDetailMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderdatadetailid);

    int insert(IsocBusinessOrderDataDetail record);

    int insertSelective(IsocBusinessOrderDataDetail record);

    IsocBusinessOrderDataDetail selectByPrimaryKey(Integer isocbusinessorderdatadetailid);

    int updateByPrimaryKeySelective(IsocBusinessOrderDataDetail record);

    int updateByPrimaryKey(IsocBusinessOrderDataDetail record);
}