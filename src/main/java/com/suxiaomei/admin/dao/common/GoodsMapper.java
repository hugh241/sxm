package com.suxiaomei.admin.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.Goods;
import com.suxiaomei.admin.response.Dict;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer goodsid);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);
    /**
     * 查询所有上户的系统商品
     * @return
     */
	List<Dict> findAllUP();
	/**
	 * 根据产品上下架状态查询产品
	 * @param status null 查询所有 0查询下架产品 1查询上架产品
	 * @return
	 */
	List<Goods> findAllByStatus(Integer status);
	/**
	 * 根据工种id查询产品（产品-工种一对一）
	 * @param positionid
	 * @return
	 */
	Goods findByPositionId(int positionid);
	/**
	 * 修改产品状态
	 * @param goodsid
	 * @param status
	 * @return
	 */
	int updateGoodsStatus(@Param("goodsid")int goodsid,@Param("status")int status);
	/**
	 * 根据家协产品id查询产品
	 * @param isocgoodsid
	 * @return
	 */
	Goods findByIsocgoodsid(Integer isocgoodsid);
}