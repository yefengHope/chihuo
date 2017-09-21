package com.fengyu.arithmetic;

/**
 * Created by HanFeng on 2017/9/6.
 */
public class Recursion {

    /**
     * 逆序整数
     *
     * @param i
     */
    private static int dz(int i) {
        String te = "";
        if (i > 10) {
            te += dz(i / 10) + "";
        }
        return Integer.parseInt((i % 10) + te);
    }

    public static int single1() {
        int count = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                for (int k = 0; k < 20; k++) {
                    int product = i + 2 * j + 3 * k;
                    if (product == 15) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static String single2(String str) {
        String res = "";
        if (str.length() > 1) {
            res += single2(str.substring(0, str.length() - 1));
        }
        return str.substring(str.length()-1,str.length()) + res;
    }

    public static void main(String[] args) {
        // System.out.println(dz(12345678));
        // System.out.println(single1());
        System.out.println(single2("abcde"));
    }
}
