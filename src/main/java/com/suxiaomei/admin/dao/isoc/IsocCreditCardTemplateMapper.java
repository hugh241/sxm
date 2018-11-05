package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;

public interface IsocCreditCardTemplateMapper {
    int deleteByPrimaryKey(Integer isoccreditcardtemplateid);

    int insert(IsocCreditCardTemplate record);

    int insertSelective(IsocCreditCardTemplate record);

    IsocCreditCardTemplate selectByPrimaryKey(Integer isoccreditcardtemplateid);

    int updateByPrimaryKeySelective(IsocCreditCardTemplate record);

    int updateByPrimaryKey(IsocCreditCardTemplate record);
    /**
     * 分页查询护理员卡片模板
     * @param pageNo
     * @param pageSize
     * @param t
     * @return
     */
	List<IsocCreditCardTemplate> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("tem")IsocCreditCardTemplate t);
	/**
	 * 根据条件查询总数
	 * @param isoc
	 * @return
	 */
	Integer findCountByCondition(@Param("tem")IsocCreditCardTemplate t);
	/**
	 * 根据类型，家协id重置该家协下所有相同类型为未使用状态
	 * @param type
	 * @param isocid
	 * @return
	 */
	int updateResetTemplateByTypeAndIsocid(@Param("type")Integer type,@Param("isocid")Integer isocid);
	/**
	 * 根据正/反面类型，家协id查询启用状态下的模板
	 * @param type 1正面 2反面
	 * @param isocid
	 * @return
	 */
	IsocCreditCardTemplate findUseingTemplateByTypeAndIsocid(@Param("type")Integer type,@Param("isocid")Integer isocid);
}