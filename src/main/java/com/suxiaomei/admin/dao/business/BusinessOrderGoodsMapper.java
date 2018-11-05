package com.suxiaomei.admin.dao.business;

import java.util.List;

import com.suxiaomei.admin.entity.business.BusinessOrderGoods;

public interface BusinessOrderGoodsMapper {
    int deleteByPrimaryKey(Integer businessordergoodsid);

    int insert(BusinessOrderGoods record);

    int insertSelective(BusinessOrderGoods record);

    BusinessOrderGoods selectByPrimaryKey(Integer businessordergoodsid);

    int updateByPrimaryKeySelective(BusinessOrderGoods record);

    int updateByPrimaryKey(BusinessOrderGoods record);
    /**
     * 根据企业购买家协产品订单id查询购买家协产品列表
     * @param businessexamineorderid
     * @return
     */
    List<BusinessOrderGoods> findByBusinessexamineorderid(Integer businessexamineorderid);
}