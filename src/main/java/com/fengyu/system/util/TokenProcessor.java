package com.fengyu.system.util;

/**
 * <p>@Title token生成 </p>
 * <p>@author hanfeng</p>
 * <p>@date 2016/11/3 16:31 创建日期</p>
 */
public class TokenProcessor {

    /**
     * 生成token
     * 获取当前系统纳秒级时间
     * @return
     */
    public static Long createToken() {
        Long timeMillis = System.nanoTime();//纳秒级
        return timeMillis;
    }
}
