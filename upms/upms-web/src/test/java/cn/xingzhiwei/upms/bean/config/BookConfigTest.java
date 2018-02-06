package cn.xingzhiwei.upms.bean.config;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by HF on 2018/2/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookConfigTest {

    @Resource
    private BookConfig bookConfig;

    @Test
    public void contextLoads() {
        System.out.println(JSON.toJSONString(bookConfig));
    }


}