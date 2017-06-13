package com.fengyu.engine.codecreatorFrame.java.jdbc;

import com.alibaba.fastjson.JSON;
import com.fengyu.ChihuoApplication;
import com.fengyu.engine.codecreatorFrame.java.model.FieldModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by rain on 2017/6/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChihuoApplication.class)
// @PropertySource("classpath:application-dev.properties")
public class JdbcResultTest {



    @Test
    public void getList() throws Exception {
        // JdbcResult jdbcResult = new JdbcResultImpl();
        // jdbcResult.getList("");
    }

    @Test
    public void getTableStructureList() throws Exception {
        JdbcResult jdbcResult = new JdbcResultImpl();
        List<Map<String, Object>> list = jdbcResult.getTableStructureList();
        System.out.println(JSON.toJSONString(list));
        List<FieldModel> fieldModels = JdbcResultConvert.formatColumn(list);
        System.out.println(JSON.toJSONString(fieldModels));

    }


}