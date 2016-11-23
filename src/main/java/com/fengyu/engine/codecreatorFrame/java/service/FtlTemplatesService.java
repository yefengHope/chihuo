package com.fengyu.engine.codecreatorFrame.java.service;

import freemarker.template.Template;

import java.util.List;
import java.util.Map;

/**
 * <p>@Title freemarker模板service </p>
 * <p>@author hanfeng</p>
 * <p>@date 2016/11/23 17:02 创建日期</p>
 */
public interface FtlTemplatesService {

    /**
     * 设置模板存在路径
     * @param path
     */
    void setPath(String path);

    /**
     * 获取默认模板
     * @param templateName  模板名
     * @return
     */
    Template getDirectoryForTemplate(String templateName);

    /**
     * 获取模板,并重新设置默认模板位置
     * @param path          模板存放文件夹
     * @param templateName  模板名
     * @return
     */
    Template getDirectoryForTemplate(String path,String templateName);

    /**
     * 生成模板
     * @param configMap     模板中需要的配置项
     * @param projectPath   项目路径
     * @param savePath      模板生成文件保存路径
     * @param fileName      模板生成的文件名
     * @param template      模板
     */
    void createTemplate(Map configMap,String projectPath, String savePath ,String fileName, Template template);

    /**
     * 生成多个模板
     * @param configMap     模板中需要的配置项
     * @param projectPath   项目路径
     * @param list          批量模板信息
     *                      map : {"savePath":模板生成文件保存路径,"fileName":模板生成的文件名,"template":模板,}
     */
    void createTemplates(Map configMap,String projectPath,List<Map> list);
}
