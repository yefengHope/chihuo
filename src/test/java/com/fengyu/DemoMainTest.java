package com.fengyu;

/**
 * Created by rain on 2017/8/15.
 */
public class DemoMainTest {

    public static void main(String[] args) {
        DemoInterface demo = new DemoInterfaceImpl();

        try {
            demo.notThrowException();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            demo.throwException();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
