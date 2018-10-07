package com.suxiaomei.admin.service.impl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suxiaomei.admin.dao.common.BannerMapper;
import com.suxiaomei.admin.entity.common.Banner;
import com.suxiaomei.admin.service.common.BannerService;

@Service
@Transactional
public class BannerServiceImpl implements BannerService {
	@Autowired
	private BannerMapper bannerDao;

	@Override
	public List<Banner> findByType(int type) {
		List<Banner> bannerList = bannerDao.findByType(type);
		return bannerList;
	}

	@Override
	public Banner findById(int id) {
		return bannerDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateBannerSort(String ids) {
		String[] idStrArr = ids.split(",");
		for (int i = 0; i < idStrArr.length; i++) {
			int id = Integer.parseInt(idStrArr[i]);
			Banner banner = bannerDao.selectByPrimaryKey(id);
			if(banner != null){
				banner.setSort(i);
				bannerDao.updateByPrimaryKeySelective(banner);
			}
		}
		return 1;
	}

	@Override
	public int add(Banner banner) {
		return bannerDao.insert(banner);
	}

	@Override
	public int delete(int id) {
		return bannerDao.deleteByPrimaryKey(id);
	}

	@Override
	public int update(Banner banner) {
		return bannerDao.updateByPrimaryKeySelective(banner);
	}

}
