package com.suxiaomei.admin.service.common;

public interface DictionaryService {
	/**
	 * 将数据字典根据键值对保存到redis中
	 */
	void updateToRedis();

}
