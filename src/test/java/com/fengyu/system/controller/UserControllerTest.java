package com.fengyu.system.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.ChihuoApplication;
import com.fengyu.system.entity.User;
import com.fengyu.system.service.UserService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created by rain on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ChihuoApplication.class)
@MapperScan("com.fengyu.system.dao")
@WebAppConfiguration
public class UserControllerTest {

    Logger logger = Logger.getLogger(UserControllerTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void toPageListJson() throws Exception {
        List<User> users = userService.findAllList();
        logger.info(JSON.toJSON(users));
    }

}