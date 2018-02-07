package cn.xingzhiwei.upms.controller;

import cn.xingzhiwei.common.pojo.annotation.LoginLog;
import cn.xingzhiwei.common.pojo.annotation.ParamsLog;
import cn.xingzhiwei.common.pojo.enumm.LogType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HF on 2018/2/6.
 */
@Controller
public class LoginController {

    @RequestMapping(value = {"","/","/index"})
    @LoginLog(name = "首页登录拦截")
    @ResponseBody
    public String index() {

        return "index";
    }

    @RequestMapping(value = {"index2"})
    @LoginLog(name = "首页登录拦截")
    @ResponseBody
    public Object index2(@ParamsLog(name = "index",type = LogType.AFTER) String index, @ParamsLog(name = "index2",type = LogType.BEFORE)String index2) {

        return index;
    }
}
