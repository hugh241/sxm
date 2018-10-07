package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.Introducer;

public interface IntroducerMapper {
    int deleteByPrimaryKey(Integer introducerid);

    int insert(Introducer record);

    int insertSelective(Introducer record);

    Introducer selectByPrimaryKey(Integer introducerid);

    int updateByPrimaryKeySelective(Introducer record);

    int updateByPrimaryKey(Introducer record);
}