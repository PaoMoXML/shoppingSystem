/**
 * @author XuMenglin
 * @date 2019年9月9日
 *
 */
package com.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.pojo.UploadedImageFile;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

/**
 * <p>Title: upload</p>
 * <p>Description: </p>
 * @author XuMenglin
 * @date 2019年9月9日
 */
@Controller
@RequestMapping("/upload")
public class upload {
	
	
    private static final String ACCESSKEY = "AKIDCYqkVVVkbm0BFISTp8WG0eCmFkEduzsg";
    private static final String SECRETKEY = "mS1PadVCXBwtNsDQWRXcwJoI7nJmbrws";
    private static final String BUCKETNAME = "xml-1256638142";
    private static final String APPID = "1256638142 ";
    private static final String REGIONID = "ap-shanghai";
    private static final String KEY="MyFile.png";
    
    public static COSClient getCosClient() {
        // 1 初始化用户身份信息(secretId, secretKey)
        COSCredentials cred = new BasicCOSCredentials(ACCESSKEY, SECRETKEY);
        // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
        // clientConfig中包含了设置region, https(默认http), 超时, 代理等set方法, 使用可参见源码或者接口文档FAQ中说明
        ClientConfig clientConfig = new ClientConfig(new Region(REGIONID));
        // 3 生成cos客户端
        COSClient cosClient = new COSClient(cred, clientConfig);
        // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        //String bucketName = BUCKETNAME;
        return cosClient;
    }
	
    /**
     *<p>Title: upload</p>
     *<p>Description: 上传图片到腾讯存储桶</p>
     * @param request
     * @param file
     * @return
     * @throws IllegalStateException
     * @throws IOException
     */
    @RequestMapping("/uploadImage")
	@ResponseBody
	public String upload(HttpServletRequest request, UploadedImageFile file)
            throws IllegalStateException, IOException {
    	
    	
    	String realpath = request.getServletContext().getRealPath("upload");

		File targetDir = new File(realpath); // 先建目录
		if (!targetDir.exists()) {
			targetDir.mkdirs();
		}
		String fileName = file.getImage().getOriginalFilename();
		File targetFile = new File(realpath, fileName); // 再在目录中建文件
		System.out.println("-------------------------------------------");
		System.out.println(targetFile);
		System.out.println(targetFile.toString());
		System.out.println("-------------------------------------------");
        // 创建文件，给文件起名字
//        String newFileName = name + suffix;
//        System.out.println("-------------------------------------------");
//        System.out.println(fileName);
		//先上传到本地文件夹中
		try {
			file.getImage().transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
        //获取文件URL
        String fileUrl = targetFile.toString();
        
        //使用获取到的URL上传文件到腾讯云对象存储空间
        File localFile = new File(fileUrl);
        String filename = localFile.getName();
        PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, filename, localFile);

        // 设置存储类型, 默认是标准(Standard), 低频(standard_ia),一般为标准的
        putObjectRequest.setStorageClass(StorageClass.Standard);

        COSClient cc = getCosClient();
        try {
            PutObjectResult putObjectResult = cc.putObject(putObjectRequest);
            // putobjectResult会返回文件的etag
            String etag = putObjectResult.getETag();
            System.out.println(etag);
        } catch (CosServiceException e) {
            e.printStackTrace();
        } catch (CosClientException e) {
            e.printStackTrace();
        }
        //上传完成
        // 关闭客户端
        cc.shutdown();
        
        //删除本地文件
        File delfile = new File(targetFile.toString());
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (delfile.exists() && delfile.isFile()) {
            if (delfile.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
        }
        
        //文件上传完成
        JSONObject json = new JSONObject();
        json.put("key", "Upload Success");
        
        //将文件名存入数据库中
        
        
        
        //返回成功
        return json.toJSONString();
        
	}
    
    
    /**
     *<p>Title: getImgUrl</p>
     *<p>Description: 获取文件带签名的URL（有效时间30分钟）</p>
     * @return
     */
    @RequestMapping("/getImgUrl")
    public static String getImgUrl() {
    	//生成cos客户机
    	COSClient cosClient = getCosClient();
    	// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
    	String key = "1533531213528066039.png";
    	GeneratePresignedUrlRequest req =new GeneratePresignedUrlRequest(BUCKETNAME, key, HttpMethodName.GET);
    	// 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
    	// 这里设置签名在半个小时后过期
    	Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
    	req.setExpiration(expirationDate);
    	URL url = cosClient.generatePresignedUrl(req);
    	System.out.println(url.toString());
    	cosClient.shutdown();
		return null;
    }
    
    public static void main(String[] args) {
    	getImgUrl();
	}
    
}
