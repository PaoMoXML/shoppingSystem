/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.User;
import com.service.UserService;

/**
 * <p>Title: UserServiceController</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
@Controller
@RequestMapping(value = "/user")
public class UserServiceController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/userList")
	@ResponseBody
	public List<User> userList(User record){
		List<User> list = userService.userList(record);
		return list;
	}

}
