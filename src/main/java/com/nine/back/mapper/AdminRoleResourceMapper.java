package com.nine.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.nine.back.entity.AdminRoleResource;

public interface AdminRoleResourceMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int insert(AdminRoleResource record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int insertSelective(AdminRoleResource record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	AdminRoleResource selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int updateByPrimaryKeySelective(AdminRoleResource record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role_resource
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int updateByPrimaryKey(AdminRoleResource record);

	@Select("select RESOURCEID from t_admin_role_resource where ROLECODE=#{roleCode}")
	List<AdminRoleResource> getResourceIdByRoleCode(String roleCode);

	@Select("select RESOURCEID from t_admin_role_resource where ROLECODE=#{rolecode}")
	List<Integer> getAllResourceId(String rolecode);

	@Select("select max(RESOURCEID) from t_admin_role_resource")
	Integer getMaxResourceId();
	
	@Select("select ROLECODE from t_admin_role_resource where RESOURCEID=#{rid}")
	String getRoleCode(Integer rid);
}