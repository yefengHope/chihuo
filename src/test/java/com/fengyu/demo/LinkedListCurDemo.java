package com.fengyu.demo;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by HanFeng on 2017/9/3.
 */
public class LinkedListCurDemo {

    public static List build() {
        List<Integer> list = new ArrayList<>();
        for (int i=0,s=1000000;i<s;i++) {
            // Random random = new Random();
            list.add(i /*random.nextInt()*/);
        }
        return list;
    }


    public static List listCur() {
        List<Integer> list = build();
        List<Integer> reList = new LinkedList<>();
        for (int i=0,s=list.size();i<s;i++){
            if (list.get(i)%100 != 0) {
                reList.add(list.get(i));
            }
        }
        return reList;
    }

    public static List iterator() {
        List<Integer> list = new LinkedList<>(build());
        Iterator<Integer> sListIterator = list.iterator();
        while(sListIterator.hasNext()){
            Integer e = sListIterator.next();
            if(e%100 == 0){
                sListIterator.remove();
            }
        }
        return list;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch("1");
        // stopWatch.start();
        // List<Integer> list = listCur();
        // stopWatch.stop();
        // System.out.println(stopWatch.getTotalTimeSeconds());
        // System.out.println(list.size());

        stopWatch = new StopWatch("2");
        stopWatch.start();
        List<Integer> list2 = iterator();
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeSeconds());
        System.out.println(list2.size());

    }
}
