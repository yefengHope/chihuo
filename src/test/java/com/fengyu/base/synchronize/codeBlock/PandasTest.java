package com.fengyu.base.synchronize.codeBlock;

/**
 * Created by HanFeng on 2017/9/15.
 */
public class PandasTest {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            PandaNumber pandaNumber = new PandaNumber();
            Thread thread = new Thread(pandaNumber);
            thread.start();
        }
    }
}
