/**
 * @author 李彩清
 */
package com.service;

import java.util.List;

import com.pojo.Good;

/**
 * @author 李彩清
 *
 */
public interface GoodsService {

	/**   
	* @Function: GoodsService.java
	* @Description: 查询商品列表，全部
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:36:54 
	*
	       
	*/
	List<Good> goodList(Good good);

	
	/**   
	* @Function: GoodsService.java
	* @Description: 修改商品
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:37:23 
	*
	       
	*/
	void update(Good good);

	
	/**   
	* @Function: GoodsService.java
	* @Description: 删除商品
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:37:41 
	*
	       
	*/
	void delete(Good good);

	
	/**   
	* @Function: GoodsService.java
	* @Description: 插入商品
	* @version: v1.0.0
	* @author: 李彩清
	 * @param goodtype 
	* @date: 2019年9月6日 上午8:38:04 
	*
	       
	*/
	void add(Good good, int goodtype);

	
	/**   
	* @Function: GoodsService.java
	* @Description: 根据id查找商品
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:38:32 
	*
	       
	*/
	Good searchById(Integer getgId);

	
	/**   
	* @Function: GoodsService.java
	* @Description:根据商品名称模糊查询商品
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:38:48 
	*
	       
	*/
	Good searchByName(String gName);

	
	/**   
	* @Function: GoodsService.java
	* @Description: 增加商品，修改商品状态为正常状态
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:39:34 
	*
	       
	*/
	void updateStatus(Good g);

/**
	 * @param good
	 * @return
	 */
	/**   
	* @Function: GoodsService.java
	* @Description: 查询为正常状态的商品数量
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:40:05 
	*
	       
	*/
	Integer getTotal(Good good);

	/**   
	* @Function: GoodsService.java
	* @Description: 后台分页
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:40:35 
	*
	       
	*/
	List<Good> getGoodListPage(Good good, int limit, int offset);


	/**   
	* @Function: GoodsService.java
	* @Description: 查询商品垃圾车总条数
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:47:09 
	*
	       
	*/
	Integer getDustbinTotal(Good good);


	/**   
	* @Function: GoodsService.java
	* @Description: 
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:47:43 
	*
	       
	*/
	List<Good> getDustbinGoodListPage(Good good, int limit, int offset);


	/**   
	* @Function: GoodsService.java
	* @Description: 彻底删除数据
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午7:39:46 
	*
	       
	*/
	void deleteDustbin(int gId);


	/**   
	* @Function: GoodsService.java
	* @Description:恢复商品
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午7:56:41 
	*
	       
	*/
	void renewDustbin(int gId);


	/**   
	* @Function: GoodsService.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	 * @param goodid 
	* @date: 2019年9月11日 上午9:00:55 
	*
	       
	*/
	void updateType(int goodtype, int goodid);


	/**   
	* @Function: GoodsService.java
	* @Description: 修改商品圖片
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月17日 上午11:10:35 
	*
	       
	*/
	void changeImg(int gId, String fileName);


	/**   
	* @Function: GoodsService.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月21日 下午3:55:24 
	*
	       
	*/
	List<Good> getList();

}
