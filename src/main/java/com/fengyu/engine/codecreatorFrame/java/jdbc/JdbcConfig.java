package com.fengyu.engine.codecreatorFrame.java.jdbc;

/**
 * <p>@Title JDBC配置类 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/20 11:20 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class JdbcConfig {

    // JDBC 驱动名及数据库 URL
    final String jdbcDriver = "com.mysql.jdbc.Driver";
    final String dbUrl = "jdbc:mysql://localhost:3306/RUNOOB";

    // 数据库的用户名与密码，需要根据自己的设置
    final String user = "root";
    final String pass = "123456";

    // 数据库表名
    final String tableName = "123456";

}
