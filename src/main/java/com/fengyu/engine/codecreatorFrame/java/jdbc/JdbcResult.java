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
     * {
     *      "COLUMN_COMMENT":"列注释",
     *      "COLUMN_KEY":"列键 (如:PRI)",
     *      "COLUMN_NAME":"列名称",
     *      "COLUMN_TYPE":"列类型 (如:bigint(20))",
     *      "DATA_TYPE":"数据类型 (如: bigint)",
     *      "EXTRA":"auto_increment",
     *      "GENERATION_EXPRESSION":"",
     *      "IS_NULLABLE":"是否允许null (如:NO)",
     *      "NUMERIC_PRECISION":"数字精度",
     *      "NUMERIC_SCALE":"0",
     *      "ORDINAL_POSITION":"顺序位置 (如:1)",
     *      "PRIVILEGES":"select,insert,update,references",
     *      "TABLE_CATALOG":"def",
     *      "TABLE_NAME":"ts_user",
     *      "TABLE_SCHEMA":"chihuo"
     * }
     */
    List<Map<String, String>> getTableStructureList();

}
