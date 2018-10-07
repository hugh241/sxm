package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Integer memberid);

    int insert(Member record);

    int insertSelective(Member record);

    Member selectByPrimaryKey(Integer memberid);

    int updateByPrimaryKeySelective(Member record);

    int updateByPrimaryKey(Member record);
}