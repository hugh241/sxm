package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.OrderFamilyMember;

public interface OrderFamilyMemberMapper {
    int deleteByPrimaryKey(Integer orderfamilymemberid);

    int insert(OrderFamilyMember record);

    int insertSelective(OrderFamilyMember record);

    OrderFamilyMember selectByPrimaryKey(Integer orderfamilymemberid);

    int updateByPrimaryKeySelective(OrderFamilyMember record);

    int updateByPrimaryKey(OrderFamilyMember record);
}