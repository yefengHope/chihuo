package com.fengyu.demo.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by rain on 2017/8/19.
 */
public class ProxyClass implements MethodInterceptor {


    /**
     *
     * @param o         "this", the enhanced object
     * @param method    intercepted Method
     * @param objects   argument array; primitive types are wrapped
     * @param methodProxy   used to invoke super (non-intercepted method); may be called as many times as needed
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我被代理之前");
        Object obj = methodProxy.invokeSuper(o,objects);
        System.out.println("我被代理之后");
        return obj;
    }
}
