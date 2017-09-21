package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.engine.codecreatorFrame.java.init.*;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * 创建
 * Created by rain on 2017/6/19.
 */
public class MainCreate {
    private static Logger logger = Logger.getLogger(MainCreate.class);

    public static void createFile() {

        AbstractInit init;
        List<String> moduleConfigList = TemplateConfig.getTemplateModule();
        for (String moduleName : moduleConfigList) {
            init = new InitCommon(moduleName);
            init.init();
        }
    }

    /**
     * 包路径转换成文件夹路径
     *
     * @param packagePath
     * @return
     */
    public String packageToDir(String packagePath) {
        if (StringUtils.isBlank(packagePath)) {
            return null;
        }
        String[] packagePaths = packagePath.split(".");
        if (packagePaths.length <= 0) {
            return null;
        }
        return StringUtils.join(packagePaths, File.separator);
    }

    /**
     * 文件夹路径转换成包路径
     *
     * @param dirPath
     * @return
     */
    public String dirToPackagePath(String dirPath) {
        if (StringUtils.isBlank(dirPath)) {
            return null;
        }
        String[] dirPaths = dirPath.split(".");
        if (dirPaths.length <= 0) {
            return null;
        }
        return StringUtils.join(dirPaths, ".");
    }

    public static void main(String[] args) {
        createFile();
        // System.out.println(System.getProperty("user.dir"));
        // try {
        //     Object snacksModel = Class.forName("com.fengyu.engine.codecreatorFrame.file.SnacksModel");
        //     System.out.println(snacksModel);
        // } catch (ClassNotFoundException e) {
        //     e.printStackTrace();
        // }
    }
}
