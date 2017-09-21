package com.fengyu.designMode.single;

/**
 * 懒汉式单例
 * 多线程安全测试
 * Created by HanFeng on 2017/9/15.
 */
public class SingleLazy extends Thread {
    private static SingleLazy singleLazy = null;

    private SingleLazy() {

    }

    private static SingleLazy getInstance() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 安全
            synchronized (SingleLazy.class) {
                if (singleLazy == null) {
                    singleLazy = new SingleLazy();
                }
            }

            /*
            // 非安全，因为多线程时可能存在多个判断为空，然后依次创建
            if (singleLazy == null) {
                synchronized (SingleLazy.class) {
                    singleLazy = new SingleLazy();
                }
            }
             */
        }
        return singleLazy;
    }

    @Override
    public void run() {
        System.out.println(SingleLazy.getInstance().hashCode());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread thread = new SingleLazy();
            thread.start();
        }

    }
}
