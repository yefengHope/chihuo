package com.fengyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

/**
 * spring boot启动类
 */
@SpringBootApplication
public class ChihuoApplication {

	/**
	 * 错误跳转页面
	 * @return
     */
	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404.html"); //如果404在根目录下 ,则"/404"
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500.html");
            container.addErrorPages(error404Page, error500Page);
        });
    }

	/**
	 * 启动方法
	 * @param args
     */
	public static void main(String[] args) {
		SpringApplication.run(ChihuoApplication.class, args);
		System.out.println("		>>>>>>>>>>>>>>>>>>>>>		启动完成 ! ! ! ! 	");
	}
}
