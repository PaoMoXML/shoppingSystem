/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.pojo.Bann;
import com.service.BannService;
import com.util.PageHelper;

/**
 * <p>Title: BannController</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
@Controller
@RequestMapping(value = "/bann")
public class BannController {
	@Autowired
	BannService bannService;
	//1为正常状态
	int x = 1;
	//2为删除状态 或者表示更新/删除成功
	int y = 2;
	
	/**
	 *<p>Title: showBann</p>
	 *<p>Description:查询公告 </p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/showBann")
	@ResponseBody
	public PageHelper<Bann> showBann(Bann record,HttpServletRequest request) {
		PageHelper<Bann> pageHelper = new PageHelper<Bann>();
		Integer total = bannService.getTotal(record);
		System.out.println("total:"+total);
		pageHelper.setTotal(total);
		List<Bann> list = bannService.selectBann(record);
		pageHelper.setRows(list);
		return pageHelper;
	}
	
	/**
	 *<p>Title: showLikeBann</p>
	 *<p>Description:模糊查询公告</p>
	 * @param record
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/showLikeBann")
	@ResponseBody
	public PageHelper<Bann> showLikeBann(Bann record,HttpServletRequest request) {
		PageHelper<Bann> pageHelper = new PageHelper<Bann>();
		Integer total = bannService.getLikeTotal(record);
		System.out.println("total:"+total);
		pageHelper.setTotal(total);
		List<Bann> list = bannService.selectLikeBann(record);
		pageHelper.setRows(list);
		return pageHelper;
	}
	
	/**
	 *<p>Title: del</p>
	 *<p>Description:删除公告 </p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/del")
	@ResponseBody
	public String del(@RequestBody Bann record) {
		JSONObject json = new JSONObject();
		int a = bannService.updateByPrimaryKeySelective(record);
		if(a == x) {
			json.put("key", "success");
		}else {
			json.put("key", "error");
		}
		return json.toJSONString();
	}
	
	/**
	 *<p>Title: add</p>
	 *<p>Description: 添加公告</p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/add")
	@ResponseBody
	public String add(@RequestBody Bann record) {

		SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
		String datetime = tempDate.format(new java.util.Date()); 
		record.setbData(datetime);
		JSONObject json = new JSONObject();
		int a = bannService.insertSelective(record);
		if(a == x) {
			json.put("key", "success");
		}else {
			json.put("key", "error");
		}
		return json.toJSONString();
	}
	
	/**
	 *<p>Title: delList</p>
	 *<p>Description:批量删除 </p>
	 * @param bId
	 * @return
	 */
	@RequestMapping(value = "/delList")
	@ResponseBody
	public String delList(int[] bId) {
		JSONObject json = new JSONObject();
		if(bId == null) {
			json.put("key", "更新数组为空");
		}else {
			bannService.delList(bId);
			json.put("key", "更新！");
		}
		return json.toJSONString();
	}
	
	@RequestMapping(value = "/restoreList")
	@ResponseBody
	public String restoreList(int[] bId,int bStatus) {
		JSONObject json = new JSONObject();
		if(bId == null) {
			json.put("key", "更新数组为空");
		}else {
			bannService.restoreList(bId, bStatus);
			json.put("key", "更新！");
		}
		return json.toJSONString();
	}
	
	
	
	
	
	/**
	 *<p>Title: changeBann</p>
	 *<p>Description: 修改公告</p>
	 * @param record
	 * @return
	 */
	@RequestMapping(value = "/changeBann")
	@ResponseBody
	public String changeBann(@RequestBody Bann record) {
		JSONObject json = new JSONObject();
		int a = bannService.updateByPrimaryKeySelective(record);
		if(a == 1) {
			json.put("key", "success");
		}else {
			json.put("key", "error");
		}
		return json.toJSONString();
	}
	

}
