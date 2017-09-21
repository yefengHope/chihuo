package com.fengyu.base.string;

/**
 * Created by HanFeng on 2017/9/15.
 */
public class StringTest {

    public static void main(String[] args) {
        String s1 = new String("计算机");
        String s2 = s1.intern();
        String s3 = "计算机";
        System.out.println("s1 == s2? " + (s1 == s2));
        System.out.println("s3 == s2? " + (s3 == s2));

        // String s4 = new String("ABC");
        // String s5 = new String("DE");
        String s4 = "ABCc";
        String s5 = "DE";
        String s6 = s4 + s5;
        String s7 = "ABCcDE";
        System.out.printf("s6.intern() == s7?=%b\n",s6.intern()==s7);
        System.out.printf("s6 == s7?=%b\n",s6==s7);

        String s8 = new String("bbb");
        String s9 = new String(s8);
        System.out.println(s9);

        final char value[];
    }

}
