package com.fengyu.system.controller;

import com.fengyu.util.common.CommonPath;
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
    public String index(){
        return "index_simple";
    }
}
