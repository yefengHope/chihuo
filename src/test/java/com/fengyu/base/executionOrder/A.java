package com.fengyu.base.executionOrder;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class A {
    static {
        System.out.print("1");
    }

    public A() {
        System.out.print("2");
    }

}
