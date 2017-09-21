package com.fengyu.base.synchronize.methodBlock;

/**
 * Created by HanFeng on 2017/9/15.
 */
public class Sout {

    public static synchronized void customSout() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("thread name : 【%s】 ,cur number :  【%d】\n", Thread.currentThread().getName(), i);
        }
    }
}
