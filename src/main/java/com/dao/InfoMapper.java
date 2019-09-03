package com.dao;

import com.pojo.Info;

public interface InfoMapper {
    int deleteByPrimaryKey(Integer iId);

    int insert(Info record);

    int insertSelective(Info record);

    Info selectByPrimaryKey(Integer iId);

    int updateByPrimaryKeySelective(Info record);

    int updateByPrimaryKey(Info record);
}