package cn.xingzhiwei.common.pojo.annotation;

import cn.xingzhiwei.common.pojo.enumm.LogType;

import java.lang.annotation.*;

/**
 * 参数日志
 * 适用于业务日志
 * Created by HF on 2018/2/7.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface ParamsLog {

    /**
     * 参数名称
     */
    String name();

    /**
     * 参数类型
     * 改变之前参数类型: before
     * 改变后参数类型 : after
     */
    LogType type();
}
