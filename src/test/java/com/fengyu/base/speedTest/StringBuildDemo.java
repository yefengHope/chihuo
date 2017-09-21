package com.fengyu.base.speedTest;

import org.springframework.util.StopWatch;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class StringBuildDemo {


    public static void testNews() {
        StopWatch clock = new StopWatch();
        clock.start();
        String str = null;
        for (int i = 0; i < 10000; i++) {
            str = new StringBuilder().append(str).append("asjdkla").toString();
        }
        clock.stop();
        System.out.println(clock.getTotalTimeMillis());
    }


    public static void testNewOne() {
        StopWatch clock = new StopWatch();
        clock.start();
        StringBuilder sb = new StringBuilder("asjdklb".length() * 10000);
        for (int i = 0; i < 10000; i++) {
            sb.append("asjdklb");
        }
        String str = sb.toString();
        clock.stop();
        System.out.println(clock.getTotalTimeMillis());
    }

    public static void testPlus() {
        StopWatch clock = new StopWatch();
        clock.start();
        String str = "";
        for (int i = 0; i < 10000; i++) {
            str += "asjdklc";
        }
        clock.stop();
        System.out.println(clock.getTotalTimeMillis());
    }

    // public static void main(String[] args) {
    //     testNewOne();
    //     testNews();
    //     testPlus();
    // }

    // public static void main(String[] args) {
    //     String s1 = "Programming";
    //     String s2 = new String("Programming");
    //     String s3 = "Program";
    //     String s4 = "ming";
    //     String s5 = "Program" + "ming";
    //     String s6 = s3 + s4;
    //     System.out.println(s1 == s2);
    //     System.out.println(s1 == s5);
    //     System.out.println(s1 == s6);
    //     System.out.println(s1 == s6.intern());
    //     System.out.println(s2 == s2.intern());
    // }

    /*
    A和B虽然被定义为常量，但是它们都没有马上被赋值。
    在运算出s的值之前，他们何时被赋值，以及被赋予什么样的值，都是个变数。
    因此A和B在被赋值之前，性质类似于一个变量。
    那么s就不能在编译期被确定，而只能在运行时被创建了。
     */
    // public static final String A; // 常量A
    // public static final String B;    // 常量B
    // static {
    //     A = "ab";
    //     B = "cd";
    // }
    // public static void main(String[] args) {
    //     // 将两个常量用+连接对s进行初始化
    //     String s = A + B;
    //     String t = "abcd";
    //     if (s == t) {
    //         System.out.println("s等于t，它们是同一个对象");
    //     } else {
    //         System.out.println("s不等于t，它们不是同一个对象");
    //     }
    // }
    // // s不等于t，它们不是同一个对象


    /*
    A和B都是常量，值是固定的，因此s的值也是固定的，它在类被编译时就已经确定了。
    也就是说：String s=A+B; 等同于：String s="ab"+"cd";
     */
    public static final String A = "ab"; // 常量A
    public static final String B = "cd"; // 常量B
    public static void main(String[] args) {
        String s = A + B;  // 将两个常量用+连接对s进行初始化
        String t = "abcd";
        if (s == t) {
            System.out.println("s等于t，它们是同一个对象");
        } else {
            System.out.println("s不等于t，它们不是同一个对象");
        }
    }
    // s等于t，它们是同一个对象
}
