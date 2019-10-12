package com.dao;

import java.util.List;

import com.pojo.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    /**
     *<p>Title: userList</p>
     *<p>Description: 查询用户列表</p>
     * @param record
     * @return
     */
    List<User> userList (User record);

	/**   
	* @Function: UserMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月29日 下午3:27:11 
	*
	       
	*/
	User selectUser(User u);
}