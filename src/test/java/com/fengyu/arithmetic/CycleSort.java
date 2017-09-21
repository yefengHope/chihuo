package com.fengyu.arithmetic;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

import java.util.Random;

/**
 * Created by HanFeng on 2017/9/3.
 */
public class CycleSort {

    public static void cicSort(int[] nums) {

        for (int i=0,s=nums.length;i<s;i++) {
            for (int y=1,ys=nums.length;y<ys;y++) {
                int temp = nums[y];
                if (temp < nums[y-1]) {
                    nums[y] = nums[y-1];
                    nums[y-1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        float a_f = 3;
        double d_a = 3.4;

        int[] nums = new int[10000];
        Random random = new Random(100);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        cicSort(nums);
        stopWatch.stop();
        System.out.println(JSON.toJSONString(nums));
        System.out.println(stopWatch.getLastTaskTimeMillis());

    }
}
