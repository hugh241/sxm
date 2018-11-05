package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.MemberRecord;

public interface MemberRecordMapper {
    int deleteByPrimaryKey(Integer memberrecordid);

    int insert(MemberRecord record);

    int insertSelective(MemberRecord record);

    MemberRecord selectByPrimaryKey(Integer memberrecordid);

    int updateByPrimaryKeySelective(MemberRecord record);

    int updateByPrimaryKey(MemberRecord record);
    /**
     * 根据会员单位id查询该会员单位的审核记录
     * @param memberid
     * @return
     */
	List<MemberRecord> findByMemberid(int memberid);
}