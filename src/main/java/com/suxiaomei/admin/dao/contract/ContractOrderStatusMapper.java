package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrderStatus;

public interface ContractOrderStatusMapper {
    int deleteByPrimaryKey(Integer contractorderstatusid);

    int insert(ContractOrderStatus record);

    int insertSelective(ContractOrderStatus record);

    ContractOrderStatus selectByPrimaryKey(Integer contractorderstatusid);

    int updateByPrimaryKeySelective(ContractOrderStatus record);

    int updateByPrimaryKey(ContractOrderStatus record);
}