/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.service;

import java.util.List;

import com.pojo.User;

/**
 * <p>Title: UserService</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
public interface UserService {
	
    /**
     *<p>Title: userList</p>
     *<p>Description: 查询用户列表</p>
     * @param record
     * @return
     */
    List<User> userList (User record);
    
    /**
     *<p>Title: updateByPrimaryKeySelective</p>
     *<p>Description: 删除用户（修改用户状态为2）</p>
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(User record);



}
