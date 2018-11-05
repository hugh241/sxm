package com.suxiaomei.admin.dao.business;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.business.BusinessExamineOrder;
import com.suxiaomei.admin.entity.business.extend.BusinessExamineOrderExtend;

public interface BusinessExamineOrderMapper {
    int deleteByPrimaryKey(Integer businessexamineorderid);

    int insert(BusinessExamineOrder record);

    int insertSelective(BusinessExamineOrder record);

    BusinessExamineOrder selectByPrimaryKey(Integer businessexamineorderid);

    int updateByPrimaryKeySelective(BusinessExamineOrder record);

    int updateByPrimaryKey(BusinessExamineOrder record);
    
    /**
     * 根据订单id查询详细信息
     * @param businessexamineorderid
     * @return
     */
    BusinessExamineOrderExtend findDetailByBusinessexamineorderid(Integer businessexamineorderid);
    /**
     * 分页查询企业购买产品订单
     * @param startNum 起始行数
     * @param pageSize 每页数量
     * @param order 查询条件
     * @return
     */
	List<BusinessExamineOrderExtend> findByPageList(@Param("startNum")int startNum,@Param("pageSize")int pageSize,@Param("order")BusinessExamineOrderExtend order);
	/**
	 * 根据条件查询总数
	 * @param order
	 * @return
	 */
	Integer findCountByCondition(@Param("order")BusinessExamineOrderExtend order);
}