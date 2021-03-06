package com.nine.back.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.nine.back.entity.AdminRole;
import com.nine.back.entity.AdminRoleExample;

public interface AdminRoleMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int countByExample(AdminRoleExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int insert(AdminRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int insertSelective(AdminRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	AdminRole selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int updateByPrimaryKeySelective(AdminRole record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table t_admin_role
	 *
	 * @mbggenerated Wed Apr 05 12:29:36 CST 2017
	 */
	int updateByPrimaryKey(AdminRole record);

	@Select("select ID,ROLECODE,ROLENAME from t_admin_role")
	@Results({ @Result(id = true, column = "ID", property = "id"), @Result(column = "ROLECODE", property = "rolecode"),
			@Result(column = "ROLENAME", property = "rolename") })
	List<AdminRole> selectAllAdminRole();

	@Select("select ID,ROLECODE,ROLENAME FROM t_admin_role where ROLECODE=#{rolecode}")
	@Results({ @Result(id = true, column = "ID", property = "id"), @Result(column = "ROLECODE", property = "rolecode"),
			@Result(column = "ROLENAME", property = "rolename") })
	AdminRole getAdminRoleByRoleCode(String rolecode);

	@Select("select ROLENAME from t_admin_role where ROLECODE=#{roleCode}")
	String getRoleNameByRoleCode(String roleCode);

	@Select("select * from t_admin_role where ROLENAME=#{rolename}")
	AdminRole getAdminRoleByRoleName(String rolename);

	@Select("select ROLECODE from t_admin_role where ROLENAME=#{rolename}")
	String getRoleCodeByRoleName(String rolename);
	
	
}