package com.dgg.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.common.io.CharStreams;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 客户端请求工具类
 * Created by hanfeng on 2017/3/2.
 */
public class HttpClientUtil {

    static Logger logger = Logger.getLogger(HttpClientUtil.class);

    /**
     * get请求访问
     *
     * @return
     */
    public static HttpGet get(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return request;
    }

    /**
     * post方式提交表单（模拟用户登录请求）
     *
     * @param url        访问url
     *                   <p>"http://localhost:8080/myDemo/Ajax/serivceJ.action"</p>
     * @param params 参数队列
     */
    public static HttpPost postForm(String url, JSONObject params) {

        HttpPost httpost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();

        Set<String> keySet = params.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, params.getString(key)));
        }
        try {
            httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return httpost;
    }

    public static String sendPost(HttpPost httpPost) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 返回字符串
        String responseBody = null;
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    long length = entity.getContentLength();
                    if (length != -1 && length < 2048) {
                        responseBody = EntityUtils.toString(entity, "UTF-8");
                    } else {
                        InputStream inStream = entity.getContent();
                        responseBody = CharStreams.toString(new InputStreamReader(inStream, "UTF-8"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }

    public static String sendGet(HttpGet httpGet) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 返回字符串
        String responseBody = null;
        try {
            CloseableHttpResponse response = httpclient.execute(httpGet);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    long length = entity.getContentLength();
                    if (length != -1 && length < 2048) {
                        responseBody = EntityUtils.toString(entity, "UTF-8");
                    } else {
                        InputStream inStream = entity.getContent();
                        responseBody = CharStreams.toString(new InputStreamReader(inStream, "UTF-8"));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                response.close();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭连接,释放资源
            try {
                httpclient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseBody;
    }


//    public static void main(String[] args) {
//        String url = "http://localhost:8093/user/all_page_list.htm";
//        List formparams = new ArrayList();
//        formparams.add(new BasicNameValuePair("limit", "10"));
//        formparams.add(new BasicNameValuePair("pageNumber", "1"));
//        formparams.add(new BasicNameValuePair("searchText", ""));
//        formparams.add(new BasicNameValuePair("sortOrder", ""));
//        formparams.add(new BasicNameValuePair("sortName", ""));
//        logger.warn(postForm(url,formparams));

     // params.put("p", returnData.toJSONString());
    // HttpPost httpPost = HttpClientUtil.postForm(this.getUrl(), params);
//    }

}
