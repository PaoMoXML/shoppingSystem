package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Bann;

public interface BannMapper {
    int deleteByPrimaryKey(Integer bId);

    int insert(Bann record);

    /**
     *<p>Title: insertSelective</p>
     *<p>Description: 新增公告</p>
     * @param record
     * @return
     */
    int insertSelective(Bann record);

    Bann selectByPrimaryKey(Integer bId);

    /**
     *<p>Title: updateByPrimaryKeySelective</p>
     *<p>Description:条件更新-》用于删除 </p>
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Bann record);

    int updateByPrimaryKey(Bann record);
    
    /**
     *<p>Title: selectBann</p>
     *<p>Description: 条件查询公告</p>
     * @param record
     * @return
     */
    List<Bann> selectBann(Bann record);
    
    /**
     *<p>Title: selectLikeBann</p>
     *<p>Description: 模糊查询公告</p>
     * @param record
     * @return
     */
    List<Bann> selectLikeBann(Bann record);
    
    /**
     *<p>Title: getTotal</p>
     *<p>Description: 查询数量</p>
     * @param record
     * @return
     */
    int getTotal(Bann record);
    
    /**
     *<p>Title: getLikeTotal</p>
     *<p>Description: 模糊查询数量</p>
     * @param reocrd
     * @return
     */
    int getLikeTotal(Bann reocrd);
    
    /**
     *<p>Title: delList</p>
     *<p>Description: 批量删除（更新）</p>
     * @param id_arr
     * @return
     */
    Integer delList(int[] id_arr);
    
    /**
     *<p>Title: restoreList</p>
     *<p>Description: 批量恢复为 1：未发布 3：已发布（更新）</p>
     * @param id_arr
     * @param bStatus
     * @return
     */
    Integer restoreList(@Param("array")int[] id_arr,@Param("bStatus")int bStatus);
    
    /**
     *<p>Title: statistics</p>
     *<p>Description:统计公告日期 </p>
     * @return
     */
    List<Bann> statistics();
    
}