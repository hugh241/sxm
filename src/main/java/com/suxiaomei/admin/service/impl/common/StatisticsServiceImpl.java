package com.suxiaomei.admin.service.impl.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.common.StatisticsMapper;
import com.suxiaomei.admin.entity.account.User;
import com.suxiaomei.admin.service.common.StatisticsService;

@Service
@Transactional
public class StatisticsServiceImpl implements StatisticsService {
	@Autowired
	private StatisticsMapper statisticsDao;
	@Autowired
	private GlobalConfig config;

	@Override
	public List<Map<String,Object>> findEmployeeGenderStatistics(User user, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeGenderStatistics(user.getRole().getRelationid(),type);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findEmployeeWorktypeStatistics(User user, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeWorktypeStatistics(user.getRole().getRelationid(),type);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findEmployeeAgeStatistics(User user, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeAgeStatistics(user.getRole().getRelationid(),type);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findEmployeeExperienceStatistics(User user, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeExperienceStatistics(user.getRole().getRelationid(),type);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findEmployeeProvinceStatistics(User user, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeProvinceStatistics(user.getRole().getRelationid(),type);
		}
		return list;
	}

	@Override
	public List<Map<String, Object>> findEmployeeCityStatistics(User user, int provinceid, int type) {
		List<Map<String,Object>> list = new ArrayList<>();
		if(user.getRole().getType() == config.INT_ISOCNO){//统计家协下所有会员单位的护理员
			list = statisticsDao.findIsocMembersEmployeeCityStatistics(user.getRole().getRelationid(),provinceid,type);
		}
		return list;
	}
}
