package com.fengyu.demo.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created by rain on 2017/8/19.
 */
public class ProxyTest {

    public static void main(String[] args) {
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(ProxyParent.class);
        en.setCallback(new ProxyClass());
        //生成代理实例
        Object proxyObj = en.create();
        ProxyParent proxy = (ProxyParent) proxyObj;
        proxy.sout();
    }

}
