package com.fengyu.system.model;

import java.util.List;

/**
 * bootstrap 分页参数
 *      构造方法慎重删除, 其中有改动
 * Created by 韩峰 on 2016/8/15.
 */
public class BootPage<T> {


    /**
     * 总计
     */
    private Long total;

    /**
     * 数据
     */
    private List<T> rows;

    /**
     * 分页的大小
     */
    private int limit ;

    private int offset ;

    /**
     * 排序
     */
    private String order ="desc" ;

    /**
     * bootstrap查询框
     * 查询字符串
     * @return
     */
    private String searchText;

    /**
     * bootstrap当前页
     */
    private Integer pageNumber;

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

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        //spring data jpa 分页类pageable 分页参数是0开始
        if(pageNumber > 0){
            pageNumber = pageNumber - 1;
        }
        this.pageNumber = pageNumber;
    }
}
