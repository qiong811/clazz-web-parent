package com.baizhi.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.baizhi.config.AliYunConfig;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class AliYun implements AliYunConfig {
    //上传图片到存储空间
    public static String uploadPhoto(MultipartFile photo) throws IOException {
        String filename = photo.getOriginalFilename();
        String s = UUID.randomUUID().toString();
        byte[] bytes = photo.getBytes();

        String endpoint = ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ACCESS_KEY_ID;
        String accessKeySecret = ACCESS_KEY_SECRET;
        String bucketName = BUCKET_NAME;  //存储空间名
        String objectName = s + filename;  //文件名  可以指定文件目录
//        String localFile=path+"//"+filename;  //本地视频路径

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 创建PutObjectRequest对象。 参数：Bucket名字，指定文件名，文件本地路径
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(bytes));
        //  PutObjectRequest putObjectRequest = new PutObjectRequest("examplebucket", "exampledir/exampleobject.txt", new ByteArrayInputStream(content.getBytes()));
        // 上传文件。
        ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
        return objectName;
    }

    //下载
    public static void testDownLoad(String headimg) {


        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = ENDPOINT;
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = ACCESS_KEY_ID;
        String accessKeySecret = ACCESS_KEY_SECRET;
        String bucketName = BUCKET_NAME;  //存储空间名//存储空间名
        String objectName = headimg;  //文件名
        String localFile = "D:\\headimg\\" + objectName;  //下载本地地址  地址加保存名字
        System.out.println(localFile);
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localFile));

        // 关闭OSSClient。
        ossClient.shutdown();
    }

}
