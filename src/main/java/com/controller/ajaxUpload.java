/**
 * @author XuMenglin
 * @date 2019年9月11日
 *
 */
package com.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.UploadedImageFile;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * <p>Title: ajaxUpload</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月11日
 */
@Controller
@RequestMapping(value = "/ajaxUpload")
public class ajaxUpload {
	@RequestMapping(value = "/upload")
	@ResponseBody
	public Object add(HttpServletRequest request,@Param("img")MultipartFile multipartFile) throws IllegalStateException, IOException {//这里一定要写required=false 不然前端不传文件一定报错。到不了后台。
			String realpath="";
			//获取文件名
			String name="";
			if(multipartFile!=null){
			long size= multipartFile.getSize();
			if(size>5242880){//文件设置大小，我这里设置5M。
				System.out.println("文件有点大");
			}
			}
			name=multipartFile.getOriginalFilename();//直接返回文件的名字
			String subffix = name.substring(name.lastIndexOf(".") + 1, name.length());//我这里取得文件后缀
			String fileName=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());//文件保存进来，我给他重新命名，数据库保存有原本的名字，所以输出的时候再把他附上原本的名字就行了。
			String filepath=request.getServletContext().getRealPath("/")+"files\\";//获取项目路径到webapp
			File file=new File(filepath);
			if(!file.exists()){//目录不存在就创建
			file.mkdirs();
			}
			multipartFile.transferTo(new File(file+"\\"+fileName+"."+subffix));//保存文件
			realpath=file+"\\"+fileName+"."+subffix;
			System.out.println(realpath);
			return realpath;
			}


	public static void main(String[] args) {
//		String uuid = IdUtil.objectId();
//		System.out.println(uuid);
//		
//		Snowflake snowflake = IdUtil.createSnowflake(1, 2);
//		System.out.println(snowflake.nextIdStr());
//		System.out.println(snowflake.nextId());
//		System.out.println(snowflake.nextId());
//		System.out.println(snowflake.nextId());
		
		System.out.println(RandomUtil.randomInt(1000, 10000));
		System.out.println(RandomUtil.randomInt(1000, 10000));
		System.out.println(RandomUtil.randomInt(1000, 10000));
		System.out.println(RandomUtil.randomInt(1000, 10000));
		System.out.println(RandomUtil.randomInt(1000, 10000));
		
	}
}
