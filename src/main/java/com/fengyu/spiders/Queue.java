package com.fengyu.spiders;

import java.util.LinkedList;

/**
 * 数据结构队列
 * 实现了一个简单的队列，在 LinkDb.java 中使用了此类
 * Created by rain on 2017/4/26.
 */
public class Queue<T> {

    private LinkedList<T> queue=new LinkedList<T>();

    public void enQueue(T t)
    {
        queue.addLast(t);
    }

    public T deQueue()
    {
        return queue.removeFirst();
    }

    public boolean isQueueEmpty()
    {
        return queue.isEmpty();
    }

    public boolean contians(T t)
    {
        return queue.contains(t);
    }

    public boolean empty()
    {
        return queue.isEmpty();
    }
}
