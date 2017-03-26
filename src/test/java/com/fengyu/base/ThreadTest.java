package com.fengyu.base;

/**
 * 并发线程小试
 * Created by rain on 2017/3/26.
 */
public class ThreadTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            User user = new User(""+i);
            Thread thread = new Thread(user);
            thread.start();
        }
    }
}


class User  implements Runnable{

    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.printf("%s  - %d : %s \n",
                    Thread.currentThread().getName(),
                    i,name);
        }
    }
}
