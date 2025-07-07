package com.rg.entity;

import java.util.List;

/**
 * 分页信息实体类，包含一些通用的参数
 *
 * @param <T> 泛型，对应实体类的类型
 */
public class PageInfo<T> {
    private int pageCount;  // 总页数
    private Long totalCount; // 数据总条数
    private int pageSize;   // 每页显示的条数
    private int pageNo;     // 当前页
    private List<T> list;   // 当前页中的数据，可能有多条，声明一个List集合，泛型为对应实体类的类型

    public PageInfo() {
    }

    public PageInfo(Long totalCount, int pageSize, int pageNo, List<T> list) {
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
        this.list = list;

        if (totalCount % pageSize == 0) {   // 如果数据总数能够整除每页显示的条数
            this.pageCount = (int) (totalCount / pageSize); // 总页数等于数据总条数除以每页显示多少条数据
        } else {
            this.pageCount = (int) (totalCount / pageSize + 1); // 无法整除，再增加一页
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageCount=" + pageCount +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", pageNo=" + pageNo +
                ", list=" + list +
                '}';
    }
}