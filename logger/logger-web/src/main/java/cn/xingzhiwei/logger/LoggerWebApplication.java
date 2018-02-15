package cn.xingzhiwei.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

// @EnableDiscoveryClient
@SpringBootApplication
public class LoggerWebApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LoggerWebApplication.class, args);
	}
}
