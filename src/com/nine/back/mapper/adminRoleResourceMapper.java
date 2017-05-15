package com.nine.back.mapper;

import com.nine.back.entity.adminRoleResource;

public interface adminRoleResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(adminRoleResource record);

    int insertSelective(adminRoleResource record);

    adminRoleResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(adminRoleResource record);

    int updateByPrimaryKey(adminRoleResource record);
}