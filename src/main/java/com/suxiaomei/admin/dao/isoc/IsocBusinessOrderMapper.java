package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.IsocBusinessOrder;
import com.suxiaomei.admin.entity.isoc.extend.IsocBusinessOrderExtend;

public interface IsocBusinessOrderMapper {
    int deleteByPrimaryKey(Integer isocbusinessorderid);

    int insert(IsocBusinessOrder record);

    int insertSelective(IsocBusinessOrder record);

    IsocBusinessOrder selectByPrimaryKey(Integer isocbusinessorderid);

    int updateByPrimaryKeySelective(IsocBusinessOrder record);

    int updateByPrimaryKey(IsocBusinessOrder record);
    
    /**
	 * 根据条件分页查询企业认证申请列表
	 * @param pageNo 索引
	 * @param pageSize 每页大小
	 * @param isoc 查询条件
	 * @return 分页列表
	 */
	List<IsocBusinessOrderExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("order")IsocBusinessOrderExtend order);
	/**
	 * 根据条件查询总数
	 * @param isoc
	 * @return
	 */
	Integer findCountByCondition(@Param("order")IsocBusinessOrderExtend order);
	/**
	 * 根据认证子项id查询出认证订单
	 * @param isocbusinessorderdataid
	 * @return
	 */
	IsocBusinessOrder findByIsocbusinessorderdataid(Integer isocbusinessorderdataid);
	/**
	 * 根据认证子项详细记录id查询出认证订单
	 * @param isocbusinessorderdatadetailid
	 * @return
	 */
	IsocBusinessOrder findByIsocbusinessorderdatadetailid(int isocbusinessorderdatadetailid);
}