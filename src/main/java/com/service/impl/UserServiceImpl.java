/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserMapper;
import com.pojo.User;
import com.service.UserService;

/**
 * <p>Title: UserServiceImpl</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
@Service("UserService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserMapper userMapper;

	/**
	 * <p>Title: userList</p>
	 * <p>Description: 查询用户列表</p>
	 * @param record
	 * @return
	 * @see com.service.UserService#userList(com.pojo.User)
	 */
	@Override
	public List<User> userList(User record) {
		return userMapper.userList(record);
	}

	/** 
	* @see com.service.UserService#login(com.pojo.User)  
	* @Function: UserServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月29日 下午3:26:10 
	            
	*/
	@Override
	public User login(User u) {
		// TODO Auto-generated method stub
		return userMapper.selectUser(u);
	}

	/** 
	* @see com.service.UserService#register(com.pojo.User)  
	* @Function: UserServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年10月8日 上午8:06:55 
	            
	*/
	@Override
	public void register(User user) {
		userMapper.insert(user);
		
	}

}
