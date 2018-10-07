package com.suxiaomei.admin.dao.contract;

import com.suxiaomei.admin.entity.contract.ContractOrderReceiptItem;

public interface ContractOrderReceiptItemMapper {
    int deleteByPrimaryKey(Integer contractorderreceiptitemid);

    int insert(ContractOrderReceiptItem record);

    int insertSelective(ContractOrderReceiptItem record);

    ContractOrderReceiptItem selectByPrimaryKey(Integer contractorderreceiptitemid);

    int updateByPrimaryKeySelective(ContractOrderReceiptItem record);

    int updateByPrimaryKey(ContractOrderReceiptItem record);
}