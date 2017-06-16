package com.fengyu.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/14 9:34 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class LambdaDemo {

    /*
        lambda表达式替换匿名类，而实现Runnable接口是匿名类的最好示例。
        看一下Java 8之前的runnable实现方法，需要4行代码，
        而使用lambda表达式只需要一行代码。我们在这里做了什么呢？
        那就是用() -> {}代码块替代了整个匿名类。
     */

    // Java 8之前：
    public void anonymityRunnable() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Before Java8, too much code for too little to do");
            }
        }).start();
    }


    //Java 8方式：
    public void lambdaRunnable() {
        new Thread(
                () -> System.out.println("In Java8, Lambda expression rocks !!")
        ).start();
    }

    /*
        lambda语法 :
            (params) -> expression
            (params) -> statement
            (params) -> { statements }

        你的方法接收两个参数，那么可以写成如下这样 ：
            (int even, int odd) -> even + odd
     */
    
    
    // ------------------ 例2、使用Java 8 lambda表达式进行事件处理 - 分割线 ------------------
    public void oldListener() {
        // Java 8之前：
        JButton show =  new JButton("Show");
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Event handling without lambda expression is boring");
            }
        });
    }

    public void lambdaListener() {
        // Java 8方式：
        JButton show =  new JButton("Show");
        show.addActionListener((e) -> {
            System.out.println("Light, Camera, Action !! Lambda expressions Rocks");
        });
    }
    
    //------------------ 例3、使用lambda表达式对列表进行迭代 - 分割线 ------------------
    public void oldForeachList(){
        // Java 8之前：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }
    }
    public void lambdaForeachList() {
        // Java 8之后：
        List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features.forEach(n -> System.out.println(n));

        System.out.println("-------");

        // 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
        // 看起来像C++的作用域解析运算符
        features.forEach(System.out::println);
    }

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();
        lambdaDemo.lambdaForeachList();
    }
}
