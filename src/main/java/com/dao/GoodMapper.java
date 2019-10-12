package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.Good;

public interface GoodMapper {
    int deleteByPrimaryKey(Integer gId);

    int insert(@Param("good")Good good, @Param("goodId")int goodId);

    int insertSelective(Good record);
    
    Good selectByPrimaryKey(Integer gId);

    int updateByPrimaryKeySelective(Good record);

    int updateByPrimaryKey(Good record);

	/**
	 * @param good
	 * @return
	 */
	List<Good> selectList(Good good);

	/**
	 * @param good
	 */
	void deleteGood(Good good);

	/**
	 * @param gName
	 * @return
	 */
	Good selectByName(String gName);

	/**
	 * @param g
	 */
	void updateStatus(Good g);

	/**
	 * @param good 
	 * @return
	 */
	Integer getTotal(Good good);

	/**
	 * @param getgId
	 * @param getgName
	 * @param getgType
	 * @param limit
	 * @param offset
	 * @return
	 */
	List<Good> getGoodListPage(@Param("gId")Integer gId,@Param("gName")String gName, @Param("gType")String gType, @Param("limit")int limit, @Param("offset")int offset);

	/**   
	* @Function: GoodMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:53:29 
	*
	       
	*/
	Integer getDustbinTotal(Good good);

	/**   
	* @Function: GoodMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:53:38 
	*
	       
	*/
	List<Good> getDustbinGoodListPage(@Param("gId")Integer gId,@Param("gName")String gName, @Param("gType")String gType, @Param("limit")int limit, @Param("offset")int offset);


	/**   
	* @Function: GoodMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月11日 上午9:06:02 
	*
	       
	*/
	void updateType(@Param("goodid")int goodid, @Param("goodtype")int goodtype);

	/**   
	* @Function: GoodMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月17日 上午11:12:13 
	*
	       
	*/
	void changeImg(@Param("gId")int gId, @Param("fileName")String fileName);

	/**   
	* @Function: GoodMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月21日 下午3:56:57 
	*
	       
	*/
	List getList();

	
	



	

}