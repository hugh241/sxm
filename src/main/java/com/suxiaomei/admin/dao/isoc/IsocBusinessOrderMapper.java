package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;

public interface IsocBusinessOrderMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderid);

    int insert(IsocBusinessOrder record);

    int insertSelective(IsocBusinessOrder record);

    IsocBusinessOrder selectByPrimaryKey(Integer isocbusinessorderid);

    int updateByPrimaryKeySelective(IsocBusinessOrder record);

    int updateByPrimaryKey(IsocBusinessOrder record);
}