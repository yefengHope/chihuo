package com.fengyu.system.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by HanFeng on 2017/9/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SystemMenuServiceTest {
    @Resource
    private SystemMenuService systemMenuService;

    @Test
    public void selectByIds() throws Exception {

        systemMenuService.selectByIds(null);
    }

}