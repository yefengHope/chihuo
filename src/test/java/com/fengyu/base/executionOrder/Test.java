package com.fengyu.base.executionOrder;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class Test {

    public static void main(String[] args) {
        // A ab = new B();
        // ab = new B();
        // String abc = "abcdefg";
        assert true;
        assert false : "错误的！";
        System.out.println("断言错误的，Go！");
    }
}
