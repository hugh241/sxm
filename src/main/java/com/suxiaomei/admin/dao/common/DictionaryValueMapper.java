package com.suxiaomei.admin.dao.common;

import java.util.List;

import com.suxiaomei.admin.entity.common.DictionaryValue;

public interface DictionaryValueMapper {
    int deleteByPrimaryKey(Integer dictionaryvalueid);

    int insert(DictionaryValue record);

    int insertSelective(DictionaryValue record);

    DictionaryValue selectByPrimaryKey(Integer dictionaryvalueid);

    int updateByPrimaryKeySelective(DictionaryValue record);

    int updateByPrimaryKey(DictionaryValue record);
    /**
     * 根据字典键id查询该字典所有值
     * @param dictionaryid
     * @return
     */
    List<DictionaryValue> getByDictionaryid(Integer dictionaryid);
}