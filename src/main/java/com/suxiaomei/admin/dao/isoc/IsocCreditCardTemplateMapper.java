package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;

public interface IsocCreditCardTemplateMapper {
    int deleteByPrimaryKey(Integer isoccreditcardtemplateid);

    int insert(IsocCreditCardTemplate record);

    int insertSelective(IsocCreditCardTemplate record);

    IsocCreditCardTemplate selectByPrimaryKey(Integer isoccreditcardtemplateid);

    int updateByPrimaryKeySelective(IsocCreditCardTemplate record);

    int updateByPrimaryKey(IsocCreditCardTemplate record);
}