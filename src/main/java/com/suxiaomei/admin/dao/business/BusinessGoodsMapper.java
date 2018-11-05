package com.suxiaomei.admin.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.business.BusinessGoods;
import com.suxiaomei.admin.entity.business.extend.BusinessGoodsExtend;

public interface BusinessGoodsMapper {
    int deleteByPrimaryKey(Integer businessgoodsid);

    int insert(BusinessGoods record);

    int insertSelective(BusinessGoods record);

    BusinessGoods selectByPrimaryKey(Integer businessgoodsid);

    int updateByPrimaryKeySelective(BusinessGoods record);

    int updateByPrimaryKey(BusinessGoods record);
    /**
     * 根据企业id和家协产品id查询企业产品
     * @param businessid
     * @param isocgoodsid
     * @return
     */
	BusinessGoods findByBusinessidAndIsocGoodsid(@Param("businessid")int businessid,@Param("isocgoodsid")int isocgoodsid);
	/**
	 * 根据家协id和企业id查询当前企业已购买和未购买的家协产品信息，未购买的企业产品信息返回为空
	 * @param isocid
	 * @param businessid
	 * @return
	 */
	List<BusinessGoodsExtend> findBusinessGoodsByIsocidAndBusinessidForBusinesss(int isocid, Integer businessid);
}