package cn.xingzhiwei.common.pojo.annotation;

import java.lang.annotation.*;

/**
 * 业务日志
 * Created by HF on 2018/2/5.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface BusLog {

    /**
     * 日志名称
     * 添加,修改,删除
     */
    String name();



}
