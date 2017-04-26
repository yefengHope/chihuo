package com.fengyu.spiders;

/**
 * 一个接口，实现其 accept() 方法用来对抽取的链接进行过滤
 * Created by rain on 2017/4/26.
 */
public interface LinkFilter {
    boolean accept(String url);
}
