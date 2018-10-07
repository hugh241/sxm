package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.OrderType;

public interface OrderTypeMapper {
    int deleteByPrimaryKey(Integer ordertypeid);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer ordertypeid);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
}