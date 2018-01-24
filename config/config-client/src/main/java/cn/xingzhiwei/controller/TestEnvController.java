package cn.xingzhiwei.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HF on 2018/1/24.
 */
@RefreshScope
@RestController
public class TestEnvController {

    @Value("${from}")
    public String from;

    @RequestMapping(value = "/test/env/property")
    public JSONObject testProperty() {
        JSONObject json = new JSONObject();
        json.put("from", from);
        return json;
    }

}
