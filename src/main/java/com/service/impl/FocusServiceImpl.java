/**
 * @author XuMenglin
 * @date 2019年9月26日
 *
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.FocusMapper;
import com.pojo.Focus;
import com.service.FocusService;

/**
 * <p>Title: FocusServiceImpl</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月26日
 */
@Service("FocusService")
public class FocusServiceImpl implements FocusService {
	@Autowired
	FocusMapper focusMapper;

	/**
	 * <p>Title: focusList</p>
	 * <p>Description: 关注列表</p>
	 * @param record
	 * @return
	 * @see com.service.FocusService#focusList(com.pojo.Focus)
	 */
	@Override
	public List<Focus> focusList(Focus record) {
		return focusMapper.focusList(record);
	}

	/**
	 * <p>Title: insertSelective</p>
	 * <p>Description:关注商品 </p>
	 * @param record
	 * @return
	 * @see com.service.FocusService#insertSelective(com.pojo.Focus)
	 */
	@Override
	public int insertSelective(Focus record) {
		return focusMapper.insertSelective(record);
	}
	
	
	
	

}
