package com.suxiaomei.admin.service.isoc;

import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.entity.employee.EmployeeCreditCard;
import com.suxiaomei.admin.entity.isoc.IsocCreditCardTemplate;
import com.suxiaomei.admin.util.QueryResult;

public interface IsocCreditCardTemplateService {
	/**
	 * 条件查询模板列表
	 * 1.家协段 护理员模板管理
	 * @param condition
	 * @param user
	 * @return
	 */
	QueryResult<IsocCreditCardTemplate> findByCondition(String condition, User user);
	/**
	 * 新增护理员模板
	 * 1.家协段 护理员模板管理
	 * @param isocCreditCardTemplate
	 * @param user
	 * @return
	 */
	int save(IsocCreditCardTemplate isocCreditCardTemplate, User user);
	/**
	 * 跟新模板背景图片
	 * 1.家协段 护理员模板管理
	 * @param id
	 * @param url
	 * @return
	 */
	int updateBackImg(int id, String url);
	/**
	 * 修改模板信息
	 * 1.家协段 护理员模板管理
	 * @param isocCreditCardTemplate
	 * @return
	 */
	int update(IsocCreditCardTemplate isocCreditCardTemplate);
	/**
	 * 启用模板
	 * 1.家协段 护理员模板管理
	 * @param id
	 * @return
	 */
	int updateUseStatus(int id);
	/**
	 * 删除模板
	 * 1.家协段 护理员模板管理
	 * @param id
	 * @return
	 */
	int delete(int id);
	/**
	 * 根据家协id和护理员id查询护理员在当前家协下的护理员名片
	 * @param isocid
	 * @param employeeid
	 * @return
	 */
	EmployeeCreditCard updateAndGetEmployeeCard(Integer isocid, int employeeid);

}
