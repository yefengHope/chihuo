package com.fengyu;

import org.jboss.logging.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * spring boot启动类
 */
@SpringBootApplication
@MapperScan("com.fengyu.system.dao")
@EnableAsync	//开启异步支持,并在非static方法上配置@Async
public class ChihuoApplication {

	private  final  static Logger logger = Logger.getLogger(ChihuoApplication.class);

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
		ConfigurableApplicationContext applicationContext = SpringApplication.run(ChihuoApplication.class, args);
		logger.info("************************************ 	启动完成 ! ! ! !  ************************************");
//		Object userService = applicationContext.getBean(UserServiceImpl.class);		//启动时报错
// 		Object userServiceName = applicationContext.getBean("userServiceImpl");
		// System.out.println(userServiceName);
//		System.out.println(userService);
// 		String beanName []= applicationContext.getBeanDefinitionNames();
// 		for (int i = 0; i < beanName.length; i++) {
// 			System.out.println(beanName[i]);
// 		}

		// String beanNameForEntity []= applicationContext.getBeanNamesForAnnotation(Entity.class);
		// for (int i = 0; i < beanNameForEntity.length; i++) {
		// 	System.out.println(beanNameForEntity[i]);
		// }

	}



}
