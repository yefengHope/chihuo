package com.fengyu.engine.codecreatorFrame.java.build;

import com.fengyu.engine.codecreatorFrame.java.config.CodeFactoryConfig;
import com.fengyu.engine.codecreatorFrame.java.init.*;
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

        AbstractInit init ;
        init = new InitModel();
        init.init();

        init = new InitDao();
        init.init();

        init = new InitService();
        init.init();

        init = new InitServiceImpl();
        init.init();

        init = new InitController();
        init.init();

        init = new InitMapper();
        init.init();

        init = new InitHtmlList();
        init.init();

        init = new InitHtmlForm();
        init.init();


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
