package com.fengyu.system.controller.system;

import com.fengyu.system.base.BaseController;
import com.fengyu.system.entity.RoleEntity;
import com.fengyu.system.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by HanFeng on 2017/7/28.
 */
@Controller
@RequestMapping(value = "/admin/role")
public class RoleController extends BaseController {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(RoleController.class);
    }

    @Resource
    private RoleService roleService;

    @RequestMapping(value = "page.htm", method = RequestMethod.GET)
    public String toPage() {
        return "system/role/list";
    }


    @RequestMapping(value = "page_data.json", method = RequestMethod.POST)
    @ResponseBody
    public Map pageJson(Integer pageNumber , Integer pageSize, RoleEntity role) {
        PageInfo<RoleEntity> pageInfo = roleService.findAllPageList(pageNumber,pageSize,role);
        return returnBootTable(true,"查询成功",pageInfo);
    }

    @RequestMapping(value = "to_add.htm", method = RequestMethod.GET)
    public String toAdd() {
        return "system/role/form";
    }

    @RequestMapping(value = "add.htm", method = RequestMethod.POST)
    public Map add() {
        return returnAjax(true,"",null,null);
    }

    @RequestMapping(value = "to_update.htm", method = RequestMethod.GET)
    public String toUpdate() {
        return "system/role/form";
    }

    @RequestMapping(value = "update.htm", method = RequestMethod.POST)
    public Map update(RoleEntity role) {
        roleService.save(role);
        return returnAjax(true,"",null,null);
    }

    @RequestMapping(value = "del_rows.htm", method = RequestMethod.POST)
    @ResponseBody
    public Map delRows() {
        return returnAjax(true,"",null,null);
    }

}
