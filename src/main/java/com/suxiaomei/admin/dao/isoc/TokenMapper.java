package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.Token;

public interface TokenMapper {
    int deleteByPrimaryKey(Integer tokenid);

    int insert(Token record);

    int insertSelective(Token record);

    Token selectByPrimaryKey(Integer tokenid);

    int updateByPrimaryKeySelective(Token record);

    int updateByPrimaryKey(Token record);
    /**
     * 根据家协id查询家协的token信息
     * @param isocid
     * @return
     */
	Token findByIsocid(int isocid);
}