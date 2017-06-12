// package com.fengyu;
//
// import com.fengyu.engine.codecreatorFrame.java.service.FtlTemplatesService;
// import com.fengyu.system.base.BaseEntity;
// import com.fengyu.system.entity.User;
// import com.fengyu.util.common.crypto.DesApp;
// import freemarker.template.Template;
// import org.apache.log4j.Logger;
// import org.junit.Before;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.MockitoAnnotations;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.SpringApplicationConfiguration;
// import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
// import org.springframework.test.context.web.WebAppConfiguration;
// import org.springframework.test.web.servlet.MockMvc;
// import org.springframework.test.web.servlet.setup.MockMvcBuilders;
// import org.springframework.web.context.WebApplicationContext;
//
// import javax.annotation.Resource;
// import java.util.HashMap;
// import java.util.Map;
//
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//
//
// /*@RunWith 这是JUnit的注解，通过这个注解让SpringJUnit4ClassRunner这个类提供Spring测试上下文*/
// @RunWith(SpringJUnit4ClassRunner.class)
// /*@SpringApplicationConfiguration 这是Spring Boot注解，为了进行集成测试，需要通过这个注解加载和配置Spring应用上下文。
// 这是一个元注解（meta-annoation），它包含了@ContextConfiguration( loader = SpringApplicationContextLoader.class)这个注解，
// 测试框架通过这个注解使用Spring Boot框架的SpringApplicationContextLoader加载器创建应用上下文。*/
// @SpringApplicationConfiguration(classes = ChihuoApplication.class)
// @WebAppConfiguration
// public class ChihuoApplicationTests {
// 	Logger logger = Logger.getLogger(ChihuoApplicationTests.class);
//
// 	private MockMvc mockMvc;
//
// 	@Resource
// 	private FtlTemplatesService ftlTemplatesService;
//
// 	@Autowired
// 	private WebApplicationContext webApplicationContext;
//
// 	@Before
// 	public void setup() {
// 		MockitoAnnotations.initMocks(this);
// //        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
// 		this.mockMvc = MockMvcBuilders.standaloneSetup(webApplicationContext).build();
// 	}
//
// 	@Test
// 	public void login() throws Exception {
//
//         /*mockMvc.perform(post("/sys/login.do")
//                 .param("username", "3031372")
//                 .param("password", "test")
//                 )
//                 .andDo(print())
//                 .andExpect(status().isOk()).andExpect(content().string(is("{\"status\":\"" + 11111 + "\"}")));*/
//
// 		mockMvc.perform(post("/user/all_page_list")
// 				.param("name", "峰哥哥")
// 				.param("id", "hf_123321")
// 		) .andDo(print()) ;
// 	}
//
// 	@Test
// 	public void contextLoads() {
//
// 	}
//
//
// 	/**
// 	 * 框架的模板生成器测试
// 	 */
// 	@Test
// 	public void ftlTemplateTest() {
// 		// String projectPath = "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//testrusult//";  //通过测试的反斜杠
// 		String projectPath = "F:\\workSpace\\GitWork\\chihuo\\src\\main\\java\\com\\fengyu\\engine\\codecreatorFrame\\templates\\";
// 		String fileName = "areasql.txt";
// 		String savePath = "area";
// 		String templateName = null;
// 		Map map = new HashMap();
// 		ftlTemplatesService.setPath(projectPath);
// 		Template template = ftlTemplatesService.getDirectoryForTemplate(templateName);
// 		ftlTemplatesService.createTemplate(map,projectPath,savePath,fileName,template);
// 	}
//
// 	@Test
// 	public void baseInherit() {
// 		User user = new User();
// 		user.setLoginNum("biubiubibu");
// 		user.setEmail("111223@qq.com");
// 		user.toString();
// 		User user1 = (User) createBase(user);
// 		user.toString();
// 		BaseEntity BaseEntity = createBase(user);
// 		BaseEntity.toString();
// 	}
//
//
//
// 	public BaseEntity createBase (BaseEntity entity) {
// 		return entity;
// 	}
//
// 	@Test
// 	public void decryptDES(){
// 		try {
// 			String content = "/user/all_page_list";
// 			String encryptResult = DesApp.encryptDESWrap(content);
// 			System.out.println(encryptResult);
// 			String decryptResult = DesApp.decryptDESWrap(encryptResult);
// 			System.out.println(decryptResult);
// 			return;
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}
//
// 	@Test
// 	public void decryptDES1(){
// 		try {
// 			String content = "test";
// 			String password = "12345678";
// 			//加密
// 			System.out.println("加密前：" + content);
// 			String encryptResult = DesApp.encryptDES(content, password);
// 			//解密
// 			String decryptResult = DesApp.decryptDES(encryptResult,password);
// 			System.out.println("解密后：" + new String(decryptResult));
// 		} catch (Exception e) {
// 			e.printStackTrace();
// 		}
// 	}
//
//
// }
//
//
// /*
// *spring test测试框架案例*
// *
// @RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("/config/Spring-db1.xml")
// @Transactional
// public class AccountServiceTest1 {
// 	@Autowired
// 	private AccountService service;
//
// 	@Test
// 	public void testGetAcccountById() {
// 		Account acct = Account.getAccount(1, "user01", 18, "M");
// 		service.insertIfNotExist(acct);
// 		Account acct2 = service.getAccountById(1);
// 		assertEquals(acct,acct2);
// 	}
// }*/
