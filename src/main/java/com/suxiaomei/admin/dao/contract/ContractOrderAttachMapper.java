package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrderAttach;

public interface ContractOrderAttachMapper {
    int deleteByPrimaryKey(Integer contractorderattachid);

    int insert(ContractOrderAttach record);

    int insertSelective(ContractOrderAttach record);

    ContractOrderAttach selectByPrimaryKey(Integer contractorderattachid);

    int updateByPrimaryKeySelective(ContractOrderAttach record);

    int updateByPrimaryKey(ContractOrderAttach record);
}