/**
 * @author 李彩清
 */
package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.GoodMapper;

import com.pojo.Good;
import com.service.GoodsService;


/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: GoodsServiceImpl.java
* @Description: 商品相关service
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月6日 上午8:25:08 
*/
@Service
public class GoodsServiceImpl implements GoodsService {
	
	@Autowired
	GoodMapper goodMapper;

	
	/** 
	* @see com.service.GoodsService#goodList(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 带条件返回商品列表
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:26:04 
	*/
	@Override
	public List<Good> goodList(Good good) {
		System.out.println(good);
		List<Good> list=goodMapper.selectList(good);
		return list;
	}

	
	/** 
	* @see com.service.GoodsService#update(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 更新商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:33:33 
	            
	*/
	@Override
	public void update(Good good) {
		
		goodMapper.updateByPrimaryKey(good);
		
	}

	/** 
	* @see com.service.GoodsService#delete(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 假刪除商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:33:49 
	            
	*/
	@Override
	public void delete(Good good) {
		goodMapper.deleteGood(good);		
	}

	/** 
	* @see com.service.GoodsService#add(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 插入商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:34:03 
	            
	*/
	@Override
	public void add(Good good,int goodId) {
		goodMapper.insert(good,goodId);
		
		
	}

	/** 
	* @see com.service.GoodsService#searchByName(java.lang.String)  
	* @Function: GoodsServiceImpl.java
	* @Description: 按照名字模糊查找商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:34:21 
	            
	*/
	@Override
	public Good searchByName(String gName) {
		return goodMapper.selectByName(gName);
	}

	/** 
	* @see com.service.GoodsService#searchById(java.lang.Integer)  
	* @Function: GoodsServiceImpl.java
	* @Description: 根據id查找商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:34:48 
	            
	*/
	@Override
	public Good searchById(Integer getgId) {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	* @see com.service.GoodsService#updateStatus(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 增加商品，實質上是修改商品的狀態
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:35:08 
	            
	*/
	@Override
	public void updateStatus(Good g) {
		goodMapper.updateStatus(g);
		
	}

	/** 
	* @see com.service.GoodsService#getTotal(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 查询正常状态的商品条数
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:35:34 
	            
	*/
	@Override
	public Integer getTotal(Good good) {
		return goodMapper.getTotal(good);
	}

	/** 
	* @see com.service.GoodsService#getGoodListPage(com.pojo.Good, int, int)  
	* @Function: GoodsServiceImpl.java
	* @Description: 后台分页查询
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 上午8:36:02 
	            
	*/
	@Override
	public List<Good> getGoodListPage(Good good, int limit, int offset) {
		return goodMapper.getGoodListPage(good.getgId(),good.getgName(),good.getgType(),limit,offset);
	}


	/** 
	* @see com.service.GoodsService#getDustbinTotal(com.pojo.Good)  
	* @Function: GoodsServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:49:47 
	            
	*/
	@Override
	public Integer getDustbinTotal(Good good) {
		return goodMapper.getDustbinTotal(good);
	}


	/** 
	* @see com.service.GoodsService#getDustbinGoodListPage(com.pojo.Good, int, int)  
	* @Function: GoodsServiceImpl.java
	* @Description: 查询商品垃圾车数据
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午6:49:47 
	            
	*/
	@Override
	public List<Good> getDustbinGoodListPage(Good good, int limit, int offset) {
		return goodMapper.getDustbinGoodListPage(good.getgId(),good.getgName(),good.getgType(),limit,offset);
	}


	/** 
	* @see com.service.GoodsService#deleteDustbin(int)  
	* @Function: GoodsServiceImpl.java
	* @Description: 彻底删除
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午7:40:08 
	            
	*/
	@Override
	public void deleteDustbin(int gId) {
		goodMapper.deleteByPrimaryKey(gId);// TODO Auto-generated method stub
		
	}


	/** 
	* @see com.service.GoodsService#renewDustbin(int)  
	* @Function: GoodsServiceImpl.java
	* @Description: 恢复商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月6日 下午7:57:04 
	            
	*/
	@Override
	public void renewDustbin(int gId) {
		Good good=new Good();
		good.setgId(gId);
		goodMapper.updateStatus(good);
		
	}


	/** 
	* @see com.service.GoodsService#updateType(int, int)  
	* @Function: GoodsServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月11日 上午9:04:16 
	            
	*/
	@Override
	public void updateType( int goodid,int goodtype) {
		goodMapper.updateType(goodid,goodtype);
		
	}


	/** 
	* @see com.service.GoodsService#changeImg(int, java.lang.String)  
	* @Function: GoodsServiceImpl.java
	* @Description: 该函数的功能描述
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月17日 上午11:10:58 
	            
	*/
	@Override
	public void changeImg(int gId, String fileName) {
		goodMapper.changeImg(gId,fileName);// TODO Auto-generated method stub
		
	}


	/** 
	* @see com.service.GoodsService#getList()  
	* @Function: GoodsServiceImpl.java
	* @Description: 获得所有的商品
	
	*
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月21日 下午3:56:09 
	            
	*/
	@Override
	public List<Good> getList() {
		
		return goodMapper.getList();
	}



	

}
