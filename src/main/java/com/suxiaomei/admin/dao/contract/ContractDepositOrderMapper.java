package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractDepositOrder;

public interface ContractDepositOrderMapper {
    int deleteByPrimaryKey(Integer contractdepositorderid);

    int insert(ContractDepositOrder record);

    int insertSelective(ContractDepositOrder record);

    ContractDepositOrder selectByPrimaryKey(Integer contractdepositorderid);

    int updateByPrimaryKeySelective(ContractDepositOrder record);

    int updateByPrimaryKey(ContractDepositOrder record);
}