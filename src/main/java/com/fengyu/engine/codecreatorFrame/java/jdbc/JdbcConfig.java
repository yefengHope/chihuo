package com.fengyu.engine.codecreatorFrame.java.jdbc;

import java.io.Serializable;

/**
 * <p>@Title JDBC配置类 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/4/20 11:20 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class JdbcConfig implements Serializable{

    private static final long serialVersionUID = 4623479418515046747L;

    // JDBC 驱动名及数据库 URL
    private static String jdbcDriver = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://localhost:3306/chihuo";

    // 数据库的用户名与密码，需要根据自己的设置
    private static String user = "root";
    private static String pass = "hanfeng111222!@#";

    // 数据库表名
    private static String tableName = "ts_user";


    public static String getJdbcDriver() {
        return jdbcDriver;
    }

    public static void setJdbcDriver(String jdbcDriver) {
        JdbcConfig.jdbcDriver = jdbcDriver;
    }

    public static String getDbUrl() {
        return dbUrl;
    }

    public static void setDbUrl(String dbUrl) {
        JdbcConfig.dbUrl = dbUrl;
    }

    public static String getUser() {
        return user;
    }

    public static void setUser(String user) {
        JdbcConfig.user = user;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        JdbcConfig.pass = pass;
    }

    public static String getTableName() {
        return tableName;
    }

    public static void setTableName(String tableName) {
        JdbcConfig.tableName = tableName;
    }
}
