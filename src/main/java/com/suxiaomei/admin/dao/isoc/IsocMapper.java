package com.suxiaomei.admin.dao.isoc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.isoc.Isoc;
import com.suxiaomei.admin.entity.isoc.extend.IsocEmpowerExtend;
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
	Integer findCountByCondition(@Param("isoc")Isoc isoc);
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
	/**
	 * 根据家协id查询家协详细信息
	 * @param isocid
	 * @return
	 */
	IsocExtend findDetailByIsocid(Integer isocid);
	/**
	 * 根据授权企业id查询授权企业所属的家协
	 * @param isocempowerfirmid
	 * @return
	 */
	Isoc findByIsocempowerfirmid(Integer isocempowerfirmid);
	/**
	 * 根据企业id查询出没有认证该企业为会员的所有家协
	 * @param businessid
	 * @return
	 */
	List<Isoc> findIsocWitchNotAuthMembers(Integer businessid);
	/**
	 * 根据企业id查询认证该企为会员的所有家协
	 * @param businessid
	 * @return
	 */
	List<Isoc> findIsocWitchAuthMember(Integer businessid);
	/**
	 * 根据企业id查询认证了该企业的所有家协和家协下的授权单位
	 * @param businessid
	 * @return
	 */
	List<IsocEmpowerExtend> findIsocEmpowerByBusinessid(Integer businessid);
}