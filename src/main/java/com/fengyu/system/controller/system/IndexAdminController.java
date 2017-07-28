package com.fengyu.system.controller.system;

import com.fengyu.system.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by HanFeng on 2017/7/28.
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexAdminController extends BaseController {

    @RequestMapping(value = "/index.htm")
    public String index(){
        return "index.admin";
    }

}
