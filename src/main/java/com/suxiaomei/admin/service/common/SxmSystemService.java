package com.suxiaomei.admin.service.common;

public interface SxmSystemService {
	/**
	 * 初始化系统信息到redis
	 * 1.系统启动运行
	 */
	void updateSysToRedis();

}
