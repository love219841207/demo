package com.cookie.home.util;

import com.cookie.framework.base.PageBean;

import java.util.List;

public class CustomPage<T> {

    //当前页数
    private int page;

    //每页显示数量
    private int pagesize;

    //总条数
    private long records;

    //数据列表
    private List<T> rows;

    //总页数
    private int total;

    //排序字段
    private String orderByField;

    //是否升序
    private boolean isAsc;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderByField() {
        return orderByField;
    }

    public void setOrderByField(String orderByField) {
        this.orderByField = orderByField;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean isAsc) {
        this.isAsc = isAsc;
    }

    public CustomPage(){}

    public CustomPage(PageBean<T> page){
        this.page = page.getPageNum();
        this.pagesize = page.getPageSize();
        this.records = page.getTotal();
        this.rows = page.getList();
        this.total = page.getPages();
        //this.orderByField = page.getOrderByField();
      //  this.isAsc = page.isAsc();
    }
}
