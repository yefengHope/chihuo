package com.fengyu.internetQuery.enterpriseQuery;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/27 15:07 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class HttpUtils {

    public String get(String url) {
        String result = "";
        HttpGet httpRequst = new HttpGet(url);
        try {
            HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequst);

            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = httpResponse.getEntity();
                result = EntityUtils.toString(httpEntity);//取出应答字符串
                // 一般来说都要删除多余的字符
                // result.replaceAll("\r", "");//去掉返回结果中的"\r"字符，否则会在结果字符串后面显示一个小方格
            } else {
                httpRequst.abort();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
