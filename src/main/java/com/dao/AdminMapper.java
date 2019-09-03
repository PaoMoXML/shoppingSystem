package com.dao;

import com.pojo.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer aId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer aId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    /**
     *<p>Title: login</p>
     *<p>Description:管理员登录 </p>
     * @param record
     * @return
     */
    Admin login (Admin record);
}