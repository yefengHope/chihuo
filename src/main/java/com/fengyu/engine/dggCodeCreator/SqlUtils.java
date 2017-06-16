package com.fengyu.engine.dggCodeCreator;

import com.alibaba.fastjson.JSON;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/15 10:18 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class SqlUtils {

    String sql = "select * from information_schema.columns where table_name='PT_ORDERS_REPORTS_DAY' ";
    String url = "jdbc:mysql://192.168.254.61:3306/pt_orders?useUnicode=true&characterEncoding=utf-8";
    String driverClassName = "com.mysql.jdbc.Driver";
    String userName = "root";
    String password = "root";

    public JdbcTemplate jdbcConnect() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    /**
     * 查询数据库表的列名称
     *
     * @return
     */
    public List<String> selectColumnName() {
        JdbcTemplate jdbcTemplate = jdbcConnect();
        List<String> list = new ArrayList<>();

        ResultSetExtractor<List> rse = new ResultSetExtractor<List>() {
            @Override
            public List extractData(ResultSet rs) throws SQLException, DataAccessException {
                // List<Map<String, Object>> list = new ArrayList<>();
                while (rs.next()) {
                    // Map<String, Object> map = new HashMap<>();
                    // map.put("COLUMN_NAME", );
                    list.add(rs.getString("COLUMN_NAME"));
                }
                return list;
            }
        };
        jdbcTemplate.query(sql, rse);
        return list;
    }

    public static void main(String[] args) {
        SqlUtils sqlUtils = new SqlUtils();
        List<String> list = sqlUtils.selectColumnName();
        System.out.println(JSON.toJSONString(list));
    }
}
