package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.MemberRecord;

public interface MemberRecordMapper {
    int deleteByPrimaryKey(Integer memberrecordid);

    int insert(MemberRecord record);

    int insertSelective(MemberRecord record);

    MemberRecord selectByPrimaryKey(Integer memberrecordid);

    int updateByPrimaryKeySelective(MemberRecord record);

    int updateByPrimaryKey(MemberRecord record);
}