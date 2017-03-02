package com.fengyu.network;

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
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * 客户端请求工具类
 * Created by rain on 2017/3/2.
 */
public class HttpClientUtil {

    static Logger logger = Logger.getLogger(HttpClientUtil.class);
    /**
     * get请求访问
     * @return
     */
    public static Object get(String url) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) ...");
        CloseableHttpResponse response = httpclient.execute(request);

        // read response
//        String responseBody = EntityUtils.toString(response.getEntity()); //返回数据少可以用toString(),否则用流
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            long length = entity.getContentLength();
            if (length != -1 && length < 2048) {
                String responseBody = EntityUtils.toString(entity);
            }
            else {
                InputStream in = entity.getContent();
                // read from the input stream ...
            }
        }

        return null;
    }

    /**
     * post方式提交表单（模拟用户登录请求）
     * @param url        访问url
     *          <p>"http://localhost:8080/myDemo/Ajax/serivceJ.action"</p>
     * @param formparams 参数队列
     * <p>
     * <p>         List<NameValuePair> formparams = new ArrayList<NameValuePair>();
     * <p>         formparams.add(new BasicNameValuePair("username", "admin"));
     * <p>         formparams.add(new BasicNameValuePair("password", "123456"));
     * <p>
     */
    public static String postForm(String url,List<NameValuePair> formparams) {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httppost = new HttpPost(url);
        // 创建参数队列
        UrlEncodedFormEntity uefEntity;
        // 返回字符串
        String responseBody = null;
        try {
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");
            httppost.setEntity(uefEntity);
            logger.info("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);
            try {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    long length = entity.getContentLength();
                    if (length != -1 && length < 2048) {
                        responseBody = EntityUtils.toString(entity, "UTF-8");
                    }
                    else {
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




    public static void main(String[] args) {
        String url = "http://localhost:8093/user/all_page_list.htm";
        List  formparams = new ArrayList();
        formparams.add(new BasicNameValuePair("limit", "10"));
        formparams.add(new BasicNameValuePair("pageNumber", "1"));
        formparams.add(new BasicNameValuePair("searchText", ""));
        formparams.add(new BasicNameValuePair("sortOrder", ""));
        formparams.add(new BasicNameValuePair("sortName", ""));
        logger.warn(postForm(url,formparams));
    }

}
