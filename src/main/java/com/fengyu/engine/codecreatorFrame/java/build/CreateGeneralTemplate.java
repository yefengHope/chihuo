package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.util.common.FileUtils;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.Map;

/**
 * <p>@Title 通用模板生成类 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/19 16:04 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class CreateGeneralTemplate extends AbstractTemplate {

    /**
     * 模板处理之前
     *
     * @return
     */
    public Map doBefore(Map<String, Object> map) {
        return map;
    }

    /**
     * 模板处理,模板生成
     * @param map
     * {
     *     fileName : ftl文件名
     *     filePath : 模板生成文件输出路径
     * }
     * @throws IOException
     */
    public void doHandle(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            throw new NullPointerException();
        }
        String fileName = map.get("fileName") != null ? map.get("fileName").toString() : "";
        if (fileName == null || StringUtils.isBlank(fileName)) {
            throw new NullPointerException("ftl文件名为空");
        }
        String filePath = map.get("filePath") != null ? map.get("filePath").toString() : "";
        if (filePath == null || StringUtils.isBlank(filePath)) {
            throw new NullPointerException("ftl输出文件路径为空");
        }
        Template template = null;
        try {
            template = getTemplate(fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取输出文件路径
        File file = FileUtils.getFile(filePath);
        if (file != null) {
            throw new RuntimeException("文件名已存在");
        }
        file = FileUtils.getFileOrCreate(filePath);

        //step5 初始化一个IO流
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            //step6 模板渲染出所要的内容
            template.process(map, out);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 模板之后
     *
     * @return
     */
    public Map doAfter(Map<String, Object> map) {
        return map;
    }

}