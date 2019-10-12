
package com.controller;

import java.io.File;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import com.pojo.Good;
import com.pojo.GoodPage;
import com.pojo.GoodPageHelper;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;
import com.service.GoodsService;
import com.service.TypeService;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONException;

/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: GoodsController.java
* @Description: 商品相关操作
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月6日 上午8:21:19 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2019年9月6日     Administrator           v1.0.0               修改原因
*/
/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: GoodsController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月6日 下午2:56:16 
*/
/**   
* Copyright: Copyright (c) 2019 LanRu-Caifu
* 
* @ClassName: GoodsController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: 李彩清
* @date: 2019年9月6日 下午2:56:21 
*/
/**
 * Copyright: Copyright (c) 2019 LanRu-Caifu
 * 
 * @ClassName: GoodsController.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: 李彩清
 * @date: 2019年9月12日 上午8:08:16
 */
@Controller
@RequestMapping("/good")
public class GoodsController {
//	private static final String ACCESSKEY = "AKIDCYqkVVVkbm0BFISTp8WG0eCmFkEduzsg";
//	private static final String SECRETKEY = "mS1PadVCXBwtNsDQWRXcwJoI7nJmbrws";
//	private static final String BUCKETNAME = "xml2-1256638142";
//	private static final String APPID = "1256638142 ";
//	private static final String REGIONID = "ap-shanghai";
//	
	private static final String ACCESSKEY = "AKIDxLciYCGXxQfeKoEEHVUHScbLqJ1VshS0";
	private static final String SECRETKEY = "XIomY4MVQ6cs77sBICyXqnVyLTN5btGN";
	private static final String BUCKETNAME = "lcq-1300182490";
	private static final String APPID = "1300182490 ";
	private static final String REGIONID = "ap-shanghai";

	@Autowired
	GoodsService goodService;
	@Autowired
	TypeService typeService;

