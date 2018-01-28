package cn.xingzhiwei.register;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableEurekaServer //默认服务中心也会将自己作为客户端来尝试注册自己
@SpringBootApplication
public class RegisterEurekaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterEurekaWebApplication.class, args);
	}
}
