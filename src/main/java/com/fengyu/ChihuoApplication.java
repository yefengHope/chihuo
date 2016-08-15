package com.fengyu;

import com.fengyu.system.domain.User;
import com.fengyu.system.domain.repository.UserRepository;
import com.fengyu.system.domain.repository.base.BaseRepositoryFactoryBean;
import com.fengyu.system.service.UserService;
import com.fengyu.util.common.CommonPath;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.request.RequestContextListener;

import javax.annotation.Resource;

/**
 * spring boot启动类
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)	//设置spring data jpa
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
	 * request监听器
	 * @return
     */
	/*@Bean
	public RequestContextListener requestContextListener(){
		RequestContextListener requestContextListener = new RequestContextListener();

		return requestContextListener;
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
