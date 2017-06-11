package com.fengyu.system.controller;

import com.alibaba.fastjson.JSON;
import com.fengyu.ChihuoApplication;
import com.fengyu.system.base.BaseController;
import com.fengyu.system.entity.User;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.PageInfo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
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
@WebAppConfiguration
public class UserControllerTest extends BaseController {

    Logger logger = Logger.getLogger(UserControllerTest.class);

    @Autowired
    private UserService userService;

    @Test
    public void toPageListJson() throws Exception {

        // ======= mybatis集成测试 =======

        List<User> users = userService.findAllList();
        logger.info(JSON.toJSON(users));
        logger.info("=======================================");
        logger.info("=======================================");
        // 分页测试1 预期查询正确
        PageInfo<User> page = userService. findAllPageList(1,10);
        logger.info(JSON.toJSON(page));
        logger.info("=======================================");
        logger.info("=======================================");
        // 分页测试2 预期查询失败
        PageInfo<User> page2 = userService. findAllPageList(0,10);
        logger.info(JSON.toJSON(page2));
        logger.info("=======================================");
        logger.info("=======================================");
        // boottable返回数据测试
        logger.info(JSON.toJSON(returnBootTable(true,"",page)));

        /* 结果输出
        {
            "endRow":10,
            "firstPage":1,
            "hasNextPage":true,
            "hasPreviousPage":false,
            "isFirstPage":true,
            "isLastPage":false,
            "lastPage":4,
            "list":[数据行内容],
            "navigatePages":8,
            "navigatepageNums":Array[4],
            "nextPage":2,
            "pageNum":1,
            "pageSize":10,
            "pages":4,
            "prePage":0,
            "size":10,
            "startRow":1,
            "total":31
        }
         */
    }

}