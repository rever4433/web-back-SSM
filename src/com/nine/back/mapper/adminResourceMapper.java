package com.nine.back.mapper;

import com.nine.back.entity.adminResource;

public interface adminResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(adminResource record);

    int insertSelective(adminResource record);

    adminResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(adminResource record);

    int updateByPrimaryKey(adminResource record);
}