package com.fengyu.chihuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 口味controller
 * Created by rain on 2017/3/26.
 */
@RequestMapping(value = "/taste")
@Controller
public class TasteController {

    @RequestMapping(value = "/toAddForm")
    public ModelAndView toAddForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("chihuo/taste/tasteEvaluationForm");
        return mv;
    }
}
