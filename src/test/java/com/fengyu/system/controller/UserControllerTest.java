package com.fengyu.system.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.ChihuoApplication;
import com.fengyu.system.entity.UserEntity;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by rain on 2017/3/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ChihuoApplication.class)
public class UserControllerTest {

    Logger logger = Logger.getLogger(UserControllerTest.class);

    @Resource
    private UserService userService;

    @Test
    public void toPageListJson() throws Exception {
        UserEntity userEntity = null;
        List<UserEntity> users = userService.findAllList(userEntity);
        logger.info(JSON.toJSON(users));
    }
    @Test
    public void findAllPageList() throws Exception {
        PageInfo<UserEntity> users = userService.findAllPageList(1,10,new UserEntity());
        logger.info(JSON.toJSON(users));
    }

    // public static void main(String[] args) {
    //     // Pattern pattern = Pattern.compile("^((create)|(update))[A-Z]\\s*");
    //     Pattern pattern = Pattern.compile("^((create)|(update))[A-Z][^\\f\\n\\r\\t\\v]*");
    //     Matcher matcher = pattern.matcher("createName");
    //     System.out.println(matcher.find());
    //     System.out.println(matcher.matches());
    // }
}