package com.suxiaomei.admin.service.impl.isoc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.isoc.IsocLogMapper;
import com.suxiaomei.admin.entity.isoc.IsocLog;
import com.suxiaomei.admin.service.isoc.IsocLogService;

@Service
@Transactional
public class IsocLogServiceImpl implements IsocLogService {
	
	@Autowired
	private IsocLogMapper isocLogDao;
	
	@Override
	public int saveLog(IsocLog ilog) {
		return isocLogDao.insert(ilog);
	}

}
