package com.fengyu.spiders;



import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 用来下载 url 所指向的网页
 * Created by rain on 2017/4/26.
 */
public class FileDownLoader extends SpidersConfig{

    Logger logger = Logger.getLogger(FileDownLoader.class);

    /**根据 url 和网页类型生成需要保存的网页的文件名
     *去除掉 url 中非文件名字符
     */
    public  String getFileNameByUrl(String url,String contentType) {

        url=url.substring(7);//remove http://
        if(contentType.indexOf("html")!=-1) {//text/html

            url= url.replaceAll("[\\?/:*|<>\"]", "_")+".html";
            return url;
        }
        else {//如application/pdf

            return url.replaceAll("[\\?/:*|<>\"]", "_")+"."+
            contentType.substring(contentType.lastIndexOf("/")+1);
        }
    }

    /**保存网页字节数组到本地文件
     * filePath 为要保存的文件的相对地址
     */
    private void saveToLocal(byte[] data,String filePath)
    {
        try {
            // DataOutputStream out=new DataOutputStream(
            //         new FileOutputStream(new File(filePath)));
            FileOutputStream out = FileUtils.openOutputStream(new File(filePath),true);
            logger.info("文件保存位置: " + filePath);
            for(int i=0;i<data.length;i++) {
                out.write(data[i]);
            }
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*下载 url 指向的网页*/
    public String  downloadFile(String url) {
        String filePath=null;
		/* 1.生成 HttpClinet 对象并设置参数*/
        HttpClient httpClient=new HttpClient();
        //设置 Http 连接超时 5s
        httpClient.getHttpConnectionManager().getParams().
                setConnectionTimeout(connectionTimeout);

		  /*2.生成 GetMethod 对象并设置参数*/
        GetMethod getMethod=new GetMethod(url);
        //设置 get 请求超时 5s
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,socketTimeout);
        //设置请求重试处理
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());

		  /*3.执行 HTTP GET 请求*/
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            //判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                logger.error("执行方法失败: "+ getMethod.getStatusLine());
                filePath=null;
            }

			  /*4.处理 HTTP 响应内容*/
            byte[] responseBody = getMethod.getResponseBody();//读取为字节数组
            //根据网页 url 生成保存时的文件名
            filePath="target" + File.separator + "spiders" + File.separator + getFileNameByUrl(url,
                    getMethod.getResponseHeader("Content-Type").getValue());
            saveToLocal(responseBody,filePath);
        } catch (HttpException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            logger.error("请检查你提供的http地址!");
            e.printStackTrace();
        } catch (IOException e) {
            // 发生网络异常
            e.printStackTrace();
        } finally {
            // 释放连接
            getMethod.releaseConnection();
        }
        return filePath;
    }


    //测试的 main 方法
    public static void main(String[]args) {
        FileDownLoader downLoader = new FileDownLoader();
        downLoader.downloadFile("http://www.twt.edu.cn");
    }
}
