package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.Contract;

public interface ContractMapper {
    int deleteByPrimaryKey(Integer contractid);

    int insert(Contract record);

    int insertSelective(Contract record);

    Contract selectByPrimaryKey(Integer contractid);

    int updateByPrimaryKeySelective(Contract record);

    int updateByPrimaryKey(Contract record);
}