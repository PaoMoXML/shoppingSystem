package com.dao;

import com.pojo.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(Good record);

    int insertSelective(Good record);

    Good selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);
}