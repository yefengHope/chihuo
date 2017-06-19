package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.util.common.ResourceUtils;
import org.apache.commons.lang.StringUtils;

import java.io.Serializable;

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

    private static final long serialVersionUID = 7618291660430641152L;

    private static String dirPath;

    static {
        String path = ResourceUtils.getResource("codeFactoryConfig").getMap().get("template.package.path");
        if (StringUtils.isBlank(path)) {
            throw new NullPointerException("template.package.path 变量不存在");
        }
        dirPath = path;
    }

    public static String getDirPath() {
        return dirPath;
    }

    public static void setDirPath(String dirPath) {
        TemplateConfig.dirPath = dirPath;
    }

}
