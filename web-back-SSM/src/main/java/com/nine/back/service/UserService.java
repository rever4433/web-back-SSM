package com.nine.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.back.entity.AdminRole;
import com.nine.back.entity.AdminRoleResource;
import com.nine.back.entity.AdminUser;
import com.nine.back.mapper.AdminRoleMapper;
import com.nine.back.mapper.AdminRoleResourceMapper;
import com.nine.back.mapper.AdminUserMapper;

@Service
public class UserService {
	@Autowired
	private AdminUserMapper adminUserMapper;

	@Autowired
	private AdminRoleMapper adminRoleMapper;

	@Autowired
	private AdminRoleResourceMapper adminRoleResourceMapper;

	public AdminUser getAdminUserById(Integer id) {
		return adminUserMapper.selectByPrimaryKey(id);
	}

	public boolean insertAdminUser(AdminUser user){
		int i=adminUserMapper.insert(user);
		if(i==0) return false;
		return true;
		
	}

	public void deleteAdminUser(Integer id) {
		adminUserMapper.deleteByPrimaryKey(id);
	}

	public List<AdminRole> getAllAdminUser() {
		return adminRoleMapper.selectAllAdminRole();
	}

	public List<AdminRoleResource> getResourceIdByRoleCode(String rolecode) {
		return adminRoleResourceMapper.getResourceIdByRoleCode(rolecode);
	}

	public AdminUser getAdminUserByUserId(Integer userid) {
		return adminUserMapper.selectByPrimaryKey(userid);
	}

	public String getRoleNameByRoleID(String roleCode) {
		return adminRoleMapper.getRoleNameByRoleCode(roleCode);
	}

	public int getUserIdByUserName(String userName) {
		return adminUserMapper.getUserId(userName);
	}

	public String getRoleCodeByUserName(String userName) {
		return adminUserMapper.getRoleCodeByUserName(userName);
	}

	public void changeRoleCodeByUserName(String roleCode, String userName) {
		adminUserMapper.ChangeRoleCode(roleCode, userName);
	}

	public boolean Exist(String userName) {
		Integer userid = adminUserMapper.getUserId(userName);
		AdminUser user = adminUserMapper.selectByPrimaryKey(userid);
		return user != null ? true : false;
	}

	public AdminRole getAdminRoleByRoleName(String roleName) {
		return adminRoleMapper.getAdminRoleByRoleName(roleName);
	}
	
	public boolean UserIsExisted(Integer userid){
		AdminUser user=adminUserMapper.selectByPrimaryKey(userid);
		if(user==null) return false;
		return true;
	}

}
