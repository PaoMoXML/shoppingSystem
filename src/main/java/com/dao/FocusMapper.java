package com.dao;

import com.pojo.Focus;

public interface FocusMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Focus record);

    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
}