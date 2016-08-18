package com.fengyu.system.controller;

import com.fengyu.system.domain.User;
import com.fengyu.system.model.BootPage;
import com.fengyu.system.service.UserService;
import com.fengyu.util.common.jsonutils.JsonUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    /**
     * 用户列表 list json到页面
     * @return
     */
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

    /**
     * 用户列表
     *  bootstrap table server方式
     *      bootstrap table调用toPageListJson生成json传回页面
     * @return
     */
    @RequestMapping(value = "all_page_list",method = RequestMethod.GET)
    public String toPageList(){
        return "system/user/all_page";
    }

    /**
     * 用户列表 - 分页查询1
     * @param bootPage  分页
     * @return
     */
    @RequestMapping(value = "all_page_list",method = RequestMethod.POST)
    @ResponseBody
    public String toPageListJson(BootPage bootPage){

        Pageable pageable = new PageRequest(bootPage.getPageNumber(),bootPage.getLimit());
        Page<User> page = userService.findAllPageList(pageable);
        if ( page.getSize()>0 ) {
            bootPage.setRows(page.getContent());
            bootPage.setTotal(page.getTotalElements());
        }
        return JsonUtils.toJSONStringConvertNull(bootPage);
    }

    /**
     * 用户列表 - 分页2
     * 不推荐此种方式
     * 因pageable无法接受bootstrap上传的参数 主要是pageSize,pageNumber获取失败
     * @param searchText
     * @param pageable
     * @return
     */
    @RequestMapping(value = "all_page_list_parms",method = RequestMethod.POST)
    @ResponseBody
    public String toPageListJsonParms(String searchText,Pageable pageable){
        Page<User> page = userService.findAllPageList(pageable);
        BootPage<User> bootPage = new BootPage<>();
        if ( page.getSize()>0 ) {
            bootPage.setRows(page.getContent());
            bootPage.setTotal(page.getTotalElements());
        }
        return JsonUtils.toJSONStringConvertNull(bootPage);
    }
}
