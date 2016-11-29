package com.fengyu.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016/7/17.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "/")
    public String indexVoid(HttpServletRequest request){
        return "index_simple";
    }

    @RequestMapping(value = "/index")
    public String index2(){
        return "index";
    }

    @RequestMapping(value = "/index_v3")
    public String index3(){
        return "index_v3";
    }

    @RequestMapping(value = "/layouts")
    public String layouts(){
        return "layouts";
    }

    @RequestMapping(value = "/api_access/redirect")
    public String redirectTest(String name, String id) {
        return "redirect:/user/all_page_list";
    }

    @RequestMapping(value = "/api_access/forward")
    public String forwardTest () {
        return "forward:/user/all_page_list";
    }
}
