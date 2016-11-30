package com.fengyu;

import com.fengyu.engine.codecreator.java.FreeMarkerUtil;
import com.fengyu.engine.codecreatorFrame.java.service.FtlTemplatesService;
import com.fengyu.system.domain.User;
import com.fengyu.util.base.BaseEnity;
import com.fengyu.util.common.crypto.DesApp;
import freemarker.template.Template;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*@RunWith 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文*/
@RunWith(SpringJUnit4ClassRunner.class)
/*@SpringApplicationConfiguration 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下文。
这是一个元注解（meta-annoation），它包含了@ContextConfiguration( loader = SpringApplicationContextLoader.class)这个注解，
测试框架通过这个注解使用Spring Boot框架的SpringApplicationContextLoader加载器创建应用上下文。*/
@SpringApplicationConfiguration(classes = ChihuoApplication.class)
@WebAppConfiguration
public class ChihuoApplicationTests {

	@Resource
	private FtlTemplatesService ftlTemplatesService;

	Logger logger = Logger.getLogger(ChihuoApplicationTests.class);

	@Test
	public void contextLoads() {

	}

	/**
	 * 框架的模板生成器测试
	 */
	@Test
	public void ftlTemplateTest() {
		// String projectPath = "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//testrusult//";  //通过测试的反斜杠
		String projectPath = "F:\\workSpace\\GitWork\\chihuo\\src\\main\\java\\com\\fengyu\\engine\\codecreatorFrame\\templates\\";
		String fileName = "areasql.txt";
		String savePath = "area";
		String templateName = null;
		Map map = new HashMap();
		ftlTemplatesService.setPath(projectPath);
		Template template = ftlTemplatesService.getDirectoryForTemplate(templateName);
		ftlTemplatesService.createTemplate(map,projectPath,savePath,fileName,template);
	}

	@Test
	public void baseInherit() {
		User user = new User();
		user.setLoginNum("biubiubibu");
		user.setEmail("111223@qq.com");
		user.toString();
		User user1 = (User) createBase(user);
		user.toString();
		BaseEnity baseEnity = createBase(user);
		baseEnity.toString();
	}



	public BaseEnity createBase (BaseEnity entity) {
		return entity;
	}

	@Test
	public void decryptDES(){
		try {
			String content = "/user/all_page_list";
			String encryptResult = DesApp.encryptDESWrap(content);
			System.out.println(encryptResult);
			String decryptResult = DesApp.decryptDESWrap(encryptResult);
			System.out.println(decryptResult);
			return;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void decryptDES1(){
		try {
			String content = "test";
			String password = "12345678";
			//加密
			System.out.println("加密前：" + content);
			String encryptResult = DesApp.encryptDES(content, password);
			//解密
			String decryptResult = DesApp.decryptDES(encryptResult,password);
			System.out.println("解密后：" + new String(decryptResult));
		} catch (Exception e) {
			e.printStackTrace();
		}
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
