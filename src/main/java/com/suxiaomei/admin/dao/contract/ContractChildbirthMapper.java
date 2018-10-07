package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractChildbirth;

public interface ContractChildbirthMapper {
    int deleteByPrimaryKey(Integer contractchildbirthid);

    int insert(ContractChildbirth record);

    int insertSelective(ContractChildbirth record);

    ContractChildbirth selectByPrimaryKey(Integer contractchildbirthid);

    int updateByPrimaryKeySelective(ContractChildbirth record);

    int updateByPrimaryKey(ContractChildbirth record);
}