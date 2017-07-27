package com.fengyu.system.controller;

import com.fengyu.system.base.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by HanFeng on 2017/7/25.
 */
@Controller
public class LoginController extends BaseController {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(LoginController.class);
    }

    @RequestMapping(value="toLogin.htm",method = RequestMethod.GET)
    public String toLogin() {
        return "system/login";
    }

    @RequestMapping(value="login.htm")
    @ResponseBody
    public Map login() {
        return returnAjax(true, "登录成功", null, null);
    }

    @RequestMapping(value = "loginOut.htm",method = RequestMethod.GET)
    @ResponseBody
    public Map loginOut(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return returnAjax(true, "退出成功", null, null);
    }

    @RequestMapping(value = "isLogin.htm",method = RequestMethod.GET)
    @ResponseBody
    public Map isLogin() {
        return returnAjax(true, "目前在线", null, null);
    }

    @RequestMapping(value = "loginTimeout.htm",method = RequestMethod.GET)
    public String loginTimeout() {
        return "system/lockScreen";
    }

    @RequestMapping(value="toRegister.htm",method = RequestMethod.GET)
    public String toRegister() {
        return "system/register";
    }

    @RequestMapping(value="register.htm",method = RequestMethod.POST)
    @ResponseBody
    public Map register() {
        return returnAjax(true, "注册成功", null, null);
    }
}
