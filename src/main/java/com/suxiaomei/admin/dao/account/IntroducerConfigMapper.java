package com.suxiaomei.admin.dao.account;

import com.suxiaomei.admin.entity.account.IntroducerConfig;

public interface IntroducerConfigMapper {
    int deleteByPrimaryKey(Integer introducerconfigid);

    int insert(IntroducerConfig record);

    int insertSelective(IntroducerConfig record);

    IntroducerConfig selectByPrimaryKey(Integer introducerconfigid);

    int updateByPrimaryKeySelective(IntroducerConfig record);

    int updateByPrimaryKey(IntroducerConfig record);
}