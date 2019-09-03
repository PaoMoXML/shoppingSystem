package com.dao;

import com.pojo.Bann;

public interface BannMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bann record);

    int insertSelective(Bann record);

    Bann selectByPrimaryKey(Integer bId);

    int updateByPrimaryKeySelective(Bann record);

    int updateByPrimaryKey(Bann record);
}