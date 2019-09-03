package com.dao;

import com.pojo.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);
}