/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.service;

import java.util.List;

import com.pojo.Bann;

/**
 * <p>Title: BannService</p>
 * <p>Description: 公告操作接口</p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
public interface BannService {
	
	/**
	 *<p>Title: selectBann</p>
	 *<p>Description:查询公告 </p>
	 * @param record
	 * @return
	 */
	List<Bann> selectBann(Bann record);
	
	/**
	 *<p>Title: selectLikeBann</p>
	 *<p>Description:模糊查询 </p>
	 * @param record
	 * @return
	 */
	List<Bann> selectLikeBann(Bann record);
	
	
	/**
	 *<p>Title: updateByPrimaryKeySelective</p>
	 *<p>Description:条件更新-》用于删除 </p>
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(Bann record);
	
	/**
	 *<p>Title: insertSelective</p>
	 *<p>Description: 新增公告</p>
	 * @param record
	 * @return
	 */
	int insertSelective(Bann record);
	
	/**
	 *<p>Title: getTotal</p>
	 *<p>Description:查询数量 </p>
	 * @param record
	 * @return
	 */
	int getTotal(Bann record);
	
	/**
	 *<p>Title: getLikeTotal</p>
	 *<p>Description:模糊查询数量 </p>
	 * @param reocrd
	 * @return
	 */
	int getLikeTotal(Bann reocrd);
	
	/**
	 *<p>Title: delList</p>
	 *<p>Description:批量删除（更新） </p>
	 * @param id_arr
	 * @return
	 */
	Integer delList(int[] id_arr);
	
	 /**
	 *<p>Title: restoreList</p>
	 *<p>Description:批量恢复为1：未发布，3：已发布（更新） </p>
	 * @param id_arr
	 * @param bStatus
	 * @return
	 */
	Integer restoreList(int[] id_arr,int bStatus);
	
	
	/**
	 *<p>Title: statistics</p>
	 *<p>Description:统计公告日期 </p>
	 * @return
	 */
	List<Bann> statistics();
}
