package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocIdentificationBusiness;
import com.suxiaomei.admin.entity.isoc.extend.IsocIdentificationBusinessExtend;

public interface IsocIdentificationBusinessMapper {
    int deleteByPrimaryKey(Integer isocidentificationbusinessid);

    int insert(IsocIdentificationBusiness record);

    int insertSelective(IsocIdentificationBusiness record);

    IsocIdentificationBusiness selectByPrimaryKey(Integer isocidentificationbusinessid);

    int updateByPrimaryKeySelective(IsocIdentificationBusiness record);

    int updateByPrimaryKey(IsocIdentificationBusiness record);
    /**
     * 根据企业id查询企业所有家协认证列表
     * @param businessid
     * @return
     */
    List<IsocIdentificationBusinessExtend> findByBusinessid(Integer businessid);
}