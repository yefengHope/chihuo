package com.fengyu.system.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 拦截url
 * Created by rain on 2017/8/20.
 */
@Aspect
public class UrlAccessAspect {

    /*
    before 目标方法执行前执行，前置通知
    after 目标方法执行后执行，后置通知
    after returning 目标方法返回时执行 ，后置返回通知
    after throwing 目标方法抛出异常时执行 异常通知
    around 在目标函数执行中执行，可控制目标函数是否执行，环绕通知
     */

    /*

    .. ：匹配方法定义中的任意数量的参数，此外还匹配类定义中的任意数量包
    ＋ ：匹配给定类的任意子类
    * ：匹配任意数量的字符

      类型签名表达式
      within(<type name>)
        //匹配com.zejian.dao包及其子包中所有类中的所有方法
        @Pointcut("within(com.zejian.dao..*)")
        //匹配UserDaoImpl类中所有方法
        @Pointcut("within(com.zejian.dao.UserDaoImpl)")
        //匹配UserDaoImpl类及其子类中所有方法
        @Pointcut("within(com.zejian.dao.UserDaoImpl+)")
        //匹配所有实现UserDao接口的类的所有方法
        @Pointcut("within(com.zejian.dao.UserDao+)")

        方法签名表达式
        execution(<scope> <return-type> <fully-qualified-class-name>.*(parameters))
        //匹配UserDaoImpl类中的所有公共方法并且返回值为int类型
        @Pointcut("execution(public int com.zejian.dao.UserDaoImpl.*(..))")

        //Spring AOP扩展的
        //匹配名称中带有后缀Service的Bean。
        @Pointcut("bean(*Service)")
        private void myPointcut1(){}

        // 用于匹配当前AOP代理对象类型的执行方法
        //匹配了任意实现了UserDao接口的代理对象的方法进行过滤
        @Pointcut("this(com.zejian.spring.springAop.dao.UserDao)")
        private void myPointcut2(){}

        //匹配了任意实现了UserDao接口的目标对象的方法进行过滤
        @Pointcut("target(com.zejian.spring.springAop.dao.UserDao)")
        private void myPointcut3(){}

        //匹配使用了MarkerAnnotation注解的方法(注意是方法)
        @Pointcut("@annotation(com.zejian.spring.annotation.MarkerAnnotation)")
        private void myPointcut5(){}
     */
    @Pointcut("@annotation(org.springframework.stereotype.Controller)")
    public void urlAccess(){

    }


    @AfterReturning(value = "urlAccess()")
    public void accessUrlAfter(JoinPoint joinPoint) {

    }
}
