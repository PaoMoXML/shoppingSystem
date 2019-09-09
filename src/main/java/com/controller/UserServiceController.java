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

import com.alibaba.fastjson.JSONObject;
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
	
	//1为正常状态
	int x = 1;
	//2为删除状态 或者表示更新/删除成功
	int y = 2;
	
	/**
	 *<p>Title: userList</p>
	 *<p>Description: 用户信息查询</p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/userList")
	@ResponseBody
	public List<User> userList(User record){
		List<User> list = userService.userList(record);
		return list;
	}
	
	/**
	 *<p>Title: del</p>
	 *<p>Description:删除用户（修改用户的状态为：2） </p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public String del(User record) {
		//设置用户状态为：2
		record.setuStatus(y);
		int a = userService.updateByPrimaryKeySelective(record);
		JSONObject json = new JSONObject();
		if(a == x) {
			json.put("key", 1);
		}else {
			json.put("key", "error");
		}
		return json.toJSONString();
	}

}
