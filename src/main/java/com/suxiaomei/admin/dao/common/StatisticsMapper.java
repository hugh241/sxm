package com.suxiaomei.admin.dao.common;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

/**
 * 自定义统计mapper
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
 * 2018年10月29日 上午9:53:05
 */
public interface StatisticsMapper {
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的性别
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @return
	 */
	public List<Map<String,Object>> findIsocMembersEmployeeGenderStatistics(@Param("isocid")int isocid,@Param("type")int type);
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的工种
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @return
	 */
	public List<Map<String, Object>> findIsocMembersEmployeeWorktypeStatistics(@Param("isocid")int isocid,@Param("type")int type);
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的年龄
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @return
	 */
	public List<Map<String, Object>> findIsocMembersEmployeeAgeStatistics(@Param("isocid")int isocid,@Param("type")int type);
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的工作经验
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @return
	 */
	public List<Map<String, Object>> findIsocMembersEmployeeExperienceStatistics(@Param("isocid")int isocid,@Param("type")int type);
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的所属省/直辖市/自治区
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @return
	 */
	public List<Map<String, Object>> findIsocMembersEmployeeProvinceStatistics(@Param("isocid")int isocid,@Param("type")int type);
	/**
	 * 根据家协id统计家协下所有会员单位下的护理员的所属市
	 * @param isocid 家协id
	 * @param type 0所有 1认证过的
	 * @param provinceid 
	 * @return
	 */
	public List<Map<String, Object>> findIsocMembersEmployeeCityStatistics(@Param("isocid")int isocid,@Param("provinceid")int provinceid,@Param("type")int type);
}
