package com.fengyu.system.controller;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/2/10 11:14 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
@Controller
public class DemoController {

    @RequestMapping(value = "demo/bootstrap-validate")
    public String toBootStrapValidte() {
        return "demo/bootstrap-validate";
    }

    String [] name = {"及时雨","黑旋风","浪子","玉麒麟","母大虫","豹子头","青面兽"};
    int chat_index = 1;

    /**
     * 聊天室系统
     * @return
     */
    @RequestMapping(value = "demo/websocket/to_chat.htm")
    public ModelAndView toChat() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("demo/websocket/chat");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",chat_index ++ );
        // 随机中文名称
        int index = RandomUtils.nextInt(6);
        map.put("name",name[index]);
        mv.addObject("user",map);
        return mv;
    }
}
