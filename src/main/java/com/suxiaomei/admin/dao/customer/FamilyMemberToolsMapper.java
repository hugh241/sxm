package com.suxiaomei.admin.dao.customer;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.customer.FamilyMemberTools;
import com.suxiaomei.admin.entity.customer.extend.FamilyMemberToolsExtend;

public interface FamilyMemberToolsMapper {
    int deleteByPrimaryKey(Integer familymembertoolsid);

    int insert(FamilyMemberTools record);

    int insertSelective(FamilyMemberTools record);

    FamilyMemberTools selectByPrimaryKey(Integer familymembertoolsid);

    int updateByPrimaryKeySelective(FamilyMemberTools record);

    int updateByPrimaryKey(FamilyMemberTools record);
    /**
     * 查询家庭成员工具关联列表
     * @return
     */
	List<FamilyMemberToolsExtend> findList();
	/**
	 * 根据工具id和成员id查询关联
	 * @param toolsid
	 * @param familymemberid
	 * @return
	 */
	FamilyMemberTools findByToolsidAndFamilymemberid(@Param("toolsid")int toolsid,@Param("familymemberid")int familymemberid);
}