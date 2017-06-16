package com.fengyu.engine.dggCodeCreator.mybatis;

import org.apache.commons.lang.StringUtils;

import java.util.List;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/7 15:52 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class UpdateSelect {

    // 输出mybatis 列头
    public static String columnData (List<String> titles) {
        StringBuilder sbStr = new StringBuilder();
        String templateColumn = "\t<if test=\"$_test_$ != null\">\t$_content_$ = #{$_test_$}\t,</if>\n";
        sbStr.append("<set>\n");
        for (String title : titles) {
            String cacheTemplate = new String(templateColumn);
            String [] titleArr = title.split("_");
            StringBuilder sb = new StringBuilder();
            for (String title1 : titleArr) {

                //转换成小写 ,并首字母大写
                String a = StringUtils.capitalize(title1.toLowerCase());

                sb.append(a);
            }

            String $test = StringUtils.uncapitalize(sb.toString());

            cacheTemplate = cacheTemplate.replace("$_test_$",$test).replace("$_content_$",title);
            sbStr.append(cacheTemplate);
        }
        sbStr.append("</set>");
        return sbStr.toString();
    }

}
