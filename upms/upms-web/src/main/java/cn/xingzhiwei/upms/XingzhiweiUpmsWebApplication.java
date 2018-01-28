package cn.xingzhiwei.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class XingzhiweiUpmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(XingzhiweiUpmsWebApplication.class, args);
	}
}
