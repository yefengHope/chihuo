package com.fengyu.base.polym;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        a.setName("a");

        B b = new B();
        b.setName("b");

        a.sout(a);
        a.sout(b);

        b.sout(a);
        b.sout(b);
    }
}
