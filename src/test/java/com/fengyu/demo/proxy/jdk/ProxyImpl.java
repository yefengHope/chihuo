package com.fengyu.demo.proxy.jdk;

/**
 * Created by rain on 2017/8/19.
 */
public class ProxyImpl implements ProxyInterface {
    @Override
    public void sout() {
        System.out.println("这是源");
    }
}
