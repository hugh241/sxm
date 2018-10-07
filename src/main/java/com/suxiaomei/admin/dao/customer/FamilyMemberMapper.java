package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.FamilyMember;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer familymemberid);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Integer familymemberid);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
}