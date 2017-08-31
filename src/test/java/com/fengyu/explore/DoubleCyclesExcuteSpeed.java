package com.fengyu.explore;

import org.springframework.util.StopWatch;

/**
 * 双重循环执行数据
 * Created by HanFeng on 2017/8/30.
 */
public class DoubleCyclesExcuteSpeed {


    public static void outSideLittle(){
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 10000; j++) {
                System.out.println(j);
            }
        }
    }

    public static void inSideLittle(){
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println(j);
            }
        }
    }

    public static void main(String[] args) {
        StopWatch watch = new StopWatch("1");
        watch.start();
        outSideLittle();
        watch.stop();
        Long watch1 = watch.getTotalTimeMillis();


        watch = new StopWatch("2");
        watch.start();
        inSideLittle();
        watch.stop();
        Long watch2 = watch.getTotalTimeMillis();

        System.out.println("watch1:"+watch1);
        System.out.println("watch2:"+watch2);

        // watch1:3.696
        // watch2:3.144
        // 外层多的执行快

        //js 执行类似代码，得到相同结果

        // 目前测试结果很片面
    }

    /*

        console.time("aa");

        for(var i=0,is=1000;i<=is;i++){

            for(var l=0,ls=100;l<=ls;l++){
                console.log(l);
            }
        }

        console.timeEnd("aa");

        // //aa: 3760.090087890625ms


        console.time("aa");

        for(var i=0,is=100;i<=is;i++){

            for(var l=0,ls=1000;l<=ls;l++){
                console.log(l);
            }
        }

        console.timeEnd("aa");

        // //aa: 4182.922119140625ms

     */
}
