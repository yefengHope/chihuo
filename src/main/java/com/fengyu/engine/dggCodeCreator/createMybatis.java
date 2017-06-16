package com.fengyu.engine.dggCodeCreator;

import com.fengyu.engine.dggCodeCreator.mybatis.InsertBatch;
import com.fengyu.engine.dggCodeCreator.mybatis.InsertSelect;
import com.fengyu.engine.dggCodeCreator.mybatis.Select;
import com.fengyu.engine.dggCodeCreator.mybatis.UpdateSelect;

import java.util.List;

/**
 * <p>@Title 类标题描述 </p>
 * <p>@Description 类功能描述（功能，作用）,描述过多时可以换行</p>
 * <p>@Version 1.0.0 版本号</p>
 * <p>@author hanfeng</p>
 * <p>@date 2017/6/7 15:25 创建日期</p>
 * <p>hanfeng@dgg.com 作者的公司邮箱</p>
 * <p>Copyright © dgg group.All Rights Reserved. 版权信息</p>
 */
public class createMybatis {

    public static void main(String[] args) {
        SqlUtils sqlUtils = new SqlUtils();
        List<String> list = sqlUtils.selectColumnName();
        String insertBatchClomnStr = InsertBatch.titleColumn(list);
        System.out.println("insertBatchClomnStr");
        System.out.println(insertBatchClomnStr);
        System.out.println();

        String insertBatchDateStr = InsertBatch.columnData(list);
        System.out.println("insertBatchDateStr");
        System.out.println(insertBatchDateStr);
        System.out.println();

        String insertSelectClomnStr = InsertSelect.titleColumn(list);
        System.out.println("insertSelectClomnStr");
        System.out.println(insertSelectClomnStr);
        System.out.println();

        String insertSelectDateStr = InsertSelect.columnData(list);
        System.out.println("insertSelectDateStr");
        System.out.println(insertSelectDateStr);
        System.out.println();

        String selectColumnStr = Select.columnSelect(list);
        System.out.println("selectColumnStr");
        System.out.println(selectColumnStr);
        System.out.println();

        String updateColumnData = UpdateSelect.columnData(list);
        System.out.println("updateColumnData");
        System.out.println(updateColumnData);
        System.out.println();

    }

}
