package com.fengyu.system.service;

import com.alibaba.fastjson.JSON;
import com.fengyu.ChihuoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by HanFeng on 2017/7/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest()
public class RoleServiceTest {

    @Resource
    private RoleService roleService;

    @Test
    public void getRoles() throws Exception {
        List list = roleService.getRoles("1");
        System.out.println(JSON.toJSON(list));
    }

}