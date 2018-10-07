package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessGoods;

public interface BusinessGoodsMapper {
    int deleteByPrimaryKey(Integer businessgoodsid);

    int insert(BusinessGoods record);

    int insertSelective(BusinessGoods record);

    BusinessGoods selectByPrimaryKey(Integer businessgoodsid);

    int updateByPrimaryKeySelective(BusinessGoods record);

    int updateByPrimaryKey(BusinessGoods record);
}