package com.fengyu.internetQuery.enterpriseQuery;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/27 15:04 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class EnterpriseQueryImpl extends HttpUtils implements EnterpriseQuery {

    private static Logger logger = Logger.getLogger(EnterpriseQueryImpl.class);

    @Override
    public String queryProvinces( String dtype) {
        String url = AuthConfig.url + "Provinces?key=" + AuthConfig.authKey;
        if (StringUtils.isNotBlank(dtype)) {
            url += "dtype=" + dtype;
        }
        String body = get(url);
        logger.info(body);
        return body;
    }

    @Override
    public String queryCityList(String dtype) {
        String url = AuthConfig.url + "GetCityList?key=" + AuthConfig.authKey;
        if (StringUtils.isNotBlank(dtype)) {
            url += "dtype=" + dtype;
        }
        String body = get(url);
        logger.info(body);
        return body;
    }

    public static void main(String[] args) {
        EnterpriseQueryImpl query = new EnterpriseQueryImpl();
        String body = query.queryProvinces(null);
    }
}
