package com.suxiaomei.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.suxiaomei.admin.common.GlobalConfig;
import com.suxiaomei.admin.service.common.AddressService;
import com.suxiaomei.admin.service.common.DictionaryService;
import com.suxiaomei.admin.service.common.GoodsService;
import com.suxiaomei.admin.service.common.SxmSystemService;
import com.suxiaomei.admin.service.isoc.IsocService;
/**
 * 系统启动时运行的任务
 *　　　　　　　 ┏┓       ┏┓+ +
 *　　　　　　　┏┛┻━━━━━━━┛┻┓ + +
 *　　　　　　　┃　　　　　　 ┃
 *　　　　　　　┃　　　━　　　┃ ++ + + +
 *　　　　　　 █████━█████  ┃+
 *　　　　　　　┃　　　　　　 ┃ +
 *　　　　　　　┃　　　┻　　　┃
 *　　　　　　　┃　　　　　　 ┃ + +
 *　　　　　　　┗━━┓　　　 ┏━┛
 *               ┃　　  ┃
 *　　　　　　　　　┃　　  ┃ + + + +
 *　　　　　　　　　┃　　　┃　Code is far away from bug with the god animal protecting
 *　　　　　　　　　┃　　　┃ + 　　　　         神兽保佑,代码无bug
 *　　　　　　　　　┃　　　┃
 *　　　　　　　　　┃　　　┃　　+
 *　　　　　　　　　┃　 　 ┗━━━┓ + +
 *　　　　　　　　　┃ 　　　　　┣┓
 *　　　　　　　　　┃ 　　　　　┏┛
 *　　　　　　　　　┗┓┓┏━━━┳┓┏┛ + + + +
 *　　　　　　　　　 ┃┫┫　 ┃┫┫
 *　　　　　　　　　 ┗┻┛　 ┗┻┛+ + + +
 * @author zl
 * 2018年9月20日 下午5:05:45
 */
@Component("BeanDefineConfigue")
public class OnApplicationController implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	private IsocService isocService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private DictionaryService dictionaryService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private SxmSystemService sxmSystemService;
	@Autowired
	private GlobalConfig config;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if(event.getApplicationContext().getDisplayName().equals("Root WebApplicationContext") && Boolean.parseBoolean(config.redisupdate)){
			//初始化家协token
			isocService.updateAllToken();
			//更新省市县信息
			addressService.updateAddressToRedis();
			//将数据字典信息保存到redis
			dictionaryService.updateToRedis();
			//将系统产品保存到redis
			goodsService.updateGoodsListToRedis();
//			//初始化系统信息到redis
			sxmSystemService.updateSysToRedis();
		}
	}
}
