package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocOrderGoods;

public interface IsocOrderGoodsMapper {
    int deleteByPrimaryKey(Integer isocordergoodsid);

    int insert(IsocOrderGoods record);

    int insertSelective(IsocOrderGoods record);

    IsocOrderGoods selectByPrimaryKey(Integer isocordergoodsid);

    int updateByPrimaryKeySelective(IsocOrderGoods record);

    int updateByPrimaryKey(IsocOrderGoods record);
    /**
     * 根据订单id查询订单下的所有产品
     * @param isocexamineorderid
     * @return
     */
    List<IsocOrderGoods> findByIsocexamineorderid(int isocexamineorderid);
    /**
     * 根据订单id删除订单产品详细
     * @param id
     * @return
     */
	int deleteByIsocexamineorderid(int isocexamineorderid);
}