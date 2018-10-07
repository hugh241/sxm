package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrder;

public interface ContractOrderMapper {
    int deleteByPrimaryKey(Integer contractorderid);

    int insert(ContractOrder record);

    int insertSelective(ContractOrder record);

    ContractOrder selectByPrimaryKey(Integer contractorderid);

    int updateByPrimaryKeySelective(ContractOrder record);

    int updateByPrimaryKey(ContractOrder record);
}