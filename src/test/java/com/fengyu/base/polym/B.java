package com.fengyu.base.polym;

/**
 * Created by HanFeng on 2017/9/8.
 */
public class B extends A {

    public String name;

    public String num="b";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    void sout(A a) {
        System.out.println(a.getName());
    }

    public String getNum() {
        return num;
    }
}
