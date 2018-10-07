package com.suxiaomei.admin.dao.isoc;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocGoods;

public interface IsocGoodsMapper {
    int deleteByPrimaryKey(Integer isocgoodsid);

    int insert(IsocGoods record);

    int insertSelective(IsocGoods record);

    IsocGoods selectByPrimaryKey(Integer isocgoodsid);

    int updateByPrimaryKeySelective(IsocGoods record);

    int updateByPrimaryKey(IsocGoods record);
    /**
     * 根据家协id和产品id查询家协产品库存
     * @param isocid
     * @param goodsid
     * @return
     */
	IsocGoods findByIsocidAndGoodsid(@Param("isocid")Integer isocid,@Param("goodsid")int goodsid);
}