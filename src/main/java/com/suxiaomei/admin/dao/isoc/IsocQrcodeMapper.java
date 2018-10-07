package com.suxiaomei.admin.dao.isoc;

import com.suxiaomei.admin.entity.isoc.IsocQrcode;

public interface IsocQrcodeMapper {
    int deleteByPrimaryKey(Integer isocqrcodeid);

    int insert(IsocQrcode record);

    int insertSelective(IsocQrcode record);

    IsocQrcode selectByPrimaryKey(Integer isocqrcodeid);

    int updateByPrimaryKeySelective(IsocQrcode record);

    int updateByPrimaryKey(IsocQrcode record);
}