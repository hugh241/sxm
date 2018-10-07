package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.common.SxmSystemMapper;
import com.suxiaomei.admin.response.Dict;
import com.suxiaomei.admin.service.common.SxmSystemService;
import com.suxiaomei.admin.util.redis.RedisUtil;
@Service
@Transactional
public class SxmSystemServiceImpl implements SxmSystemService {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private SxmSystemMapper sxmSystemDao;
	@Autowired
	private GlobalConfig config;
	
	@Override
	public void updateSysToRedis() {
		List<Dict> ssList = sxmSystemDao.findAllForRedis();
		RedisUtil.setList(redisTemplate,config.redisSxmsystem,ssList);
	}

}
