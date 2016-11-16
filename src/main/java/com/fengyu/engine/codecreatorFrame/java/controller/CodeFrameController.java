package com.fengyu.engine.codecreatorFrame.java.controller;

import com.fengyu.system.service.SpringContextService;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.constraints.NotNull;

/**
 * 代码生成controller
 * Created by rain on 2016/11/16.
 */
@Controller
@RequestMapping(value = "code_frame")
public class CodeFrameController {

    /**
     * 获取spring上下文bean接口
     */
    @Autowired
    private SpringContextService springContextService;

    /**
     * 代码生成器页面
     * @return
     */
    @RequestMapping(value = "to_add",method = RequestMethod.GET)
    public String toAddCodeFrame() {

        return null;
    }

    /**
     * 生成代码
     * @return
     */
    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String addCodeFrame() {

        return null;
    }

    /**
     * 查询bean
     * @param type      查询类型(spring上下文中查询:1,...)
     * @param beanName  bean的name
     * @return
     */
    @RequestMapping(value = "select_bean_name/{type}/{beanName}",method = RequestMethod.GET)
    public String selectBeanName(@NotNull @PathVariable Integer type,@NotBlank @PathVariable String beanName){
        springContextService.getBean(beanName);
        return null;
    }
}
