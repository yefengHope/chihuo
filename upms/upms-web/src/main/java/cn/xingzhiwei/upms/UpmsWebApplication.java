package cn.xingzhiwei.upms;

import cn.xingzhiwei.common.pojo.mybatis.BaseMapper;
import cn.xingzhiwei.upms.bean.properties.BookProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

// @EnableDiscoveryClient
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan(basePackages = "cn.xingzhiwei.upms.dao", markerInterface = BaseMapper.class)
public class UpmsWebApplication {

	@Resource
	private BookProperties bookConfig;

	private static BookProperties book;

	@PostConstruct
	private void init() {
		book = bookConfig;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(UpmsWebApplication.class, args);

		// 以下执行都有问题，不能找到定义的bean
		// BookConfig bookConfig = (BookConfig) context.getBean(BookConfig.class);
		// BookConfig bookConfig = (BookConfig) context.getBean("bookConfig");
		// System.out.println(bookConfig);

		 // 换种@Resource注入方式
		System.out.println(book);
	}
}
