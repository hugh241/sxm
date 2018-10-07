package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessOrderGoods;

public interface BusinessOrderGoodsMapper {
    int deleteByPrimaryKey(Integer businessordergoodsid);

    int insert(BusinessOrderGoods record);

    int insertSelective(BusinessOrderGoods record);

    BusinessOrderGoods selectByPrimaryKey(Integer businessordergoodsid);

    int updateByPrimaryKeySelective(BusinessOrderGoods record);

    int updateByPrimaryKey(BusinessOrderGoods record);
}