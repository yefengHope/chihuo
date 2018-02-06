package cn.xingzhiwei.upms.aop;

import cn.xingzhiwei.common.pojo.annotation.LoginLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 登录日志注解拦截
 * Created by HF on 2018/2/6.
 */
@Component
@Aspect
public class LoginLogAspect {

    @Pointcut("@annotation(cn.xingzhiwei.common.pojo.annotation.LoginLog)")
    public void loginPointcut(){}

    @After("loginPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LoginLog loginLog = method.getAnnotation(LoginLog.class);
        System.out.println("LoginLogAspect.after:" + loginLog.name());
    }


    @Before("loginPointcut()")
    public void Before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        LoginLog loginLog = method.getAnnotation(LoginLog.class);
        System.out.println("LoginLogAspect.Before:" + loginLog.name());
    }

}
