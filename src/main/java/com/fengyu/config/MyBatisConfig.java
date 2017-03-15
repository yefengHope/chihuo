package com.fengyu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * mybatis分页配置
 * Created by rain on 2017/3/13.
 */


@MapperScan("com.fengyu.system.dao")
//@PropertySources({ @PropertySource(value = "classpath:application.properties", ignoreResourceNotFound = true), @PropertySource(value = "file:./application.properties", ignoreResourceNotFound = true) })
@Configuration
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer {


    private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);

    @Autowired
    private JdbcConfig jdbcConfig;

    @Autowired
    DataSource dataSource;

    @Bean
    public DataSource createDataSource() throws SQLException {
        return DataSourceBuilder.create(Thread.currentThread().getContextClassLoader())
                .driverClassName(jdbcConfig.getDriverClass())
                .url(jdbcConfig.url)
                .username(jdbcConfig.userName)
                .password(jdbcConfig.password).build();
    }


    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

    @PropertySource(value = "classpath:application.properties")
    @Component
    static class JdbcConfig {
        //数据库用户名
        @Value("${spring.datasource.username}")
        private String userName;
        //        * 驱动名称         */
        @Value("${spring.datasource.driverClassName}")
        private String driverClass;
        //       * 数据库连接url         */
        @Value("${spring.datasource.url}")
        private  String url;
        //         * 数据库密码         */
        @Value("${spring.datasource.password}")
        private String password;

        public String getUserName() {
            return userName;
        }
        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getDriverClass() {
            return driverClass;
        }
        public void setDriverClass(String driverClass) {
            this.driverClass = driverClass;
        }
        public String getUrl() {
            return url;
        }
        public void setUrl(String url) {
            this.url = url;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }
}