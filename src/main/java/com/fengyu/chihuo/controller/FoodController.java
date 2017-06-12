package com.fengyu.chihuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 美食controller
 * Created by rain on 2017/3/26.
 */
@Controller
@RequestMapping(value = "/food")
public class FoodController  {

    @RequestMapping(value = "toAddForm.html")
    public ModelAndView toAddForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chihuo/food/addFoodForm");
        return mv;
    }
}
