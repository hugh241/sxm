package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderDataDetail;

public interface IsocBusinessOrderDataDetailMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderdatadetailid);

    int insert(IsocBusinessOrderDataDetail record);

    int insertSelective(IsocBusinessOrderDataDetail record);

    IsocBusinessOrderDataDetail selectByPrimaryKey(Integer isocbusinessorderdatadetailid);

    int updateByPrimaryKeySelective(IsocBusinessOrderDataDetail record);

    int updateByPrimaryKey(IsocBusinessOrderDataDetail record);
    /**
     * 根据企业认证项目id查询该项目下的图片列表
     * @param isocbusinessorderdataid
     * @return
     */
    List<IsocBusinessOrderDataDetail> findByIsocbusinessorderdataid(Integer isocbusinessorderdataid);
}