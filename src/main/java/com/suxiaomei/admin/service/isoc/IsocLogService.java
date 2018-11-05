package com.suxiaomei.admin.service.isoc;

import com.suxiaomei.admin.entity.isoc.IsocLog;

public interface IsocLogService {
	/**
	 * 保存家协日志
	 * @param ilog
	 * @return
	 */
	int saveLog(IsocLog ilog);
}
