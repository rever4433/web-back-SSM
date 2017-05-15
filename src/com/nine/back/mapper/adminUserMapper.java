package com.nine.back.mapper;

import com.nine.back.entity.adminUser;

public interface adminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(adminUser record);

    int insertSelective(adminUser record);

    adminUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(adminUser record);

    int updateByPrimaryKey(adminUser record);
}