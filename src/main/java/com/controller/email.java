/**
 * @author XuMenglin
 * @date 2019年9月10日
 *
 */
package com.controller;

import java.util.List;

import cn.hutool.core.lang.Console;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.extra.mail.MailUtil;
import cn.hutool.http.HttpUtil;

/**
 * <p>Title: email</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月10日
 */
public class email {
	
	public static void main(String[] args) {
		MailUtil.send("917897434@qq.com", "测试", "邮件来自Hutool测试", false);
		
//		//请求列表页
//		String listContent = HttpUtil.get("https://www.oschina.net/action/ajax/get_more_news_list?newsType=&p=2");
//		//使用正则获取所有标题
//		List<String> titles = ReUtil.findAll("<span class=\"text-ellipsis\">(.*?)</span>", listContent, 1);
//		for (String title : titles) {
//		    //打印标题
//		    Console.log(title);
//		}
//
//		System.out.println(RandomUtil.randomUUID());
		
		//参数1为终端ID
		//参数2为数据中心ID
//		Snowflake snowflake = IdUtil.createSnowflake(1, 1);
//		long id = snowflake.nextId();
//		
//		System.out.println(id);

//		Snowflake snowflake2 = IdUtil.createSnowflake(12, 24);
//		System.out.println(snowflake2.nextIdStr());
	}

}
