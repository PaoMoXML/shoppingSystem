/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.service.impl 
 * @author: 李彩清   
 * @date: 2019年9月9日 下午7:43:25 
 */
package com.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TypeMapper;
import com.pojo.Type;
import com.service.TypeService;

/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: TypeServiceImpl.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月9日 下午7:43:25 
*/
@Service
public class TypeServiceImpl implements TypeService {
      @Autowired
      TypeMapper typeMapper;
	/** 
	* @see com.service.TypeService#queryType()  
	* @Function: TypeServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月9日 下午7:43:25 
	            
	*/
	@Override
	public ArrayList<Type> queryType() {
		ArrayList<Type> list=new ArrayList<Type>();
		list=typeMapper.selectAll();
		return list;
	}
	/** 
	* @see com.service.TypeService#getTypeId(java.lang.String)  
	* @Function: TypeServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月11日 上午8:02:29 
	            
	*/
	@Override
	public int getTypeId(String getgType) {
		return typeMapper.getTypeId(getgType);
	}
	

}
