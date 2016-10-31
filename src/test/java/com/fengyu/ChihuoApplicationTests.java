package com.fengyu;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;


/*@RunWith 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文*/
@RunWith(SpringJUnit4ClassRunner.class)
/*@SpringApplicationConfiguration 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下文。
这是一个元注解（meta-annoation），它包含了@ContextConfiguration( loader = SpringApplicationContextLoader.class)这个注解，
测试框架通过这个注解使用Spring Boot框架的SpringApplicationContextLoader加载器创建应用上下文。*/
@SpringApplicationConfiguration(classes = ChihuoApplication.class)
@WebAppConfiguration
public class ChihuoApplicationTests {

	Logger logger = Logger.getLogger(ChihuoApplicationTests.class);

	@Test
	public void contextLoads() {

	}




}


/*
*spring test测试框架案例*
*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/config/Spring-db1.xml")
@Transactional
public class AccountServiceTest1 {
	@Autowired
	private AccountService service;

	@Test
	public void testGetAcccountById() {
		Account acct = Account.getAccount(1, "user01", 18, "M");
		service.insertIfNotExist(acct);
		Account acct2 = service.getAccountById(1);
		assertEquals(acct,acct2);
	}
}*/
