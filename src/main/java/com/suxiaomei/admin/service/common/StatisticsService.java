package com.suxiaomei.admin.service.common;

import java.util.List;
import java.util.Map;

import com.suxiaomei.admin.entity.account.User;

/**
 * 统计
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年10月29日 上午9:45:31
 */
public interface StatisticsService {
	/**
	 * 查询护理员性别统计
	 * 1.家协端 护理员统计
	 * @param type 
	 * @param cUser
	 * @return
	 */
	List<Map<String,Object>> findEmployeeGenderStatistics(User user, int type);
	/**
	 * 护理员工种统计
	 * 1.家协端 护理员统计
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findEmployeeWorktypeStatistics(User user, int type);
	/**
	 * 年龄统计
	 * 1.家协端 护理员统计
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findEmployeeAgeStatistics(User user, int type);
	/**
	 * 工作经验统计
	 * 1.家协端 护理员统计
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findEmployeeExperienceStatistics(User user, int type);
	/**
	 * 所属省/直辖市/自治区统计
	 * 1.家协端 护理员统计
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findEmployeeProvinceStatistics(User user, int type);
	/**
	 * 市统计
	 * 1.家协端 护理员统计
	 * @param provinceid 
	 * @param user
	 * @return
	 */
	List<Map<String, Object>> findEmployeeCityStatistics(User cUser, int provinceid, int type);
}
