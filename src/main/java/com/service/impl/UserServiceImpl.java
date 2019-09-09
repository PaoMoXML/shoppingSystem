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
	 * <p>Title: updateByPrimaryKeySelective</p>
	 * <p>Description: 删除用户（修改用户的状态为2）</p>
	 * @param record
	 * @return
	 * @see com.service.UserService#updateByPrimaryKeySelective(com.pojo.User)
	 */
	@Override
	public int updateByPrimaryKeySelective(User record) {
		return userMapper.updateByPrimaryKeySelective(record);
	}

}
