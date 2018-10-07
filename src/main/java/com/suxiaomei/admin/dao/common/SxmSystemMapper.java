package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.SxmSystem;
import com.suxiaomei.admin.response.Dict;

public interface SxmSystemMapper {
    int deleteByPrimaryKey(Integer sxmsystemid);

    int insert(SxmSystem record);

    int insertSelective(SxmSystem record);

    SxmSystem selectByPrimaryKey(Integer sxmsystemid);

    int updateByPrimaryKeySelective(SxmSystem record);

    int updateByPrimaryKey(SxmSystem record);
    /**
     * 查询所有键值对系统信息到redis
     * @return
     */
	List<Dict> findAllForRedis();
}