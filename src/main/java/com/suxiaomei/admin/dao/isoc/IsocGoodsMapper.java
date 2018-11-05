package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocGoods;
import com.suxiaomei.admin.entity.isoc.extend.IsocGoodsExtend;

public interface IsocGoodsMapper {
    int deleteByPrimaryKey(Integer isocgoodsid);

    int insert(IsocGoods record);

    int insertSelective(IsocGoods record);

    IsocGoods selectByPrimaryKey(Integer isocgoodsid);

    int updateByPrimaryKeySelective(IsocGoods record);
    /**
     * 根据家协id和产品id查询家协产品库存
     * @param isocid
     * @param goodsid
     * @return
     */
	IsocGoods findByIsocidAndGoodsid(@Param("isocid")Integer isocid,@Param("goodsid")int goodsid);
	/**
	 * 根据家协产品id查询家协产品详细信息（包括系统产品信息）
	 * @param isocgoodsid
	 * @return
	 */
	IsocGoodsExtend findDetailById(Integer isocgoodsid);
	/**
	 * 根据家协id查询(所有系统产品，如果不存在对应的家协产品，则家协产品信息为空)
	 * @param isocid
	 * @return
	 */
	List<IsocGoodsExtend> findAllGoodsByIsocid(Integer isocid);
	/**
	 * 根据家协id查询(查询出家协产品和该家协产品对应的系统产品信息，一对一)
	 * @param isocid
	 * @return
	 */
	List<IsocGoodsExtend> findIsocGoodsByIsocid(Integer isocid);
}