package com.suxiaomei.admin.dao.customer;

import java.util.List;

import com.suxiaomei.admin.entity.customer.FamilyMember;

public interface FamilyMemberMapper {
    int deleteByPrimaryKey(Integer familymemberid);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    FamilyMember selectByPrimaryKey(Integer familymemberid);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);
    /**
     * 订单类型id
     * @param ordertypeid
     * @return
     */
    int findByOrdertypeid(int ordertypeid);
    /**
     * 查询所有系统成员
     * @return
     */
	List<FamilyMember> findAll();
}