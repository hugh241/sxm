package com.suxiaomei.admin.dao.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.common.OrderFamilyMember;
import com.suxiaomei.admin.entity.common.extend.OrderFamilyMemberExtend;

public interface OrderFamilyMemberMapper {
    int deleteByPrimaryKey(Integer orderfamilymemberid);

    int insert(OrderFamilyMember record);

    int insertSelective(OrderFamilyMember record);

    OrderFamilyMember selectByPrimaryKey(Integer orderfamilymemberid);

    int updateByPrimaryKeySelective(OrderFamilyMember record);

    int updateByPrimaryKey(OrderFamilyMember record);
    /**
     * 查询所有订单类型-系统成员关联列表
     * @return
     */
	List<OrderFamilyMemberExtend> findAll();
	/**
	 * 根据订单类型id和系统成员id查询关联
	 * @param ordertypeid
	 * @param familymemberid
	 * @return
	 */
	OrderFamilyMember findByOrdertypeidAndFamilymemberid(@Param("ordertypeid")int ordertypeid,@Param("familymemberid")int familymemberid);
}