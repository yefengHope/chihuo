package com.fengyu.base.filePath;

import java.io.*;

/**
 * Created by HanFeng on 2017/9/16.
 */
public class FindPath {

    public void getClassName() {
        System.out.println(this.getClass().getName()); // com.fengyu.base.filePath.FindPath
        System.out.println(this.getClass().getSimpleName()); //FindPath
        System.out.println(this.getClass().getCanonicalName()); //com.fengyu.base.filePath.FindPath
        System.out.println(this.getClass().getTypeName()); //com.fengyu.base.filePath.FindPath
        System.out.println(this.getClass().getPackage()); //package com.fengyu.base.filePath
        System.out.println("this.getClass().getResource(\"\") = " + this.getClass().getResource(""));
        // file:/C:/WorkSpace/chihuo/target/test-classes/com/fengyu/base/filePath/
    }

    public static void main(String[] args) {

        // // C:\WorkSpace\chihuo
        // File root = new File("");
        // System.out.println(root.getAbsolutePath());
        //
        // // true
        // // C:\WorkSpace\chihuo\src\main\resources\test.xml
        // File f = new File("src/main/resources/test.xml");
        // System.out.println(f.exists());
        // System.out.println(f.getAbsolutePath());

        // 使用getResourceAsStream方法的相对路径就在该类的目录下，
        // 而写上路径"/test.properties"系统就会到classpath的根目录底下去寻找。
        // String path = "test.xml"; // 找不到路径
        String path = "/test.xml";      // 能找到路径
        // BufferedInputStream bufferedInputStream = new BufferedInputStream();
        // InputStreamReader inputStreamReader = new InputStreamReader(FindPath.class.getResourceAsStream(path))
        // InputStream inputStream = FindPath.class.getResourceAsStream(path)
        // try (
        //         BufferedReader reader = new BufferedReader(new InputStreamReader(FindPath.class.getResourceAsStream(path)))
        // ) {
        //     String strLine;
        //     while ((strLine = reader.readLine()) != null) {
        //         System.out.println(strLine);
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }

        // 以下不建议使用
        System.out.println(System.getProperty("user.dir")); //    C:\WorkSpace\chihuo

        // ("") ("/") 一个是当前 .class 目录下，一个是当前.class 的根目录
        System.out.println(FindPath.class.getResource("").getPath());  //   /C:/WorkSpace/chihuo/target/test-classes/com/fengyu/base/filePath/
        System.out.println(FindPath.class.getResource("/").getPath()); //   /C:/WorkSpace/chihuo/target/test-classes/
        System.out.println(FindPath.class.getResource("").getFile());  //   /C:/WorkSpace/chihuo/target/test-classes/com/fengyu/base/filePath/

        new FindPath().getClassName();
    }
}
