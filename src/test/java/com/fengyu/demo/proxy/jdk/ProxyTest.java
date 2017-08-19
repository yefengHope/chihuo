package com.fengyu.demo.proxy.jdk;

/**
 * Created by rain on 2017/8/19.
 */
public class ProxyTest {
    public static void main(String[] args) {
        // 实例化目标对象
        // 实例化代理对象
        // 生成代理对象

        ProxyInterface proxyInterface = new ProxyImpl();
        ProxyInvocationHandler proxyHandler = new ProxyInvocationHandler(proxyInterface);
        ProxyInterface proxy = (ProxyInterface) proxyHandler.getProxy();
        proxy.sout();

    }
}
