package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocMember;

public interface IsocMemberMapper {
    int deleteByPrimaryKey(Integer isocmemberid);

    int insert(IsocMember record);

    int insertSelective(IsocMember record);

    IsocMember selectByPrimaryKey(Integer isocmemberid);

    int updateByPrimaryKeySelective(IsocMember record);

    int updateByPrimaryKey(IsocMember record);
}