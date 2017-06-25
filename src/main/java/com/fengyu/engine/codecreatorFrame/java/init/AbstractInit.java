package com.fengyu.engine.codecreatorFrame.java.init;

import com.fengyu.engine.codecreatorFrame.java.build.CreateGeneralTemplate;
import com.fengyu.engine.codecreatorFrame.java.build.TemplateConfig;
import com.fengyu.engine.codecreatorFrame.java.config.CodeFactoryConfig;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResult;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResultConvert;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResultImpl;
import com.fengyu.engine.codecreatorFrame.java.model.FieldModel;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HanFeng on 2017/6/24.
 */
public abstract class AbstractInit {


    public abstract void init();

    private static List<Map<String, Object>> dataStructureList ;
    private static List<FieldModel> fieldModels;
    static {
        JdbcResult jdbcResult = new JdbcResultImpl();
        dataStructureList = jdbcResult.getTableStructureList();
        fieldModels = JdbcResultConvert.formatColumn(dataStructureList);
    }


    /**
     * 根据配置内容获取数据表结构
     * @return {List<Map<String, Object>>}
     */
    public List<Map<String, Object>> selectDataStructureList() {
        return dataStructureList;
    }

    /**
     * 转换数表结构
     * @param list 查询出来的数据库的表结构
     * @return {List<FieldModel>}
     */
    public List<FieldModel> selectFieldModels (List<Map<String, Object>> list){
        return fieldModels;
    }

    /**
     * 转换数表结构
     * <p>已经内部查询数据库表结构
     * @return {List<FieldModel>}
     */
    public List<FieldModel> selectFieldModels (){
        List<Map<String, Object>> list = selectDataStructureList();
        List<FieldModel> fieldModels = JdbcResultConvert.formatColumn(list);
        return fieldModels;
    }

    /**
     * 根据模块名称匹配模块使用的ftl文件
     */
    public String matchFtl(String name){
        String matchStr = null;
        switch (name) {
            case "model" : {
                matchStr = "javaModel.ftl";
            } break;
            case "dao" : {
                matchStr = "javaDao.ftl";
            } break;
            case "service" : {
                matchStr =  "javaService.ftl";
            } break;
            case "service.impl" : {
                matchStr = "javaServiceImpl.ftl";
            } break;
            case "controller" : {
                matchStr = "javaController.ftl";
            } break;
            case "mybatis" : {
                matchStr = "sqlMybatis.ftl";
            } break;
            case "html.list" : {
                matchStr = "htmlList.ftl";
            } break;
            case "html.addOrEdit" : {
                matchStr = "htmlAddOrEditForm.ftl";
            } break;

            default: {
                throw new RuntimeException("未找到对应的模板");
            }
        }
        return matchStr;
    }

    /**
     * 默认初始化方法
     * @param name  模块名称
     */
    public void defaultInit(String name){
        Map<String, String> configModulAttr = TemplateConfig.getConfigType(name);

        String build = configModulAttr.get("build");
        String fileName = configModulAttr.get("fileName");
        String comment = configModulAttr.get("comment");
        String packagePath = configModulAttr.get("packagePath");

        // 如果配置为true且包路径不为空，则生成模块内容
        if ("true".equals(build) && StringUtils.isNotBlank(packagePath)) {
            CreateGeneralTemplate createTemplate = new CreateGeneralTemplate();
            Map<String, Object> fileMap = new HashMap<>();
            Map<String, Object> dataMap = new HashMap<>();
            Map<String, Object> configMap = new HashMap<>();
            if (StringUtils.isBlank(fileName)) {
                throw new RuntimeException("模块异常 : 没有文件名");
            }
            configMap.put("fileName", fileName);
            configMap.put("className", fileName);
            configMap.put("author", "hanfeng");
            configMap.put("comment", comment);
            configMap.put("packagePath", packagePath);
            dataMap.put("fieldModels", selectFieldModels());
            // ftl的数据表内容结构
            fileMap.put("data", dataMap);
            // ftl的配置的文件数据
            fileMap.put("config", configMap);
            fileMap.put("fileName", matchFtl(name));
            // 配置文件
            Map<String, String> config = CodeFactoryConfig.getConfig();
            String templatePackagePath = config.get("template.package.path");

            //  获取配置模块内容
            // String[] configModules = TemplateConfig.getTemplateModule();

            fileMap.put("templatePackagePath", templatePackagePath);
            fileMap.put("filePath", System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + packagePath.replace(".",File.separator) + File.separator + fileName + configModulAttr.get("fileType"));

            createTemplate.doHandle(fileMap);
        } else {
            throw new RuntimeException("异常 : build 不等于true or packagePath 为空");
        }
    }
}
