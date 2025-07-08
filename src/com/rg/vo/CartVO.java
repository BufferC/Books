package com.rg.vo;

import java.math.BigDecimal;

public class CartVO {
    private int cid;
    private int bid;
    private String bname;
    private BigDecimal bprice;
    private int cnum;
    private BigDecimal total_bprice;
    private String bimg;

    public CartVO() {
    }

    public CartVO(int cid, int bid, String bname, BigDecimal bprice, int cnum, String bimg) {
        this.cid = cid;
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.cnum = cnum;
        this.bimg = bimg;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public BigDecimal getBprice() {
        return bprice;
    }

    public void setBprice(BigDecimal bprice) {
        this.bprice = bprice;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public BigDecimal getTotal_bprice() {
        return total_bprice;
    }

    public void setTotal_bprice(BigDecimal total_bprice) {
        this.total_bprice = total_bprice;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", cnum=" + cnum +
                ", total_bprice=" + total_bprice +
                ", bimg='" + bimg + '\'' +
                '}';
    }
}
