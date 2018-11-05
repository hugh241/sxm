package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrderData;

public interface IsocBusinessOrderDataMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderdataid);

    int insert(IsocBusinessOrderData record);

    int insertSelective(IsocBusinessOrderData record);

    IsocBusinessOrderData selectByPrimaryKey(Integer isocbusinessorderdataid);

    int updateByPrimaryKeySelective(IsocBusinessOrderData record);

    int updateByPrimaryKey(IsocBusinessOrderData record);
    /**
     * 根据认证订单id查询需要认证的项目列表
     * @param relationid 关联id
     * @param type 0企业认证 1阿姨认证
     * @return
     */
    List<IsocBusinessOrderData> findByRelationidAndType(@Param("relationid")int relationid,@Param("type")int type);
}