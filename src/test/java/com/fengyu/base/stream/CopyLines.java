package com.fengyu.base.stream;

import java.io.*;

/**
 * Created by HanFeng on 2017/9/16.
 */
public class CopyLines {

    public static void main(String[] args) throws IOException {
        // BufferedReader inputStream = null;
        // PrintWriter outputStream = null;
        //
        // try {
        //     inputStream = new BufferedReader(new FileReader("resources/xanadu.txt"));
        //     outputStream = new PrintWriter(new FileWriter("resources/characteroutput.txt"));
        //
        //     String l;
        //     while ((l = inputStream.readLine()) != null) {
        //         outputStream.println(l);
        //     }
        // } finally {
        //     if (inputStream != null) {
        //         inputStream.close();
        //     }
        //     if (outputStream != null) {
        //         outputStream.close();
        //     }
        // }

        String readAbsolutePath = "C:\\WorkSpace\\chihuo\\src\\main\\resources\\test.xml";
        String writeAbsolutePath = "C:\\WorkSpace\\chihuo\\src\\main\\resources\\test1.xml";

        // 相对工程目录
        String readRelativePath = "src/main/resources/test.xml";
        String writeRelativePath = "src/main/resources/test1.xml";

        // java 8
        // try (
        //         BufferedReader inputStream = new BufferedReader(new FileReader(readRelativePath));
        //         PrintWriter outputStream = new PrintWriter(new FileWriter(writeRelativePath))
        // ) {
        //     String l;
        //     while ((l = inputStream.readLine()) != null) {
        //         outputStream.println(l);
        //     }
        // }

        InputStream inputStream = new FileInputStream(readAbsolutePath);
        byte[] bytes = new byte[100];
        while (inputStream.read(bytes) != -1) {
            System.out.println(bytes);
        }

    }
}
