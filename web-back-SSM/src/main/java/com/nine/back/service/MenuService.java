package com.nine.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nine.back.entity.AdminResource;
import com.nine.back.entity.AdminRoleResource;
import com.nine.back.mapper.AdminResourceMapper;
import com.nine.back.mapper.AdminRoleResourceMapper;

@Service
public class MenuService {

	@Autowired
	private AdminRoleResourceMapper adminRoleResourceMapper;

	@Autowired
	private AdminResourceMapper adminResourceMapper;

	public List<AdminResource> getAllMenuByRoleCode(String roleCode) {
		return adminResourceMapper.getAllAdminResourceByRoleCode(roleCode);
	}

	public int addAdminResource(AdminResource ar) {
		return adminResourceMapper.insert(ar);
	}
	
	public int addAdminRoleResource(AdminRoleResource arr){
		return adminRoleResourceMapper.insert(arr);
	}

	public List<Integer> getAllResourceIdByRoleCode(String roleCode) {
		return adminRoleResourceMapper.getAllResourceId(roleCode);
	}

	public AdminResource getAdminResourceByResourceId(Integer resourceId) {
		return adminResourceMapper.getAdminResourceByResourceID(resourceId);
	}

	public AdminRoleResource getAdminRoleResourceByResourceId(Integer resourceId) {
		return adminRoleResourceMapper.selectByPrimaryKey(resourceId);
	}

	public Integer getMaxResourceId() {
		return adminRoleResourceMapper.getMaxResourceId();
	}
	
	public String getRoleCodeByResourceId(Integer rid) {
		return adminRoleResourceMapper.getRoleCode(rid);
	}
	
	public AdminResource getAdminResourceByName(String name){
		List<AdminResource> list=adminResourceMapper.getAdminResourceByName(name);
		return list.get(0);
	}
	
	public int deleteMenu(String name){
		AdminResource ar=getAdminResourceByName(name);
		Integer rid=ar.getRid();
		if(ar.getPid().equals(0)&&ar.getLeaf().equals(0)){
			return adminResourceMapper.deleteAllChildMenu(rid);
		}else return adminResourceMapper.deleteChildMenu(rid);
	}
	
	public int closeMenu(String name){
		AdminResource ar=getAdminResourceByName(name);
		Integer rid=ar.getRid();
		if(ar.getPid().equals(0)&&ar.getLeaf().equals(0)){
			return adminResourceMapper.closeAllchildMenu(rid,rid);
		}else return adminResourceMapper.closeChildMenu(rid);
	}
}
