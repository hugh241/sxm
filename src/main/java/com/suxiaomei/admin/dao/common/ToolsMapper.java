package com.suxiaomei.admin.dao.common;

import com.suxiaomei.admin.entity.common.Tools;

public interface ToolsMapper {
    int deleteByPrimaryKey(Integer toolsid);

    int insert(Tools record);

    int insertSelective(Tools record);

    Tools selectByPrimaryKey(Integer toolsid);

    int updateByPrimaryKeySelective(Tools record);

    int updateByPrimaryKey(Tools record);
}