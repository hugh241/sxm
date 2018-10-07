package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.OrderType;

public interface OrderTypeMapper {
    int deleteByPrimaryKey(Integer ordertypeid);

    int insert(OrderType record);

    int insertSelective(OrderType record);

    OrderType selectByPrimaryKey(Integer ordertypeid);

    int updateByPrimaryKeySelective(OrderType record);

    int updateByPrimaryKey(OrderType record);
    /**
     * 查询所有订单类型
     * @return
     */
	List<OrderType> findAll();
}