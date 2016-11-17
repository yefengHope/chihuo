package com.fengyu.system.controller;

import com.fengyu.system.domain.User;
import com.fengyu.system.model.BootPage;
import com.fengyu.system.service.UserService;
import com.fengyu.util.common.jsonutils.JsonUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Map;

/**
 * 用户controller
 * Created by 韩峰 on 2016/8/15.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 用户列表 list json到页面
     * @return
     */
    @RequestMapping(value = "all_list")
    public String toAllList(){
        for (int i=0;i<=30;i++){
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
        }
        return "system/user/all_list";
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
     * 用户列表,返回json(包含分页查询)
     * @param limit         分页大小
     * @param pageNumber    当前页码
     * @param searchText    搜索文本
     * @param sortOrder     排序方式
     * @param sortName      排序列名
     * @return
     */
    @RequestMapping(value = "all_page_list",method = RequestMethod.POST)
    @ResponseBody
    public String toPageListJson(int limit,int pageNumber,String searchText,String sortOrder,String sortName){
        Pageable pageable = new PageRequest(pageNumber,limit);
        Page<User> page = userService.findAllPageList(pageable);
        BootPage bootPage = new BootPage(limit,pageNumber,searchText,sortOrder,sortName,page);

        //------------------ 测试代码 ------------------Object userName = applicationContext.getBean("user");
        // Map<String,Object> map = applicationContext.getBeansWithAnnotation(Entity.class);
        // System.out.println(map.toString());
        return JsonUtils.toJSONStringConvertNull(bootPage);
    }

    /**
     * 跳转到添加页
     * @return
     */
    @RequestMapping(value = "add_user" ,method = RequestMethod.GET)
    public String toAddUser() {
        return "system/user/add_user";
    }

    /**
     * 添加
     * @param user  用户实体
     * @return
     */
    @RequestMapping(value = "add_user" ,method = RequestMethod.POST)
    public String addUser(User user) {
        return null;
    }

    /**
     * 跳转到更新页
     * @return
     */
    @RequestMapping(value = "update_user" , method = RequestMethod.GET)
    public String toUpdateUser() {

        return null;
    }

    /**
     * 更新
     * @param user  用户实体
     * @return
     */
    @RequestMapping(value = "update_user" , method = RequestMethod.POST)
    public String updateUser(User user) {

        return null;
    }

    /**
     * 删除
     * @param id id
     * @return
     */
    public String delUser(  Long id) {

        return null;
    }

}
