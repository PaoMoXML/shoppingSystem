/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.controller 
 * @author: 李彩清   
 * @date: 2019年9月9日 下午7:37:53 
 */
package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pojo.Type;
import com.service.TypeService;

/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: TypeController.java
* @Description: 类型相关功能
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月9日 下午7:37:53 
*/
@Controller
@RequestMapping("/type")
public class TypeController {
      @Autowired
      TypeService typeservice;
      
      
      @RequestMapping("/typeList")
      public @ResponseBody ArrayList<Type> xialacaidanPOST(){

          ArrayList<Type> type =typeservice.queryType();

          return type;
      }
}
