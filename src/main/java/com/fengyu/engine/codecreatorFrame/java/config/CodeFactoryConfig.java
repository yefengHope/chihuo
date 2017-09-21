package com.fengyu.engine.codecreatorFrame.java.config;

import com.fengyu.util.common.ResourceUtils;

import java.util.Map;

/**
 * 获取代码生成器配置类
 * Created by rain on 2017/6/19.
 */
public abstract class CodeFactoryConfig {

    private static Map<String,String> configProp ;

    static {
        configProp = ResourceUtils.getResource("codeFactoryConfig").getMap();
    }

    public static Map<String,String> getConfig() {
        return configProp;
    }
}
