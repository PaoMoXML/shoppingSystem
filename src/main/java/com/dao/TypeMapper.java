package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.pojo.Type;

public interface TypeMapper {
    int deleteByPrimaryKey(Integer tId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer tId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

	/**   
	* @Function: TypeMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月9日 下午7:45:53 
	*
	       
	*/
	ArrayList<Type> selectAll();



	/**   
	* @Function: TypeMapper.java
	* @Description: 该函数的功能描述
	* @version: v1.0.0
	* @author: 李彩清
	* @date: 2019年9月11日 上午8:03:17 
	*
	       
	*/
	int getTypeId(@Param("typeName")String getgType);
}