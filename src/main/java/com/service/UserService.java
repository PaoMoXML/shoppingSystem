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
	* @Function: UserService.java
	* @Description: 登录
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月29日 下午3:25:49 
	*
	       
	*/
	User login(User u);

	/**   
	* @Function: UserService.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年10月8日 上午8:06:42 
	*
	       
	*/
	void register(User user);


}
