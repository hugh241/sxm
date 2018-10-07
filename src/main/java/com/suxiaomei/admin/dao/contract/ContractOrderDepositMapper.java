package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrderDeposit;

public interface ContractOrderDepositMapper {
    int deleteByPrimaryKey(Integer contractorderdepositid);

    int insert(ContractOrderDeposit record);

    int insertSelective(ContractOrderDeposit record);

    ContractOrderDeposit selectByPrimaryKey(Integer contractorderdepositid);

    int updateByPrimaryKeySelective(ContractOrderDeposit record);

    int updateByPrimaryKey(ContractOrderDeposit record);
}