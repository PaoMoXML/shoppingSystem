/**
 * @author XuMenglin
 * @date 2019年9月7日
 *
 */
package com.controller;

import java.io.File;
import java.net.URL;
import java.util.Date;
import java.util.List;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpMethodName;
import com.qcloud.cos.model.Bucket;
import com.qcloud.cos.model.COSObjectSummary;
import com.qcloud.cos.model.GeneratePresignedUrlRequest;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.ListObjectsRequest;
import com.qcloud.cos.model.ObjectListing;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.region.Region;

/**
 * <p>Title: uploadtest</p>
 * <p>Description: 上传腾讯存储桶测试</p>
 * @author XuMenglin
 * @date 2019年9月7日
 */
public class uploadtest {
	
//    private static final String ACCESSKEY = "AKIDCYqkVVVkbm0BFISTp8WG0eCmFkEduzsg";
//    private static final String SECRETKEY = "mS1PadVCXBwtNsDQWRXcwJoI7nJmbrws";
//    private static final String BUCKETNAME = "xml2-1256638142";
//    private static final String APPID = "1256638142 ";
//    private static final String REGIONID = "ap-shanghai";
//    private static final String KEY="MyFile.png";
	
	
	private static final String ACCESSKEY = "AKIDxLciYCGXxQfeKoEEHVUHScbLqJ1VshS0";
    private static final String SECRETKEY = "XIomY4MVQ6cs77sBICyXqnVyLTN5btGN";
    private static final String BUCKETNAME ="lcq-1300182490";
    private static final String APPID = "1300182490";
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
     * 上传文件
     * @return
     * //绝对路径和相对路径都OK
     */
    public static String uploadFile() {
//        File localFile = new File("E:\\software\\JavaProject\\demo\\demo20\\src\\main\\resources\\1.jpg");
        File localFile = new File("C:\\Users\\xml00\\Desktop\\ff壁纸\\暗影之鲶.jpg");
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
        // 关闭客户端
        cc.shutdown();
        return null;
    }

    /**
     * 下载文件
     * @param bucketName
     * @param key
     * @return
     */
    public static String downLoadFile(String bucketName, String key) {
        File downFile = new File("E:\\software\\1.jpg");
        COSClient cc = getCosClient();
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);

        ObjectMetadata downObjectMeta = cc.getObject(getObjectRequest, downFile);
        cc.shutdown();
        String etag = downObjectMeta.getETag();
        return etag;
    }

    /**
     * 删除文件
     * @param bucketName
     * @param key
     */
    public static void deleteFile(String bucketName, String key) {
        COSClient cc = getCosClient();
        try {
            cc.deleteObject(bucketName, key);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
            cc.shutdown();
        }

    }

    /**
     * 创建桶
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public static Bucket createBucket(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        Bucket bucket = null;
        try {
            bucket = cc.createBucket(bucketName);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
        }
        return bucket;
    };

    /**
     * 删除桶
     * @param bucketName
     * @throws CosClientException
     * @throws CosServiceException
     */
    public void deleteBucket(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        try {
            cc.deleteBucket(bucketName);
        } catch (CosClientException e) {
            e.printStackTrace();
        } finally {
        }
    };

    /**
     * 判断桶是否存在
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public static boolean doesBucketExist(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();
        boolean bucketExistFlag = cc.doesBucketExist(bucketName);
        return bucketExistFlag;
    };

    /**
     * 查看桶文件
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public static ObjectListing listObjects(String bucketName) throws CosClientException, CosServiceException {
        COSClient cc = getCosClient();

        // 获取 bucket 下成员（设置 delimiter）
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest();
        listObjectsRequest.setBucketName(bucketName);
        // 设置 list 的 prefix, 表示 list 出来的文件 key 都是以这个 prefix 开始
        listObjectsRequest.setPrefix("");
        // 设置 delimiter 为/, 即获取的是直接成员，不包含目录下的递归子成员
        listObjectsRequest.setDelimiter("/");
        // 设置 marker, (marker 由上一次 list 获取到, 或者第一次 list marker 为空)
        listObjectsRequest.setMarker("");
        // 设置最多 list 100 个成员,（如果不设置, 默认为 1000 个，最大允许一次 list 1000 个 key）
        listObjectsRequest.setMaxKeys(100);

        ObjectListing objectListing = cc.listObjects(listObjectsRequest);
        // 获取下次 list 的 marker
        String nextMarker = objectListing.getNextMarker();
        // 判断是否已经 list 完, 如果 list 结束, 则 isTruncated 为 false, 否则为 true
        boolean isTruncated = objectListing.isTruncated();
        List<COSObjectSummary> objectSummaries = objectListing.getObjectSummaries();
        for (COSObjectSummary cosObjectSummary : objectSummaries) {
            // get file path
            String key = cosObjectSummary.getKey();
            // get file length
            long fileSize = cosObjectSummary.getSize();
            // get file etag
            String eTag = cosObjectSummary.getETag();
            // get last modify time
            Date lastModified = cosObjectSummary.getLastModified();
            // get file save type
            String StorageClassStr = cosObjectSummary.getStorageClass();
        }
        return objectListing;
    }

    /**
     *查询一个 Bucket 所在的 Region。
     * @param bucketName
     * @return
     * @throws CosClientException
     * @throws CosServiceException
     */
    public static String getBucketLocation(String bucketName) throws CosClientException , CosServiceException{
       COSClient cosClient = getCosClient();
        // bucket 的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
        String location = cosClient.getBucketLocation(bucketName);
        return location;
    }

    public static void main(String[] args) {
    	uploadFile();
//        downLoadFile(BUCKETNAME , KEY);
//         // deleteFile(BUCKETNAME , KEY01);
//        createBucket("sunjunxian01-1251782781");
//        //deleteBucket();
//        doesBucketExist("sunjunxian01-1251782781");
//        System.out.println(listObjects(BUCKETNAME));
        //System.out.println("BUCKETNAME的位置：" + getBucketLocation(BUCKETNAME));
    	
//    	getUrl();
    	
    	
    }

public static String getUrl() {
	// 初始化永久密钥信息
	String secretId = "AKIDCYqkVVVkbm0BFISTp8WG0eCmFkEduzsg";
	String secretKey = "mS1PadVCXBwtNsDQWRXcwJoI7nJmbrws";
	COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
	Region region = new Region("ap-shanghai");
	ClientConfig clientConfig = new ClientConfig(region);
	// 生成 cos 客户端。
	COSClient cosClient = new COSClient(cred, clientConfig);
	// 存储桶的命名格式为 BucketName-APPID，此处填写的存储桶名称必须为此格式
	String bucketName = "xml-1256638142";
	String key = "paomo.png";
	GeneratePresignedUrlRequest req =
	        new GeneratePresignedUrlRequest(bucketName, key, HttpMethodName.GET);
	// 设置签名过期时间(可选), 若未进行设置, 则默认使用 ClientConfig 中的签名过期时间(1小时)
	// 这里设置签名在半个小时后过期
	Date expirationDate = new Date(System.currentTimeMillis() + 30L * 60L * 1000L);
	req.setExpiration(expirationDate);
	URL url = cosClient.generatePresignedUrl(req);
	System.out.println(url.toString());
	cosClient.shutdown();
	return null;
}
 
}
