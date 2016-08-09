package com.fengyu;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpStatus;

import javax.sql.DataSource;

/**
 * spring boot启动类
 */
@SpringBootApplication
@ImportResource()
public class ChihuoApplication {

	private  final  static Logger logger = Logger.getLogger(ChihuoApplication.class);

	/**
	 * 错误跳转页面
	 * @return
     */
/*	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"); //如果404在根目录下 ,则"/404"
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
            container.addErrorPages(error404Page, error500Page);
        });
    }*/


	/**
	 * spring boot properties已配置,为了跟多配置
	 * 自定义配置数据源
	 * @return
     */
	/*@Bean
	@ConfigurationProperties(locations="classpath:jdbc.properties", prefix="datasource")
	public DataSource dataSource(){
		return DataSourceBuilder.create().build();
	}*/

	/**
	 * 启动方法
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(ChihuoApplication.class, args);
		logger.info("---------------------- 启动完成 ! ! ! ! ");
	}
}
