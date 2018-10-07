package com.suxiaomei.admin.service.common;

public interface DictionaryService {
	/**
	 * 将数据字典根据键值对保存到redis中
	 * 1.系统启动运行
	 */
	void updateToRedis();

}
