package com.fengyu.system.controller;

import com.fengyu.ChihuoApplication;
import com.fengyu.system.controller.system.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * Created by rain on 2017/8/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChihuoApplication.class)
public class DemoControllerTest {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(DemoControllerTest.class);
    }

    @Test
    public void findAllPageList() throws Exception {
       /* // 1. controller mvc test
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/demo/hello"))
　　　　.andExpect(MockMvcResultMatchers.handler().handlerType(DemoController.class))
　　　　.andExpect(MockMvcResultMatchers.handler().methodName("helloWorld"))
　　　　.andExpect(MockMvcResultMatchers.view().name("demo/hello"))
　　　　.andExpect(MockMvcResultMatchers.model().attributeExists("msg"))
　　　　.andExpect(MockMvcResultMatchers.status().isOk())
　　　　.andDo(MockMvcResultHandlers.print())
　　　　.andReturn();
        Assert.assertNotNull(result.getModelAndView().getModel().get("msg"));

        // 2. demo service stub test
        String stub = "except result";
        Mockito.when(demoService.demoShow()).thenReturn(stub);
        Assert.assertEquals(stub, demoService.demoShow());
        Mockito.verify(demoService).demoShow();*/

        UserController controller = new UserController();
        // 搭建MockMvc
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        mockMvc.perform(MockMvcRequestBuilders.get("/admin/user/page.htm")) // 访问路径
                .andExpect(MockMvcResultMatchers.view().name("system/user/list")); // 是否预期的视图名称
    }
}
