package com.dao;

import java.util.List;

import com.pojo.Focus;

public interface FocusMapper {
    int deleteByPrimaryKey(Integer fId);

    int insert(Focus record);

    /**
     *<p>Title: insertSelective</p>
     *<p>Description:关注商品 </p>
     * @param record
     * @return
     */
    int insertSelective(Focus record);

    Focus selectByPrimaryKey(Integer fId);

    int updateByPrimaryKeySelective(Focus record);

    int updateByPrimaryKey(Focus record);
    
    /**
     *<p>Title: focusList</p>
     *<p>Description: 关注列表</p>
     * @param record
     * @return
     */
    List<Focus> focusList(Focus record);
}