package com.fengyu.system.model;

import java.util.List;

/**
 * bootstrap 分页参数
 * Created by 韩峰 on 2016/8/15.
 */
public class BootPage<T> {

    /**
     * 总计
     */
    protected Long total;

    /**
     * 数据
     */
    protected List<T> rows;

    /**
     * 分页的大小
     */
    protected int limit=0;

    protected int offset = 0;

    /**
     * 排序
     */
    protected String order ="desc" ;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
