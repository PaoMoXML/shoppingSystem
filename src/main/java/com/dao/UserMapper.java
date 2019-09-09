package com.dao;

import java.util.List;

import com.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    /**
     *<p>Title: updateByPrimaryKeySelective</p>
     *<p>Description: 删除用户（修改用户状态为：2）</p>
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     *<p>Title: userList</p>
     *<p>Description: 查询用户列表</p>
     * @param record
     * @return
     */
    List<User> userList(User record);
    
}