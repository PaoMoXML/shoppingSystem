/**
 * @author XuMenglin
 * @date 2019年9月3日
 *
 */
package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.AdminMapper;
import com.pojo.Admin;
import com.service.AdminService;

/**
 * <p>Title: AdminServiceImpl</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月3日
 */
@Service("AdminService")
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminMapper adminMapper;

	/**
	 * <p>Title: login</p>
	 * <p>Description: 管理员登录</p>
	 * @param record
	 * @return
	 * @see com.service.AdminService#login(com.pojo.Admin)
	 */
	@Override
	public Admin login(Admin record) {
		return adminMapper.login(record);
	}
	
	

}
