package com.fengyu.engine.dggCodeCreator.mybatis;

import org.apache.commons.lang.StringUtils;

/**
 * <p>@Title 批量插入方法,每一个eky都必须存在会报错 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/7 15:28 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class insertBatch {

    public static void main(String[] args) {
        // Navicat 导出文本结构
        String columnTitle = "ID\tPAYSOURCE\tTRADE_TIME\tAPPID\tMCH_ID\tSUB_MCH_ID\tDEVICE_INFO\tTRANSACTION_ID\tOUT_TRADE_NO\tOPENID\tTRADE_TYPE\tTRADE_STATUS\tBANK_TYPE\tFEE_TYPE\tTOTAL_FEE\tCOUPON_FEE\tREFUND_APPLY_TIME\tREFUND_SUCCESS_TIME\tREFUND_ID\tOUT_REFUND_NO\tREFUND_FEE\tREFUND_CHANNEL\tREFUND_STATUS\tPRODUCT_NAME\tATTACH\tHANDLING_CHARGE\tRATE\tAA02\tAB02\tBILL_IS\tBILL_PERSON_NAME\tBILL_PERSION_ID\tBILL_TIME\tBILL_REMARK";
        String titleColumn = titleColumn(columnTitle);
        String columnData = columnData(columnTitle);
        System.out.println(titleColumn);
        System.out.println(columnData);
    }

    // 输出mybatis 列头
    public static String titleColumn (String columnTitle) {
        StringBuilder sbStr = new StringBuilder();
        String[] titles = columnTitle.split("\t");
        String templateColumn = "\t$_content_$ ,\t";
        sbStr.append("(\n");
        for (int i = 0; i < titles.length; i ++ ) {
            String title = titles[i];
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

    public static String columnData(String columnTitle) {
        StringBuilder sbStr = new StringBuilder();
        String[] titles = columnTitle.split("\t");
        String templateColumn = "\t$_content_$ ,\t";
        sbStr.append("<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\" >\n(\n");
        for (int i = 0; i < titles.length; i ++ ) {
            String title = titles[i];
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
