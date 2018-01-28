package cn.xingzhiwei.upms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableEurekaServer //默认服务中心也会将自己作为客户端来尝试注册自己
@SpringBootApplication
public class XingzhiweiUpmsWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(XingzhiweiUpmsWebApplication.class, args);
	}
}
