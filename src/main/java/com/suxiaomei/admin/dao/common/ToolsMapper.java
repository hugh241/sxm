package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.Tools;

public interface ToolsMapper {
    int deleteByPrimaryKey(Integer toolsid);

    int insert(Tools record);

    int insertSelective(Tools record);

    Tools selectByPrimaryKey(Integer toolsid);

    int updateByPrimaryKeySelective(Tools record);

    int updateByPrimaryKey(Tools record);
    /**
     * 根据系统成员id查询系统成员下所有工具
     * @param familymemberid
     * @return
     */
    List<Tools> findByFamilymemberid(Integer familymemberid);
    /**
     * 查询所有工具
     * @return
     */
	List<Tools> findAll();
}