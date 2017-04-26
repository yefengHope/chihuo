package com.fengyu.spiders;

import org.apache.commons.httpclient.methods.GetMethod;

/**
 * 网络连接方法
 * Created by rain on 2017/4/26.
 */
public interface HttpConnect {

    GetMethod httpGet(String url);

    GetMethod httpPost(String url);


}
