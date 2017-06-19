package com.fengyu.engine.codecreatorFrame.java.build;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 创建
 * Created by rain on 2017/6/19.
 */
public class MainCreate {

    public void createFile() {
    
        String[] configModules = TemplateConfig.getTemplateModule();
        for (int i=0,im=configModules.length;i<im;i++) {
            String name = configModules[i];
            Map<String, String> configModulAttr = TemplateConfig.getConfigType(name);
            String build = configModulAttr.get("build");
            String fileName = configModulAttr.get("fileName");
            String comment = configModulAttr.get("comment");
            String packagePath = configModulAttr.get("package");
            if ("true".equals(build) && StringUtils.isNotBlank(packagePath)) {
                CreateGeneralTemplate createTemplate = new CreateGeneralTemplate();
                Map<String,Object> dataMap = new HashMap<>();
                // TODO: 2017/6/19 未完成 
                if (StringUtils.isBlank(fileName)) {

                }
                dataMap.put("fileName",fileName);
                dataMap.put("filePath",packagePath);
                createTemplate.doHandle(dataMap);
            }
        }
    }

}
