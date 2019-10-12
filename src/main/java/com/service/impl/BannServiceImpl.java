/**
 * @author XuMenglin
 * @date 2019年9月4日
 *
 */
package com.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.BannMapper;
import com.pojo.Bann;
import com.service.BannService;

/**
 * <p>Title: BannServiceImpl</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月4日
 */
@Service("BannService")
public class BannServiceImpl implements BannService{

	@Autowired
	BannMapper bannMapper;
	/**
	 * <p>Title: selectBann</p>
	 * <p>Description:条件查询公告 </p>
	 * @param record
	 * @return
	 * @see com.service.BannService#selectBann(com.pojo.Bann)
	 */
	@Override
	public List<Bann> selectBann(Bann record) {
		return bannMapper.selectBann(record);
	}
	/**
	 * <p>Title: updateByPrimaryKeySelective</p>
	 * <p>Description:条件删除0-》用于删除<p>
	 * @param record
	 * @return
	 * @see com.service.BannService#updateByPrimaryKeySelective(com.pojo.Bann)
	 */
	@Override
	public int updateByPrimaryKeySelective(Bann record) {
		return bannMapper.updateByPrimaryKeySelective(record);
	}
	/**
	 * <p>Title: insertSelective</p>
	 * <p>Description: 新增公告</p>
	 * @param record
	 * @return
	 * @see com.service.BannService#insertSelective(com.pojo.Bann)
	 */
	@Override
	public int insertSelective(Bann record) {
		return bannMapper.insertSelective(record);
	}

	
	/**
	 * <p>Title: getTotal</p>
	 * <p>Description: 查询数量</p>
	 * @param record
	 * @return
	 * @see com.service.BannService#getTotal(com.pojo.Bann)
	 */
	@Override
	public int getTotal(Bann record) {
		return bannMapper.getTotal(record);
	}
	/**
	 * <p>Title: selectLikeBann</p>
	 * <p>Description: 模糊查询</p>
	 * @param record
	 * @return
	 * @see com.service.BannService#selectLikeBann(com.pojo.Bann)
	 */
	@Override
	public List<Bann> selectLikeBann(Bann record) {
		return bannMapper.selectLikeBann(record);
	}
	/**
	 * <p>Title: getLikeTotal</p>
	 * <p>Description:模糊查询数量 </p>
	 * @param reocrd
	 * @return
	 * @see com.service.BannService#getLikeTotal(com.pojo.Bann)
	 */
	@Override
	public int getLikeTotal(Bann reocrd) {
		return bannMapper.getLikeTotal(reocrd);
	}
	/**
	 * <p>Title: delList</p>
	 * <p>Description: 批量删除（更新）</p>
	 * @param id_arr
	 * @return
	 * @see com.service.BannService#delList(int[])
	 */
	@Override
	public Integer delList(int[] id_arr) {
		return bannMapper.delList(id_arr);
	}
	/**
	 * <p>Title: restoreList</p>
	 * <p>Description:批量恢复为1：未发布，3:已发布 </p>
	 * @param id_arr
	 * @param bStatus
	 * @return
	 * @see com.service.BannService#restoreList(int[], int)
	 */
	@Override
	public Integer restoreList(int[] id_arr, int bStatus) {
		return bannMapper.restoreList(id_arr, bStatus);
	}
	/**
	 * <p>Title: statistics</p>
	 * <p>Description: 统计公告日期</p>
	 * @return
	 * @see com.service.BannService#statistics()
	 */
	@Override
	public List<Bann> statistics() {
		return bannMapper.statistics();
	}
	/**
	 * <p>Title: getList</p>
	 * <p>Description: </p>
	 * @return
	 * @see com.service.BannService#getList()
	 */
	
	@Override
	public ArrayList<Bann> getBannList() {
		ArrayList<Bann> list=bannMapper.getList();
		return list;
	}

}
