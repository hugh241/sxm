package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.MemberOther;

public interface MemberOtherMapper {
    int deleteByPrimaryKey(Integer memberotherid);

    int insert(MemberOther record);

    int insertSelective(MemberOther record);

    MemberOther selectByPrimaryKey(Integer memberotherid);

    int updateByPrimaryKeySelective(MemberOther record);

    int updateByPrimaryKey(MemberOther record);
}