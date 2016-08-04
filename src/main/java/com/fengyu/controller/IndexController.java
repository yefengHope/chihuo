package com.fengyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/7/17.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping(value = "/index")
    public String index(){
        return "index_simple";
    }
}
