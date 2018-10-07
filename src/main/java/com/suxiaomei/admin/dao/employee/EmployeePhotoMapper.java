package com.suxiaomei.admin.dao.employee;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.suxiaomei.admin.entity.employee.EmployeePhoto;

public interface EmployeePhotoMapper {
    int deleteByPrimaryKey(Integer employeephotoid);

    int insert(EmployeePhoto record);

    int insertSelective(EmployeePhoto record);

    EmployeePhoto selectByPrimaryKey(Integer employeephotoid);

    int updateByPrimaryKeySelective(EmployeePhoto record);

    int updateByPrimaryKey(EmployeePhoto record);
    /**
     * 条件分页查询员工照片
     * @param pageNo
     * @param pageSize
     * @param photo
     * @return
     */
	List<EmployeePhoto> findByPageList(@Param("pageNo")int pageNo,@Param("pageSize")int pageSize,@Param("photo")EmployeePhoto photo);
	/**
	 * 根据条件查询图片总数
	 * @param photo
	 * @return
	 */
	int findCountByCondition(@Param("photo")EmployeePhoto photo);
}