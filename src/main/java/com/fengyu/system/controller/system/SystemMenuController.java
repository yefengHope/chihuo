

package com.fengyu.system.controller.system;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fengyu.system.base.BaseController;
import com.fengyu.system.base.BaseEntity;
import com.fengyu.system.entity.SystemMenuEntity;
import com.fengyu.system.service.SystemMenuService;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
* 自动生成代码
* Created by HF on 2017-8-8 22:26:54.
*/
@Controller
@RequestMapping(value = "/admin/system/menu")
public class SystemMenuController extends BaseController {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(SystemMenuController.class);
    }

    @Resource
    private SystemMenuService systemMenuService;

    /**
    * 列表
    * bootstrap table server方式
    * bootstrap table调用toPageListJson生成json传回页面
    *
    * @return {String} 页面路径
    */
    @RequestMapping(value = "page.htm", method = RequestMethod.GET)
        public String toPage() {
        return "system/menu/list";
    }

    /**
    * 列表,返回json(包含分页查询)
    *
    * @param pageSize   分页大小
    * @param pageNumber 当前页码
    * @param systemMenuEntity 查询参数
    * @return {Map} 返回Map结果
    */
    @RequestMapping(value = "page_data.json", method = RequestMethod.POST)
    @ResponseBody
    public Map pageJson(Integer pageNumber , Integer pageSize, SystemMenuEntity systemMenuEntity) {
    PageInfo<SystemMenuEntity> pageInfo = systemMenuService.findAllPageList(pageNumber,pageSize,systemMenuEntity);
        return returnBootTable(true,"查询成功",pageInfo);
    }

    /**
    * 跳转到添加页
    *
    * @return {String} 页面路径
    */
    @RequestMapping(value = "to_add.htm", method = RequestMethod.GET)
    public String toAdd(Model model) {
        SystemMenuEntity systemMenuEntity = (SystemMenuEntity) createObjFromClass(SystemMenuEntity.class);
        model.addAttribute("dataEntity", JSON.toJSONString(systemMenuEntity, SerializerFeature.WriteMapNullValue));
        return "system/menu/form";
    }

    /**
    * 添加
    *
    * @param systemMenuEntity 实体
    * @return {Map} 返回Map结果
    */
    @RequestMapping(value = "add.do", method = RequestMethod.POST)
    @ResponseBody
    public Map add(SystemMenuEntity systemMenuEntity) {
        if (systemMenuEntity != null && null == systemMenuEntity.getId() ){
            try {
                BaseEntity.setCreateAndUpdateUser(systemMenuEntity);
                systemMenuService.save(systemMenuEntity);
                return returnAjax(true,"保存成功",null,null);
            } catch (Exception e) {
                logger.error("新增异常",e);
                return returnAjax(false,e.getMessage(),null,null);
            }
        } else {
            logger.error("新增，参数不存在或者参数存在id");
            return returnAjax(false,"参数异常",null,null);
        }
    }

    /**
    * 跳转到更新页
    *
    * @return {String} 页面路径
    */
    @RequestMapping(value = "to_update.htm", method = RequestMethod.GET)
    public String toUpdate(Model model,SystemMenuEntity systemMenuEntity) {
        SystemMenuEntity systemMenuEntityOne = systemMenuService.findOne(systemMenuEntity);
        model.addAttribute("dataEntity", JSON.toJSONString(systemMenuEntityOne, SerializerFeature.WriteMapNullValue));
        return "system/menu/form";
    }

    @RequestMapping(value = "update.do", method = RequestMethod.POST)
    @ResponseBody
    public Map update(SystemMenuEntity systemMenuEntity) {
        if (systemMenuEntity != null && null != systemMenuEntity.getId()){
            try {
                BaseEntity.setUpdateUser(systemMenuEntity);
                systemMenuService.update(systemMenuEntity);
                return returnAjax(true,"保存成功",null,null);
            } catch (Exception e) {
                logger.error("修改基础数据异常",e);
                return returnAjax(false,"修改基础数据异常",null,null);
            }
        } else {
            logger.error("修改基础数据，参数不存在或者参数存在id");
            return returnAjax(false,"参数异常",null,null);
        }
    }

    /**
    * 批量更新状态
    * @param ids       id字符串， 1,2,3,...形式
    * @param status    状态代码
    * @return
    */
    @RequestMapping(value = "batch_update_state.do", method = RequestMethod.POST)
    @ResponseBody
    public Map delRows(String ids,String status) {
        try {
            systemMenuService.batchUpdateState(ids,status);
            return returnAjax(true,"更新成功",null,null);
        } catch (Exception e) {
            logger.error("批量更新异常",e);
        }
        return returnAjax(false,"批量更新异常",null,null);
    }

}


