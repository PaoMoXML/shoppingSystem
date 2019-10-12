/**
  * @author XuMenglin
 * @date 2019年9月27日
 *
 */
package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Focus;
import com.service.FocusService;

/**
 * <p>Title: FocusController</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月27日
 */
@Controller
@RequestMapping(value = "/focus")
public class FocusController {
	
	@Autowired
	FocusService focusService;
	
	/**
	 *<p>Title: showFocus</p>
	 *<p>Description:显示关注列表 </p>
	 * @param record
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showFocus")
	@ResponseBody
	public List<Focus> showFocus(Focus record,HttpServletRequest request){
		request.getSession().setAttribute("userid", 1);
		int fUserid = (int) request.getSession().getAttribute("userid");
		record.setfUserid(fUserid);
		return focusService.focusList(record);
		
	}
	
	@RequestMapping(value = "/addFocus")
	@ResponseBody
	public String addFocus(Focus reocrd) {
		int a = focusService.insertSelective(reocrd);
		JSONObject json = new JSONObject();
		if(a == 1) {
			json.put("Msg", "Success");
		}else {
			json.put("Msg", "Error");
		}
		return json.toJSONString();
		
	}
	
	@RequestMapping(value = "/delFocus")
	@ResponseBody
	public String delFocus(Focus record) {
		return null;
		
	}
	
	

}
