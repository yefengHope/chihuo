package com.fengyu.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.fengyu.system.dao.RoleMapper;
import com.fengyu.system.entity.RoleEntity;
import com.fengyu.system.entity.UserEntityCopy;
import com.fengyu.system.service.SpringContextService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HanFeng on 2017/8/31.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringContextServiceImplTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void getBean() throws Exception {
    }

    @Test
    public void getBeans() throws Exception {
        List<Object> list = new ArrayList<>();
        System.out.println(list.toString());
    }

    @Test
    public void getBeanByName() throws Exception {
        Object objectRoot = webApplicationContext.getBean("UserEntityCopy");
        Object objectMvc = applicationContext.getBean(UserEntityCopy.class);
        System.out.println(JSON.toJSONString(objectRoot));
        System.out.println(JSON.toJSONString(objectMvc));
    }

    @Test
    public void containsBean() throws Exception {
    }

    @Test
    public void isSingleton() throws Exception {
    }

}