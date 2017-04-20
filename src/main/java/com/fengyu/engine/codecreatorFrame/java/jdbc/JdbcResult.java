package com.fengyu.engine.codecreatorFrame.java.jdbc;

import java.util.List;
import java.util.Map;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/20 16:34 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public interface JdbcResult {

    /**
     * 根据sql获取内容
     * @param sql
     * @return
     */
    List<Map<String, String>> getList(String sql);

    /**
     * 获取数据表结构
     * 表名称为AbstractJdbcConfig里的名称
     * @return
     */
    List<Map<String, String>> getTableStructureList();

}
