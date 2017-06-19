package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.engine.codecreatorFrame.java.config.CodeFactoryConfig;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>@Title 模板配置 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/19 15:54 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class TemplateConfig implements Serializable{


    private static final long serialVersionUID = 4347308140509715561L;

    private static Map<String,String> config = CodeFactoryConfig.getConfig();

    private static String dirPath;

    private static String[] templateModule;

    static {
        String path = config.get("template.package.path");
        if (StringUtils.isBlank(path)) {
            throw new NullPointerException("template.package.path 变量不存在");
        }
        dirPath = path;

        String module = config.get("template.module");
        if (StringUtils.isBlank(module)) {
            throw new NullPointerException("template.module 变量不存在");
        }
        templateModule = module.split(",");
    }

    public static String[] getTemplateModule() {
        return templateModule;
    }

    /**
     * 配置属性-前缀型
     */
    private static String[] configPrefixAttrs= {"build"};
    /**
     * 配置属性-后缀型
     */
    private static String[] configSuffixAttrs= {"fileName","comment","packagePath"};

    /**
     * 从配置文件获取构建模块配置属性
     * @param name  预备项为: {"dao","service","service.impl","controller","mybatis","html.list","html.addOrEdit"}
     * @return
     * {
     *     build : "构建类型",
     *     fileName : "构建文件名",
     *     comment : "构建注释",
     *     package : "构建路径",
     * }
     */
    private static Map<String,String> getBuildBlock (String name) {

        Map<String,String> map = new HashMap<>();
        for (int i=0,il=configPrefixAttrs.length;i<il;i++) {
            map.put(configPrefixAttrs[i],config.get(configPrefixAttrs[i] + "." + name));
        }

        for (int i=0,il=configSuffixAttrs.length;i<il;i++) {
            map.put(configPrefixAttrs[i],config.get(name + "." + configSuffixAttrs[i]));
        }
        return map;
    }

    /**
     * 获取模块配置内容
     * @param name 预备项为: {"dao","service","service.impl","controller","mybatis","html.list","html.addOrEdit"}
     * @return
     * {
     *     build : "构建类型",
     *     fileName : "构建文件名",
     *     comment : "构建注释",
     *     package : "构建路径",
     * }
     */
    public static Map<String,String> getConfigType(String name) {
        Map<String,String> map = getBuildBlock(name);
        return map;
    }


    public static String getDirPath() {
        return dirPath;
    }

    public static void setDirPath(String dirPath) {
        TemplateConfig.dirPath = dirPath;
    }

}
