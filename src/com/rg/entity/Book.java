package com.rg.entity;

import java.math.BigDecimal;

public class Book {
    private int bid;
    private String bname;
    private BigDecimal bprice;
    private String bimg;
    private String btext;
    private int bstock;

    public Book() {
    }

    public Book(int bid, String bname, BigDecimal bprice, String bimg, String btext, int bstock) {
        this.bid = bid;
        this.bname = bname;
        this.bprice = bprice;
        this.bimg = bimg;
        this.btext = btext;
        this.bstock = bstock;
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

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getBtext() {
        return btext;
    }

    public void setBtext(String btext) {
        this.btext = btext;
    }

    public int getBstock() {
        return bstock;
    }

    public void setBstock(int bstock) {
        this.bstock = bstock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bid=" + bid +
                ", bname='" + bname + '\'' +
                ", bprice=" + bprice +
                ", bimg='" + bimg + '\'' +
                ", btext='" + btext + '\'' +
                ", bstock=" + bstock +
                '}';
    }
}
