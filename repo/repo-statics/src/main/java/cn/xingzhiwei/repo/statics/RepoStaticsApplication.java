package cn.xingzhiwei.repo.statics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RepoStaticsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RepoStaticsApplication.class, args);
	}
}
