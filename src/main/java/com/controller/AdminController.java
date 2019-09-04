/**
 * @author XuMenglin
 * @date 2019年9月3日
 *
 */
package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Admin;
import com.service.AdminService;

/**
 * <p>Title: AdminController</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月3日
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(Admin record) {
		Admin a = adminService.login(record);
		if(a != null) {
			System.out.println("账号正确");
		}
		JSONObject json = new JSONObject();
		json.put("key", a);
		return json.toJSONString();
	}

}
