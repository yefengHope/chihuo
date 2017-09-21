package com.fengyu.arithmetic.search;

/**
 * 二分查找
 * Created by HF on 2017/9/17.
 */
public class BinarySearch {

    public int binSelect(int [] arry,int num) {
        if (arry == null || arry.length <= 0) {
            return -1;
        }
        // 二分循环
        int left = 0;
        int rigth = arry.length-1;
        while((rigth-left) > 0) {
            // 中间值
            int a = (left + rigth);
            int bewteen = (a%2 == 0)? (a/2) : (a + 1)/2;
            int temp = arry[bewteen];
            if ( temp == num) {
                return bewteen;
            }else if (num > temp) {
                left = bewteen;
            }else {
                rigth = bewteen;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,8,9,11,12,14,18,22,33,44,55,66,77,121};
        System.out.println(new BinarySearch().binSelect(array,121));
    }

}
