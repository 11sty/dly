package com.dly.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页类
 * @param <T> 实体类型
 */
public class PageUtil<T> {
    /**
     * 当前页
     */
    private int nowPage = 1;

    /**
     * 页容量
     */
    private int pageSize = 10;
    /**
     * 总页数
     */
    private int totalPages;

    /**
     * 分页的数的集合方便页面循环
     */
    private List<Integer> pagesList = new ArrayList<>();
    /**
     * 总条数
     */
    private int totalNums = 0;

    /**
     * 上一页
     */
    private int prevPage;

    /**
     * 下一页
     */
    private int nextPage;


    /**
     * 第一页
     */
    private int firstPage = 1;

    /**
     * 最后一页
     */
    private int lastPage;

    /**
     * 每一页的内容
     */
    private List<T> content;


    /**
     * 设置当前页
     * @param nowPage
     */
    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }


    /**
     * 设置页容量
     * @param pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    /**
     * 设置总条数
     * @param totalNums
     */
    public void setTotalNums(int totalNums) {
        this.totalNums = totalNums;
        setAllAttr();//设置其余属性
    }


    /**
     * 设置每一页的数据
     * @param content
     */
    public void setContent(List<T> content) {
        this.content = content;
    }


    /**
     * 设置其余所有属性
     */
    private void setAllAttr(){
        //总的页数
        this.totalPages = (int) Math.ceil(this.totalNums/(this.pageSize+0.0));
        //上一页
        this.prevPage = this.nowPage-1 <=0 ? 1 : this.nowPage-1;
        //下一页
        this.nextPage = this.nowPage+1 > this.totalPages ? this.nowPage : this.nowPage+1;
        //最后一页
        this.lastPage = this.totalPages;
        //分页数的集合
        for (int i = 1; i <= this.totalPages ; i++) {
            pagesList.add(i);
        }

    }


    public int getNowPage() {
        return nowPage;
    }


    public int getPageSize() {
        return pageSize;
    }



    public int getTotalPages() {
        return totalPages;
    }


    public int getTotalNums() {
        return totalNums;
    }



    public int getPrevPage() {
        return prevPage;
    }



    public int getNextPage() {
        return nextPage;
    }



    public int getFirstPage() {
        return firstPage;
    }



    public int getLastPage() {
        return lastPage;
    }

    public List<Integer> getPagesList() {
        return pagesList;
    }

    public List<T> getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "nowPage=" + nowPage +
                ", pageSize=" + pageSize +
                ", totalPages=" + totalPages +
                ", totalNums=" + totalNums +
                ", prevPage=" + prevPage +
                ", nextPage=" + nextPage +
                ", firstPage=" + firstPage +
                ", lastPage=" + lastPage +
                ", content=" + content +
                '}';
    }
}
