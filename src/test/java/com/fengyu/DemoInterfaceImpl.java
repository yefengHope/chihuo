package com.fengyu;

/**
 * Created by rain on 2017/8/15.
 */
public class DemoInterfaceImpl implements DemoInterface {
    @Override
    public void throwException() {
        throw new NullPointerException("你大爷");
    }

    @Override
    public void notThrowException() {
        throw new NullPointerException("你大爷");
    }
}
