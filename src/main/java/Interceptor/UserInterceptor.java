/**   
 * Copyright © 2019 eSunny Info. Tech Ltd. All rights reserved.
 * 
 * 功能描述：
 * @Package: Interceptor 
 * @author: 李彩清   
 * @date: 2019年9月23日 上午11:43:39 
 */
package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: UserInterceptor.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月23日 上午11:43:39 
*/
public class UserInterceptor implements HandlerInterceptor{
    
	/** 
	* @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)  
	* @Function: UserInterceptor.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月23日 上午11:44:26 
	            
	*/
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object name = request.getSession().getAttribute("name");
		if(name == null || "".equals(name)) {
			request.getRequestDispatcher("/shop/login.jsp").forward(request, response);	
			return false;
		}
		return true;
	}

	/** 
	* @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)  
	* @Function: UserInterceptor.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月23日 上午11:44:26 
	            
	*/
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	/** 
	* @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)  
	* @Function: UserInterceptor.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月23日 上午11:44:26 
	            
	*/
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
