package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.dao.common.ProvinceMapper;
import com.suxiaomei.admin.entity.common.Province;
import com.suxiaomei.admin.service.common.AddressService;
import com.suxiaomei.admin.util.redis.RedisUtil;
@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private ProvinceMapper provinceDao;
	@Autowired
	private GlobalConfig config;

	@Override
	public void updateAddressToRedis() {
		//查询redis中是否存在省信息
		List<Province> list = RedisUtil.getList(redisTemplate, config.redisProvince, new Province());
		if(list != null && list.size() > 0){//存在直接返回，不做后面操作
			return;
		}
		List<Province> provinceList = provinceDao.findAll();
		RedisUtil.setList(redisTemplate,config.provinceCityCounty,provinceList);
		for (int i = 0;provinceList != null && i < provinceList.size(); i++) {
			for (int j = 0;provinceList.get(i).getCityList() != null && j < provinceList.get(i).getCityList().size(); j++) {
				RedisUtil.setList(redisTemplate,config.redisCounty+provinceList.get(i).getCityList().get(j).getCityid(),provinceList.get(i).getCityList().get(j).getCountyList());//区
				provinceList.get(i).getCityList().get(j).setCountyList(null);
			}
			RedisUtil.setList(redisTemplate,config.redisCity+provinceList.get(i).getProvinceid(),provinceList.get(i).getCityList());//市
			provinceList.get(i).setCityList(null);
		}
		RedisUtil.setList(redisTemplate,config.redisProvince,provinceList);//保存省
	}

}
