package cn.xingzhiwei.common.pojo.annotation.log;

import java.lang.annotation.*;

/**
 * 登录日志
 * Created by HF on 2018/2/6.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface LoginLog {

    String name();
}
