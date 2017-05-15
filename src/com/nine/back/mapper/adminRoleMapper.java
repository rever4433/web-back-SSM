package com.nine.back.mapper;

import com.nine.back.entity.adminRole;
import com.nine.back.entity.adminRoleExample;

public interface adminRoleMapper {
    int countByExample(adminRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(adminRole record);

    int insertSelective(adminRole record);

    adminRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(adminRole record);

    int updateByPrimaryKey(adminRole record);
}