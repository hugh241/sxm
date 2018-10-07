package com.suxiaomei.admin.dao.account;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.account.Contact;

public interface ContactMapper {
    int deleteByPrimaryKey(Integer contactid);

    int insert(Contact record);

    int insertSelective(Contact record);

    Contact selectByPrimaryKey(Integer contactid);

    int updateByPrimaryKeySelective(Contact record);

    int updateByPrimaryKey(Contact record);
    /**
     * 根据关联id和类型查询联系人列表
     * @param relationid 关联id
     * @param type 类型 3企业 5家协
     * @return
     */
    List<Contact> findByRelationidAndType(@Param("relationid")Integer relationid,@Param("type")Integer type);
}