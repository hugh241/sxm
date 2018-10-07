package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.extend.IsocExtend;

public interface IsocMapper {
    int deleteByPrimaryKey(Integer isocid);

    int insert(Isoc record);

    int insertSelective(Isoc record);

    Isoc selectByPrimaryKey(Integer isocid);

    int updateByPrimaryKeySelective(Isoc record);

    int updateByPrimaryKey(Isoc record);
    /**
     * 查询出所有编辑了appid和appscerect的家协
     * @return
     */
	List<Isoc> selectWhoHasAppidAndAppSecrect();
	/**
	 * 根据条件分页查询家协列表
	 * @param pageNo 索引
	 * @param pageSize 每页大小
	 * @param isoc 查询条件
	 * @return 分页列表
	 */
	List<IsocExtend> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("isoc")Isoc isoc);
	/**
	 * 根据条件查询总数
	 * @param isoc
	 * @return
	 */
	int findCountByCondition(@Param("isoc")Isoc isoc);
	/**
	 * 根据家协名称
	 * 查询是否存在 同名 的家协
	 * @param name
	 * @param provinceid
	 * @param cityid
	 * @return
	 */
	Isoc findByName(@Param("name")String name);
	/**
	 * 根据家协归属地
	 * 查询是否存在 相同归属地 的家协
	 * @param name
	 * @param provinceid
	 * @param cityid
	 * @return
	 */
	Isoc findByAddressid(@Param("addressid")Integer addressid);
}