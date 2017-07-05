package com.fengyu.demo.demoSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/*
 * Created by HanFeng on 2017/7/1.
 */
public class ApplicationContextDemo {

    /*
         * 问什么要写中文注释，因为你不懂英文
         * 所以要不要去学习呢
         */


    /**
     * 从文件系统下加载一个或多个xml配置文件中加载上下文定义
     */
    private ApplicationContext fileSystemXmlApplicationContext
            = new FileSystemXmlApplicationContext("C:\\WorkSpace\\chihuo\\src\\main\\resources\\test.xml");

    /**
     * 从所有的类路径下的一个或多个xml配置文件中加载上下文定义，把应用上下文的定义文件作为类资源
     *
     * ps ： 测试的时候发现放在类路径下报异常
     */
    private ApplicationContext classPathXmlApplicationContext =
            new ClassPathXmlApplicationContext("test.xml");

    /**
     * 从web应用下的一个活多个xml配置文件中加载上下文定义
     */
    private ApplicationContext xml = new XmlWebApplicationContext();

    /**
     * 从一个或多个给予java的配置类中加载spring应用上下文
     */
    private ApplicationContext annotation = new AnnotationConfigApplicationContext();

    /**
     * 从一个或多个给予java的配置类中加载spring web应用上下文
     */
    private ApplicationContext annotationWeb = new AnnotationConfigWebApplicationContext();



    // public static void main(String[] args) {
    //     ApplicationContextDemo demo = new ApplicationContextDemo();
    //     System.out.println(demo.fileSystemXmlApplicationContext);
    //     System.out.println(demo.classPathXmlApplicationContext);
    // }

}
