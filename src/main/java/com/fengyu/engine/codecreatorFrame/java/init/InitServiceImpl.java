package com.fengyu.engine.codecreatorFrame.java.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 生成model文件
 * Created by HanFeng on 2017/6/24.
 */
public class InitServiceImpl extends AbstractInit {

    private static Logger logger = LoggerFactory.getLogger(InitServiceImpl.class);
    /**
     * 模块配置名称
     */
    private final String modulName = "service.impl";

    @Override
    public void init() {
        String name = modulName;
        defaultInit(name);
    }
}