/**
 * @author XuMenglin
 * @date 2019年9月26日
 *
 */
package com.service;

import java.util.List;

import com.pojo.Focus;

/**
 * <p>Title: FocusService</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月26日
 */
public interface FocusService {
	
    /**
     *<p>Title: focusList</p>
     *<p>Description:显示关注列表 </p>
     * @param record
     * @return
     */
    List<Focus> focusList(Focus record);
    
    /**
     *<p>Title: insertSelective</p>
     *<p>Description: 关注商品</p>
     * @param record
     * @return
     */
    int insertSelective(Focus record);



}
