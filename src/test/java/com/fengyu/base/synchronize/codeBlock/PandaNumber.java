package com.fengyu.base.synchronize.codeBlock;

/**
 * Created by HanFeng on 2017/9/15.
 */
public class PandaNumber implements Runnable {

    @Override
    public void run() {
        synchronized (PandaNumber.class) {
            for (int i = 0; i < 5; i++) {
                System.out.printf("thread name : 【%s】 ,cur number :  【%d】\n", Thread.currentThread().getName(), i);
            }
        }
    }

    // public static void main(String[] args) {
    //     PandaNumber pandaNumber = new PandaNumber();
    //     pandaNumber.run();
    // }
}
