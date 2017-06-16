package com.fengyu.engine.dggCodeCreator.mybatis;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * <p>@Title 批量插入方法,每一个eky都必须存在会报错 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/7 15:28 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class InsertBatch {

    // 输出mybatis 列头
    public static String titleColumn (List<String> titles) {
        StringBuilder sbStr = new StringBuilder();
        String templateColumn = "\t$_content_$ ,\t";
        sbStr.append("(\n");
        for (int i = 0; i < titles.size(); i ++ ) {
            String title = titles.get(i);
            String cacheTemplate = new String(templateColumn);
            String [] titleArr = title.split("_");
            StringBuilder sb = new StringBuilder();
            for (String title1 : titleArr) {

                //转换成小写 ,并首字母大写
                String a = StringUtils.capitalize(title1.toLowerCase());

                sb.append(a);
            }

            String $test = StringUtils.uncapitalize(sb.toString());

            cacheTemplate = cacheTemplate.replace("$_content_$",title);
            if (i >= 4 && i%4 == 0) {
                sbStr.append("\n");
            }
            sbStr.append(cacheTemplate);
        }
        sbStr.append("\n)");
        return sbStr.toString();
    }

    public static String columnData(List<String> titles) {
        StringBuilder sbStr = new StringBuilder();
        String templateColumn = "\t$_content_$ ,\t";
        sbStr.append("<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >\n(\n");
        for (int i = 0; i < titles.size(); i ++ ) {
            String title = titles.get(i);
            String cacheTemplate = new String(templateColumn);
            String [] titleArr = title.split("_");
            StringBuilder sb = new StringBuilder();
            for (String title1 : titleArr) {

                //转换成小写 ,并首字母大写
                String a = StringUtils.capitalize(title1.toLowerCase());

                sb.append(a);
            }

            String $test = StringUtils.uncapitalize(sb.toString());

            cacheTemplate = cacheTemplate.replace("$_content_$","#{item."+$test+"}");
            if (i >= 4 && i%4 == 0) {
                sbStr.append("\n");
            }
            sbStr.append(cacheTemplate);
        }
        sbStr.append("\n)\n</foreach>");
        return sbStr.toString();
    }
}
