package com.fengyu.arithmetic;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StopWatch;

import java.util.Random;

/**
 * Created by HanFeng on 2017/9/4.
 */
public abstract class InsertSort {

    public static void insertSort(int[] nums) {

        // {5,3}
        for (int i=1,s=nums.length;i<s;i++) {
            int temp = nums[i];// 5

            if (temp < nums[i-1]) {
                int j = i-1; //j=0

                while(j>=0 && temp < nums[j]) {
                    nums[j+1] = nums[j]; //{,5}
                    j--;
                }

                nums[j+1] = temp;
            }

        }

    }
    public abstract void test();

    public static void main(String[] args) {
        int[] nums = new int[10000];
        Random random = new Random(100);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        insertSort(nums);
        stopWatch.stop();
        System.out.println(JSON.toJSONString(nums));
        System.out.println(stopWatch.getLastTaskTimeMillis());
    }
}
