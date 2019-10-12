/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.service 
 * @author: 李彩清   
 * @date: 2019年9月9日 下午7:39:29 
 */
package com.service;

import java.util.ArrayList;

import com.pojo.Type;

/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: TypeService.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月9日 下午7:39:29 
*/
public interface TypeService {

	/**   
	* @Function: TypeService.java
	* @Description: 查询所有类
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月9日 下午7:41:51 
	*
	       
	*/
	public ArrayList<Type> queryType();

	

	/**   
	* @Function: TypeService.java
	* @Description: 获取类型的对应id
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月11日 上午8:01:27 
	*
	       
	*/
	public int getTypeId(String getgType);

}
