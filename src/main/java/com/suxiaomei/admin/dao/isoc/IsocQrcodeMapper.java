package com.suxiaomei.admin.dao.isoc;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocQrcode;

public interface IsocQrcodeMapper {
    int deleteByPrimaryKey(Integer isocqrcodeid);

    int insert(IsocQrcode record);

    int insertSelective(IsocQrcode record);

    IsocQrcode selectByPrimaryKey(Integer isocqrcodeid);

    int updateByPrimaryKeySelective(IsocQrcode record);

    int updateByPrimaryKey(IsocQrcode record);
    /**
     * 根据家协id，关联id和类型查询企业二维码或是护理员二维码
     * @param isocid
     * @param relationid
     * @param type 1企业 2护理员
     * @return
     */
	IsocQrcode findByIsocidAndRelationidAndType(@Param("isocid")Integer isocid,@Param("relationid")Integer relationid,@Param("type")Integer type);
}