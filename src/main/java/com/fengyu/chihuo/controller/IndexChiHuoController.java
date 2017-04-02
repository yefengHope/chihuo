package com.fengyu.chihuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rain on 2017/4/2.
 */
@Controller
@RequestMapping(value = "/chihuo")
public class IndexChiHuoController {


    @RequestMapping(value = "/index.html")
    public String toIndex() {
        return "chihuo/index";
    }
    @RequestMapping(value = "/contact.html")
    public String toContact() {
        return "chihuo/contact";
    }

}
