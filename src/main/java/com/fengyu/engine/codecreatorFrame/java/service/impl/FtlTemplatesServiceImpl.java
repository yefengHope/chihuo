package com.fengyu.engine.codecreatorFrame.java.service.impl;

import com.fengyu.engine.codecreator.constants.Constants;
import com.fengyu.engine.codecreatorFrame.java.service.FtlTemplatesService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.hibernate.validator.constraints.NotBlank;
import org.thymeleaf.util.StringUtils;

import javax.validation.constraints.NotNull;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@author hanfeng</p>
 * <p>@date 2016/11/23 17:14 创建日期</p>
 */
public class FtlTemplatesServiceImpl implements FtlTemplatesService {

    private Configuration cfg;  //freemarker配置类

    //FreeMarker的模版文件位置
    private String Path = "F://workSpace//GitWork//chihuo//src//main//java//com//fengyu//util//codecreator//templates";

    /**
     * 初始化FreeMarker配置
     * @throws Exception
     */
    private void init() throws Exception {

        // 创建一个Configuration实例
        cfg = new Configuration();

        // 设置FreeMarker的模版文件位置
        cfg.setDirectoryForTemplateLoading(new File(Path));
    }

    @Override
    public void setPath(String path) {
        this.Path = path;
    }

    @Override
    public Template getDirectoryForTemplate(@NotBlank String templateName) {
        return null;
    }

    @Override
    public Template getDirectoryForTemplate(@NotBlank String path, @NotBlank String templateName) {
        this.Path = path;
        return null;
    }

    @Override
    public void createTemplate(@NotNull Map configMap,@NotBlank String projectPath,@NotBlank String savePath,@NotBlank String fileName,@NotNull Template template) {

        //真实文件名
        String realFileName = projectPath + savePath + fileName;
        //真实保存地址
        String realSavePath = projectPath + "/" + savePath;
        //创建保存地址
        createFile(realSavePath);

        //------------------------ 输出文件 UTF-8 -----------------------------
        try {
            outputTemplate(configMap,template,realFileName,Constants.SYSTEM_ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // File f = new File(this.getClass().getResource("").getPath());
    // System.out.println("获取当前路径:" + f);

    @Override
    public void createTemplates(@NotNull Map configMap,@NotBlank String projectPath,@NotNull List<Map> list) {
        try {
            if (list == null) {
                return;
            }
            for (Map map : list) {
                String savePath = (String) map.get("savePath");
                String fileName = (String) map.get("fileName");
                Template template = (Template) map.get("template");
                if (StringUtils.isEmptyOrWhitespace(savePath) || StringUtils.isEmptyOrWhitespace(fileName) || template == null)
                    continue;
                //真实文件名
                String realFileName = projectPath + savePath + fileName;
                //真实保存地址
                String realSavePath = projectPath + "/" + savePath;
                //创建保存地址
                createFile(realSavePath);

                //------------------------ 输出文件 UTF-8 -----------------------------
                outputTemplate(configMap,template,realFileName,Constants.SYSTEM_ENCODING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getPath() {
        return Path;
    }

    /**
     * 创建File,不存在则新建
     * @param realSavePath
     * @return
     */
    private void createFile(String realSavePath) {
        File newsDir = new File(realSavePath);
        if (!newsDir.exists()) {
            newsDir.mkdirs();
        }
    }

    /**
     * 输出模板生成的文件
     */
    private void outputTemplate (Map configMap ,Template template ,String realFileName , String encode) throws Exception{
        Writer out = new OutputStreamWriter(new FileOutputStream(realFileName), encode);
        template.process(configMap, out);
    }

}
