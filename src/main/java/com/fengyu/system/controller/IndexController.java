package com.fengyu.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.TreeMap;

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
    public void forwardTest (HttpServletRequest request, HttpServletResponse response, Model model) {
        try {
//            request.getRequestDispatcher("/user/all_page_list1111").forward(request, response);
            request.getRequestDispatcher("/user/all_page_list1111").forward(request,response);
//            System.out.println(String.valueOf(requestDispatcher));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 异常页面控制
     * <p>说明:当这个Controller中任何一个方法发生异常，一定会被这个方法拦截到</p>
     * @param exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String,Object> runtimeExceptionHandler(Exception exception) {
        Map model = new TreeMap();
        model.put("status", false);
        return model;
    }
}
