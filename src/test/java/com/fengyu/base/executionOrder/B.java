package com.fengyu.base.executionOrder;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class B extends A{
    static {
        System.out.print("a");
    }

    public B() {
        System.out.print("b");
    }
}
