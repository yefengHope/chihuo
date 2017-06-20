package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.engine.codecreatorFrame.java.config.CodeFactoryConfig;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResult;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResultConvert;
import com.fengyu.engine.codecreatorFrame.java.jdbc.JdbcResultImpl;
import com.fengyu.engine.codecreatorFrame.java.model.FieldModel;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 创建
 * Created by rain on 2017/6/19.
 */
public class MainCreate {
    private static Logger logger = Logger.getLogger(MainCreate.class);

    public static void createFile() {

        // 配置文件
        Map<String, String> config = CodeFactoryConfig.getConfig();
        String templatePackagePath = config.get("template.package.path");

        //  获取配置模块内容
        String[] configModules = TemplateConfig.getTemplateModule();
        JdbcResult jdbcResult = new JdbcResultImpl();
        // 根据配置内容获取数据表结构
        List<Map<String, Object>> dataStructureList = jdbcResult.getTableStructureList();
        // 转换数表结构
        List<FieldModel> fieldModels = JdbcResultConvert.formatColumn(dataStructureList);

        for (int i = 0, im = configModules.length; i < im; i++) {
            String name = configModules[i];
            Map<String, String> configModulAttr = TemplateConfig.getConfigType(name);
            String build = configModulAttr.get("build");
            String fileName = configModulAttr.get("fileName");
            String comment = configModulAttr.get("comment");
            String packagePath = configModulAttr.get("packagePath");
            if ("true".equals(build) && StringUtils.isNotBlank(packagePath)) {
                CreateGeneralTemplate createTemplate = new CreateGeneralTemplate();
                Map<String, Object> fileMap = new HashMap<>();
                Map<String, Object> dataMap = new HashMap<>();
                Map<String, Object> configMap = new HashMap<>();
                if (StringUtils.isBlank(fileName)) {
                    logger.error("模块异常 : 没有文件名");
                    continue;
                }
                configMap.put("fileName", fileName);
                configMap.put("className", fileName);
                configMap.put("author", "hanfeng");
                configMap.put("comment", comment);
                configMap.put("packagePath", packagePath);
                dataMap.put("fieldModels", fieldModels);
                // ftl的数据表内容结构
                fileMap.put("data", dataMap);
                // ftl的配置的文件数据
                fileMap.put("config", configMap);
                switch (name) {
                    case "model" : {
                        fileMap.put("fileName", "javaModel.ftl");
                    } break;
                    case "dao" : {
                        fileMap.put("fileName", "javaDao.ftl");
                    } break;
                    case "service" : {
                        fileMap.put("fileName", "javaService.ftl");
                    } break;
                    case "service.impl" : {
                        fileMap.put("fileName", "javaServiceImpl.ftl");
                    } break;
                    case "controller" : {
                        fileMap.put("fileName", "javaController.ftl");
                    } break;
                    case "mybatis" : {
                        fileMap.put("fileName", "sqlMybatis.ftl");
                    } break;
                    case "html.list" : {
                        fileMap.put("fileName", "htmlList.ftl");
                    } break;
                    case "html.addOrEdit" : {
                        fileMap.put("fileName", "htmlAddOrEditForm.ftl");
                    } break;
                }

                fileMap.put("packagePath", templatePackagePath);
                if (name.contains("html")) {
                    fileMap.put("filePath", packagePath + File.separator + fileName + ".html");
                } else {
                    fileMap.put("filePath", packagePath + File.separator + fileName + ".java");
                }

                createTemplate.doHandle(fileMap);
            } else {
                logger.warn("异常 : build 不等于true or packagePath 为空");
            }
        }
    }

    public static void main(String[] args) {
        createFile();
    }
}
