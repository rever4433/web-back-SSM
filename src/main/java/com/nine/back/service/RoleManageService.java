package com.nine.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.back.entity.AdminRole;
import com.nine.back.entity.AdminRoleResource;
import com.nine.back.mapper.AdminRoleMapper;
import com.nine.back.mapper.AdminRoleResourceMapper;

@Service
public class RoleManageService {
	@Autowired
	private AdminRoleMapper adminRoleMapper;
	
	@Autowired
	private AdminRoleResourceMapper adminRoleResourceMapper;
	
	public int insertAdminRole(AdminRole adminRole){
		return adminRoleMapper.insert(adminRole);
	}
	
	public int insertAdminRoleResource(AdminRoleResource adminRoleResource){
		return adminRoleResourceMapper.insert(adminRoleResource);
	}
	
	public void AddAdminRole(String roleCode,String roleName){
		AdminRole role=new AdminRole();
		role.setRolecode(roleCode);
		role.setRolename(roleName);
		adminRoleMapper.insert(role);
	}
	
	public boolean roleCodeExisted(String roleCode){
		AdminRole ar=adminRoleMapper.getAdminRoleByRoleCode(roleCode);
		return ar==null?false:true;
	}
	
	public AdminRole getAdminRoleByRoleCode(String roleCode){
		return adminRoleMapper.getAdminRoleByRoleCode(roleCode);
	}
	
	public void updateRoleNameByRoleCode(String roleCode,String roleName){
		AdminRole role=new AdminRole();
		role.setRolename(roleName);
		role.setRolecode(roleCode);
		adminRoleMapper.updateByPrimaryKey(role);
	}
	
	public List<Integer> getAllResourceIdByRoleCode(String roleCode){
		return adminRoleResourceMapper.getAllResourceId(roleCode);
	}
	
}
