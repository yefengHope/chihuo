package com.fengyu.system.controller;

import com.fengyu.system.domain.User;
import com.fengyu.system.model.BootPage;
import com.fengyu.system.service.UserService;
import com.fengyu.util.common.jsonutils.JsonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by 韩峰 on 2016/8/15.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "all_list")
    public String toAllList(){
        /*for (int i=0;i<=30;i++){
            User user = new User();
            user.setName("test"+i);
            user.setStatus(1);
            user.setEmail("213213213@qq.com");
            user.setLoginNum("test"+i+i);
            user.setLoginPwd("test");
            user.setPhone(13438336891L);
            user.setCreateId(1L);
            user.setCreateName("超级管理员");
            user.setCreateDate(new Date());
            user.setUpdateDate(new Date());
            user.setUpdateId(1L);
            user.setUpdateName("超级管理员");
            userService.save(user);
        }*/
        return "system/user/all_list";
    }

    @RequestMapping(value = "all_list_json")
    @ResponseBody
    public String toAllListJson(){
        List<User> list = userService.findAllList();
        BootPage<User> bootPage = new BootPage<>();
        bootPage.setLimit(10);
        bootPage.setRows(list);
        bootPage.setOrder("desc");
        return JsonUtils.toJSONStringConvertNull(list);
    }

    @RequestMapping(value = "all_page_list")
    @ResponseBody
    public String toPageList(Pageable pageable){
        Page<User> page = userService.findAllPageList(pageable);
        return JsonUtils.toJSONStringConvertNull(page);
    }
}
