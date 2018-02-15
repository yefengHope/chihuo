package cn.xingzhiwei.common.pojo.annotation;

import java.lang.annotation.*;

/**
 * 全局数据库日志
 * Created by rain on 2018/2/15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@Documented
public @interface GlobalDbLog {

}