	/**
	 * @Function: GoodsController.java
	 * @Description: 商品列表
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 上午8:22:54
	 *
	 * 
	 */
	@RequestMapping("/goodList")
	@ResponseBody
	public GoodPageHelper<Good> goodList(Good good, int limit, int offset, int page) {
		System.out.println(good);
		GoodPageHelper<Good> pageHelper = new GoodPageHelper<Good>();
		if (good.getgType() != null && good.getgType() != "") {
			int typeId = typeService.getTypeId(good.getgType());
			String type = String.valueOf(typeId);
			good.setgType(type);
		} else {

		}
		System.out.println(good);
//		Good good=new Good();
//		good.setgId(gId);
//		good.setgName(gName);
//		good.setgType(gType);
		// 统计总记录数
		Integer total = goodService.getTotal(good);
		pageHelper.setTotal(total);
		// 查询当前页实体对象
		System.out.println(good);
		List<Good> list = goodService.getGoodListPage(good, limit, offset);
		for (int i = 0; i < list.size(); i++) {
			String key = list.get(i).getgMsg();
			String url = getUrl(key);
			list.get(i).setgMsg(url);
		}
		pageHelper.setRows(list);

		return pageHelper;
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 修改商品
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 上午8:23:23
	 *
	 * 
	 */
	@RequestMapping("/updateGood")
	@ResponseBody
	public JSONObject updateGood(Good good) {
		System.out.println("图片地址"+good.getgMsg());
		int typeId = typeService.getTypeId(good.getgType());
		String type = String.valueOf(typeId);
		good.setgType(type);
		System.out.println(good);
		// 不包括修改类型
		goodService.update(good);
		int goodtype = Integer.valueOf(good.getgType());
		goodService.updateType(good.getgId(), goodtype);
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb;
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 假删除商品
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 上午8:23:42
	 *
	 * 
	 */
	@RequestMapping("/deleteGood")
	@ResponseBody
	public String deleteGood(Good good) {
		System.out.println(good);
		goodService.delete(good);
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb.toJSONString();
	}

//	添加商品
	/**
	 * @Function: GoodsController.java
	 * @Description: 增加商品
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 上午8:24:01
	 *
	 * 
	 */

	@RequestMapping(value = "/addGood")
	@ResponseBody
	public String addGood(Good good, @RequestParam(value = "img") MultipartFile[] img, HttpServletRequest request) {

		System.out.println("文件数组长度：" + img.length);
		System.out.println(img);
		// 存取地址
		String realpath = request.getServletContext().getRealPath("upload");
		// 如果文件不存在，先建目录
		File targetDir = new File(realpath);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		String fileName = img[0].getOriginalFilename();
		File targetFile = new File(realpath, fileName); // 再在目录中建文件
		System.out.println("-------------------------------------------");
		System.out.println(targetFile);
		System.out.println(targetFile.toString());
		System.out.println("-------------------------------------------");
		// 创建文件，给文件起名字
//	        String newFileName = name + suffix;
//	        System.out.println("-------------------------------------------");
//	        System.out.println(fileName);
		// 先上传到本地文件夹中
		try {
			img[0].transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取文件URL
		String fileUrl = targetFile.toString();
		System.out.println("fileUrl:" + fileUrl);
		System.out.println(good);
		uploadFile(fileUrl);

		good.setgMsg(fileName);

		JSONObject jb = new JSONObject();
		// 查找在表中的所有数据
		Good g = goodService.searchByName(good.getgName());
		if (g != null) {
			if (g.getgStatus() == 1) {
				jb.put("flag", false);
			} else {
				g.setgStatus(1);
				goodService.updateStatus(g);
				jb.put("flag", true);
			}
		} else {
			int typeId = typeService.getTypeId(good.getgType());
			String type = String.valueOf(typeId);
			good.setgType(type);
			System.out.println(good);
			int goodtype = Integer.valueOf(good.getgType());
			goodService.add(good, goodtype);

		}
		return jb.toJSONString();
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 批量删除,假删除
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午2:57:13
	 *
	 * 
	 */
	@RequestMapping("/deleteSeveralGood")
	@ResponseBody
	public JSONObject deleteSeveralGood(int[] gId) {
		for (int i = 0; i < gId.length; i++) {
			Good good = new Good();
			good.setgId(gId[i]);
			goodService.delete(good);
		}
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb;

	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 垃圾车数据
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午7:07:43
	 *
	 * 
	 */
	@RequestMapping("/goodDustbinList")
	@ResponseBody
	public GoodPageHelper<Good> goodDustbinList(Good good, int limit, int offset, int page) {
		GoodPageHelper<Good> pageHelper = new GoodPageHelper<Good>();
		System.out.println(good);

		// 统计总记录数
		Integer total = goodService.getDustbinTotal(good);
		pageHelper.setTotal(total);
		// 查询当前页实体对象
		List<Good> list = goodService.getDustbinGoodListPage(good, limit, offset);
		pageHelper.setRows(list);

		return pageHelper;
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 跳转垃圾车页面
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午7:10:37
	 *
	 * 
	 */
	@RequestMapping("/dusbinPage")
	@ResponseBody
	public ModelAndView jumpToDustbinPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("goodDustbin");
		return mav;
	}

	@RequestMapping("/goodPage")
	@ResponseBody
	public ModelAndView jumpToGoodPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("good");
		return mav;
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 彻底删除垃圾车数据
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午7:39:23
	 *
	 * 
	 */
	@RequestMapping("/deleteDustbinGood")
	@ResponseBody
	public JSONObject deleteDustbinGood(int gId) {
		JSONObject jb = new JSONObject();
		goodService.deleteDustbin(gId);
		jb.put("flag", 1);
		return jb;

	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 恢复商品
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午7:56:11
	 *
	 * 
	 */
	@RequestMapping("/renewDustbinGood")
	@ResponseBody
	public JSONObject renewDustbinGood(int gId) {
		JSONObject jb = new JSONObject();
		goodService.renewDustbin(gId);
		jb.put("flag", 1);
		return jb;

	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 批量彻底删除
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午8:10:07
	 *
	 * 
	 */
	@RequestMapping("/deleteSeveralDustbinGood")
	@ResponseBody
	public JSONObject deleteSeveralDustbinGood(int[] gId) {
		for (int i = 0; i < gId.length; i++) {
			goodService.deleteDustbin(gId[i]);
		}
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb;

	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 批量恢复垃圾车商品
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月6日 下午8:16:25
	 *
	 * 
	 */
	@RequestMapping("/renewSeveralDustbinGood")
	@ResponseBody
	public JSONObject renewSeveralDustbinGood(int[] gId) {
		for (int i = 0; i < gId.length; i++) {
			goodService.renewDustbin(gId[i]);
		}
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb;

	}

	@RequestMapping("/updateQuantity")
	@ResponseBody
	public JSONObject updateQuantity(@RequestBody Good[] goods, Model model) {
		System.out.println(goods);

		for (int i = 0; i < goods.length; i++) {
			System.out.println(goods[i]);
			goods[i].setgType("1");
			goodService.update(goods[i]);
		}
		JSONObject jb = new JSONObject();
		jb.put("flag", 1);
		return jb;

	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 初始化对象存储桶
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月12日 上午8:08:39
	 *
	 * 
	 */
	public static COSClient getCosClient() {
		// 1 初始化用户身份信息(secretId, secretKey)
		COSCredentials cred = new BasicCOSCredentials(ACCESSKEY, SECRETKEY);
		// 2 设置bucket的区域, COS地域的简称请参照
		// https://cloud.tencent.com/document/product/436/6224
		// clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
		ClientConfig clientConfig = new ClientConfig(new Region(REGIONID));
		// 3 生成cos客户端
		COSClient cosClient = new COSClient(cred, clientConfig);
		// bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
		// String bucketName = BUCKETNAME;
		return cosClient;
	}

	/**
	 * 上传文件
	 */
	public void uploadFile(String path) {
//        File localFile = new File("E:\\software\\JavaProject\\demo\\demo20\\src\\main\\resources\\1.jpg");
		File localFile = new File(path);
		String filename = localFile.getName();
		PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, filename, localFile);

		// 设置存储类型, 默认是标准(Standard), 低频(standard_ia),一般为标准的
		putObjectRequest.setStorageClass(StorageClass.Standard);

		COSClient cc = getCosClient();
		try {
			PutObjectResult putObjectResult = cc.putObject(putObjectRequest);
			// putobjectResult会返回文件的etag
			String etag = putObjectResult.getETag();
			System.out.println(filename);

		} catch (CosServiceException e) {
			e.printStackTrace();
		} catch (CosClientException e) {
			e.printStackTrace();
		}
		cc.shutdown();

	}

	/**
	 * 删除服务上的文件
	 * 
	 * @author 李彩清
	 * @date 2017年11月20日 上午11:06:48
	 * @param filePath 路径
	 * @param fileName 文件名
	 * @return
	 */
	public boolean deleteServerFile(String filePath) {
		boolean delete_flag = false;
		File file = new File(filePath);
		if (file.exists() && file.isFile() && file.delete())
			delete_flag = true;
		else
			delete_flag = false;
		return delete_flag;
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 获取文件的URL
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @date: 2019年9月16日 上午8:06:45
	 *
	 * 
	 */
	public String getUrl(String key) {
		// 初始化永久密钥信息
		String secretId = ACCESSKEY;
		String secretKey = SECRETKEY;
		COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
		Region region = new Region("ap-shanghai");
		ClientConfig clientConfig = new ClientConfig(region);
		// 生成 cos 客户端。
		COSClient cosClient = new COSClient(cred, clientConfig);
		// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
		String bucketName = BUCKETNAME;
		GeneratePresignedUrlRequest req = new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
		// 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
		// 这里设置签名在半个小时后过期
		Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
		req.setExpiration(expirationDate);
		URL url = cosClient.generatePresignedUrl(req);
		System.out.println(url.toString());
		cosClient.shutdown();
		return url.toString();
	}

	/**
	 * @Function: GoodsController.java
	 * @Description: 修改图片
	 * @version: v1.0.0
	 * @author: 李彩清
	 * @return 
	 * @date: 2019年9月17日 上午8:50:29
	 *
	 * 
	 */

	@RequestMapping("/changeImg")
	@ResponseBody
	public JSONObject changeImg(int gId, @RequestParam(value = "changeimg") MultipartFile[] imgchange,
			HttpServletRequest request) {
		System.out.println(gId);
		System.out.println(imgchange);
		// 存取地址
		String realpath = request.getServletContext().getRealPath("upload");
		// 如果文件不存在，先建目录
		File targetDir = new File(realpath);
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		String fileName = imgchange[0].getOriginalFilename();
		File targetFile = new File(realpath, fileName); // 再在目录中建文件
		System.out.println("-------------------------------------------");
		System.out.println(targetFile);
		System.out.println(targetFile.toString());
		System.out.println("-------------------------------------------");
		// 创建文件，给文件起名字
//    		        String newFileName = name + suffix;
//    		        System.out.println("-------------------------------------------");
//    		        System.out.println(fileName);
		// 先上传到本地文件夹中
		try {
			imgchange[0].transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 获取文件URL
		String fileUrl = targetFile.toString();
		System.out.println("fileUrl:" + fileUrl);
		uploadFile(fileUrl);
		String url = getUrl(fileName);
		JSONObject jb=new JSONObject();
		jb.put("name", fileName);
		jb.put("url", url.toString());
		return jb;
		//存到數據庫
		//goodService.changeImg(gId,fileName);

	}
	
	@RequestMapping("/getGoodList")
	@ResponseBody
	public Map<Object,Object> getGoodList() {
	Map<Object, Object> hashMap = new HashMap<Object,Object>();
	List<String> name=new ArrayList<>();
	List<Integer> quantity=new ArrayList<>();
	List<Good> list=goodService.getList();
//	for(Iterator<Good> it=list.iterator();it.hasNext();){
//	    name.add(it.next().getgName());
//	    quantity.add(it.next().getgQuantity());
//	  
//	}
	for (int i = 0; i < list.size(); i++) {
		name.add(list.get(i).getgName());
		quantity.add(list.get(i).getgQuantity());
	}
	hashMap.put("name", name);
	hashMap.put("quantity",quantity );
	
	return hashMap;
	
		
		
	}
	
	@RequestMapping("/msg")
	@ResponseBody
	public String phone()  {
			// 短信应用 SDK AppID
			int appid = 1400254604; // SDK AppID 以1400开头
			// 短信应用 SDK AppKey
			String appkey = "4e6e4293373ee48f87620ecbeb7c68a1";
			// 需要发送短信的手机号码
			String[] phoneNumbers = {"17826257008"};
			// 短信模板 ID，需要在短信应用中申请
			int templateId = 420689; // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
			// 签名
			String smsSign = "徐梦麟的学习空间"; // NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
			
			int a = RandomUtil.randomInt(1000, 10000);
			
			String b = String.valueOf(a);
			
			try {
				  String[] params = {b};
				  SmsSingleSender ssender = new SmsSingleSender(appid, appkey);
				  SmsSingleSenderResult result = ssender.sendWithParam("86", phoneNumbers[0],
				      templateId, params, smsSign, "", "");
				  System.out.println(result);
				} catch (HTTPException e) {
				  // HTTP 响应码错误
				  e.printStackTrace();
				} catch (JSONException e) {
				  // JSON 解析错误
				  e.printStackTrace();
				} catch (IOException e) {
				  // 网络 IO 错误
				  e.printStackTrace();
				}
			JSONObject jb=new JSONObject();
			jb.put("name", 1);
			return jb.toString();
		}

	

}