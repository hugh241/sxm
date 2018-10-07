package com.suxiaomei.admin.dao.business;

import com.suxiaomei.admin.entity.business.BusinessWorkGroupUsers;

public interface BusinessWorkGroupUsersMapper {
    int deleteByPrimaryKey(Integer businessworkgroupusersid);

    int insert(BusinessWorkGroupUsers record);

    int insertSelective(BusinessWorkGroupUsers record);

    BusinessWorkGroupUsers selectByPrimaryKey(Integer businessworkgroupusersid);

    int updateByPrimaryKeySelective(BusinessWorkGroupUsers record);

    int updateByPrimaryKey(BusinessWorkGroupUsers record);
}