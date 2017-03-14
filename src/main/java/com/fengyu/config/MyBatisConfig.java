// package com.fengyu.config;
//
// import com.github.pagehelper.PageHelper;
// import org.apache.ibatis.plugin.Interceptor;
// import org.apache.ibatis.session.SqlSessionFactory;
// import org.mybatis.spring.SqlSessionFactoryBean;
// import org.mybatis.spring.SqlSessionTemplate;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.core.io.support.ResourcePatternResolver;
// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.stereotype.Component;
// import org.springframework.transaction.PlatformTransactionManager;
// import org.springframework.transaction.annotation.EnableTransactionManagement;
// import org.springframework.transaction.annotation.TransactionManagementConfigurer;
//
// import javax.sql.DataSource;
// import java.util.Properties;
//
// /**
//  * mybatis分页配置
//  * Created by rain on 2017/3/13.
//  */
// @Configuration
// @EnableTransactionManagement
// public class MyBatisConfig implements TransactionManagementConfigurer {
//
//     @Autowired
//     DataSource dataSource;
//
//     @Bean(name = "sqlSessionFactory")
//     public SqlSessionFactory sqlSessionFactoryBean() {
//         SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//         bean.setDataSource(dataSource);
//         //分页插件
//         PageHelper pageHelper = new PageHelper();
//         Properties props = new Properties();
//         props.setProperty("reasonable", "true");
//         props.setProperty("supportMethodsArguments", "true");
//         props.setProperty("returnPageInfo", "check");
//         props.setProperty("params", "count=countSql");
//         pageHelper.setProperties(props);
//         //添加插件
//         bean.setPlugins(new Interceptor[]{pageHelper});
//         try {
//             ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//             bean.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
//             return bean.getObject();
//         } catch (Exception e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
//
//
//     private static final Logger logger = LoggerFactory.getLogger(MyBatisConfig.class);
//     @Autowired
//     // private JdbcConfig jdbcConfig;
//     // @Bean
//     // public DataSource createDataSource() throws SQLException {
//     //     return DataSourceBuilder.create(Thread.currentThread().getContextClassLoader())
//     //             .driverClassName(jdbcConfig.getDriverClass())
//     //             .url(jdbcConfig.url)
//     //             .username(jdbcConfig.userName)
//     //             .password(jdbcConfig.password).build();
//     // }
//
//     @Bean
//     public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
//         return new SqlSessionTemplate(sqlSessionFactory);
//     }
//
//     @Bean
//     @Override
//     public PlatformTransactionManager annotationDrivenTransactionManager() {
//         return new DataSourceTransactionManager(dataSource);
//     }
// }