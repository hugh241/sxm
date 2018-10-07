package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.Dictionary;

public interface DictionaryMapper {
    int deleteByPrimaryKey(Integer dictionaryid);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Integer dictionaryid);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);
    /**
     * 查询所有字段
     * @return
     */
	List<Dictionary> findAll();
}