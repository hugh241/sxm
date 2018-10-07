package com.suxiaomei.admin.service.impl.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.common.LogMapper;
import com.suxiaomei.admin.entity.common.Log;
import com.suxiaomei.admin.service.common.LogService;
@Service
@Transactional
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logDao;
	
	@Override
	public int saveLog(Log le) {
		return logDao.insertSelective(le);
	}
}
