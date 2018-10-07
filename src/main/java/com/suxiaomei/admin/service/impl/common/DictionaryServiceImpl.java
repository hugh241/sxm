package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.common.DictionaryMapper;
import com.suxiaomei.admin.entity.common.Dictionary;
import com.suxiaomei.admin.service.common.DictionaryService;
import com.suxiaomei.admin.util.redis.RedisUtil;
@Service
@Transactional
public class DictionaryServiceImpl implements DictionaryService {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private DictionaryMapper dictionaryDao;

	@Override
	public void updateToRedis() {
		List<Dictionary> dicList = dictionaryDao.findAll();
		for (int i = 0; i < dicList.size(); i++) {
			RedisUtil.setList(redisTemplate,dicList.get(i).getDictionarykey(),dicList.get(i).getValues());
		}
	}

}
