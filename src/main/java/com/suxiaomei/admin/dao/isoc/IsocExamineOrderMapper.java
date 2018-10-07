package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.extend.IsocGoodsOrder;
import com.suxiaomei.admin.entity.isoc.IsocExamineOrder;

public interface IsocExamineOrderMapper {
    int deleteByPrimaryKey(Integer isocexamineorderid);

    int insert(IsocExamineOrder record);

    int insertSelective(IsocExamineOrder record);

    IsocExamineOrder selectByPrimaryKey(Integer isocexamineorderid);


    int updateByPrimaryKey(IsocExamineOrder record);
    /**
     * 分页查询家协购买产品订单
     * @param startNum 起始行数
     * @param pageSize 每页数量
     * @param order 查询条件
     * @return
     */
	List<IsocGoodsOrder> findByPageList(@Param("startNum")int startNum,@Param("pageSize")int pageSize,@Param("order")IsocGoodsOrder order);
	/**
	 * 根据条件查询总数
	 * @param order
	 * @return
	 */
	int findCountByCondition(@Param("order")IsocGoodsOrder order);
	/**
	 * 通过订单
	 * @param record
	 * @return
	 */
    int updateIsocExamineOrderStatus(IsocExamineOrder record);
}