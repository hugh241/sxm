package com.suxiaomei.admin.dao.customer;

import com.suxiaomei.admin.entity.customer.FamilyMemberTools;

public interface FamilyMemberToolsMapper {
    int deleteByPrimaryKey(Integer familymembertoolsid);

    int insert(FamilyMemberTools record);

    int insertSelective(FamilyMemberTools record);

    FamilyMemberTools selectByPrimaryKey(Integer familymembertoolsid);

    int updateByPrimaryKeySelective(FamilyMemberTools record);

    int updateByPrimaryKey(FamilyMemberTools record);
}