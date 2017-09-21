package com.fengyu.base.polym;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class A {

    public String name;
    public String num="a";

    public String getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    void sout(A a) {
        System.out.println(a.getName());
    }
}
