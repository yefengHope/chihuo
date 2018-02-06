package cn.xingzhiwei.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

// @EnableDiscoveryClient
@SpringBootApplication
public class UpmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpmsWebApplication.class, args);
	}
}
