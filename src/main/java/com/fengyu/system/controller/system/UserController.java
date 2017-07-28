package com.fengyu.system.controller.system;

import com.fengyu.system.base.BaseController;
import com.fengyu.system.entity.UserEntity;
import com.fengyu.system.entity.UserExtendSecurity;
import com.fengyu.system.service.UserService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 用户controller
 * Created by 韩峰 on 2016/8/15.
 */
@Controller
@RequestMapping(value = "/admin/user")
public class UserController extends BaseController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @Resource
    private ApplicationContext applicationContext;

    // /**
    //  * 用户列表 list json到页面
    //  * @return
    //  */
    // @RequestMapping(value = "all_list")
    // public String toAllList(){
    //     for (int i=0;i<=30;i++){
    //         User user = new User();
    //         user.setName("test"+i);
    //         user.setStatus(1);
    //         user.setEmail("213213213@qq.com");
    //         user.setLoginNum("test"+i+i);
    //         user.setLoginPwd("test");
    //         user.setPhone(13438336891L);
    //         user.setCreateId(1L);
    //         user.setCreateName("超级管理员");
    //         user.setCreateDate(new Date());
    //         user.setUpdateDate(new Date());
    //         user.setUpdateId(1L);
    //         user.setUpdateName("超级管理员");
    //         userService.save(user);
    //     }
    //     return "system/user/all_list";
    // }

    /**
     * 用户列表
     * bootstrap table server方式
     * bootstrap table调用toPageListJson生成json传回页面
     *
     * @return
     */
    // @FormToken(needSaveToken = true)
    @RequestMapping(value = "/page.htm", method = RequestMethod.GET)
    // @PreAuthorize("hasAnyRole('admin', 'user')")
    public String toPageList(String name, String id) {
        logger.debug("访问列表参数输出： id:" + id + "   ,name:" + name);
        return "system/user/list_bootstrap";
        // return "system/user/list";
    }

    /**
     * 用户列表,返回json(包含分页查询)
     *
     * @param pageSize   分页大小
     * @param pageNumber 当前页码
     * @param searchText 搜索文本
     * @param sortOrder  排序方式
     * @param sortName   排序列名
     * @return
     */
    @RequestMapping(value = "page_data.json", method = RequestMethod.POST)
    @ResponseBody
    public Map toPageListJson(int pageSize, int pageNumber, String searchText, String sortOrder, String sortName) {

        UserExtendSecurity userDetails
                = (UserExtendSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        PageInfo<UserEntity> page = userService.findAllPageList(pageNumber, pageSize);
        return returnBootTable(true, "查询成功", page);

        //------------------ 测试代码 ------------------
        // Object userName = applicationContext.getBean("user");
        // Map<String,Object> map = applicationContext.getBeansWithAnnotation(Entity.class);
        // System.out.println(map.toString());
        // return JsonUtils.toJSONStringConvertNull(bootPage);
    }

    /**
     * 跳转到添加页
     *
     * @return
     */
    @RequestMapping(value = "to_add.htm", method = RequestMethod.GET)
    public String toAddUser() {
        return "system/user/add_user";
    }

    /**
     * 添加
     *
     * @param user 用户实体
     * @return
     */
    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public String addUser(UserEntity user) {
        UserDetails userDetails
                = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return null;
    }

    /**
     * 跳转到更新页
     *
     * @return
     */
    @RequestMapping(value = "to_update.htm", method = RequestMethod.GET)
    public String toUpdateUser() {

        return null;
    }

    /**
     * 更新
     *
     * @param user 用户实体
     * @return
     */
    @RequestMapping(value = "update.htm", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(UserEntity user) {

        return null;
    }

    /**
     * 删除
     * @param ids ids
     * @return
     */
    @RequestMapping(value = "del_rows.htm", method = RequestMethod.POST)
    @ResponseBody
    public String delUser(String ids) {

        return null;
    }

}
