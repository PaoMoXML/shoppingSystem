package com.dao;

import com.pojo.Detail;

public interface DetailMapper {
    int insert(Detail record);

    int insertSelective(Detail record);
}