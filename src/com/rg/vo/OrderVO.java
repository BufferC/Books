package com.rg.vo;

import java.math.BigDecimal;
import java.util.Date;

public class OrderVO {
    private int oid;
    private String bimg;
    private String bname;
    private BigDecimal bprice;
    private int onum;
    private Date otime;
    private String str_time;
    private double total_bprice;

    public OrderVO() {
    }

    public OrderVO(int oid, String bimg, String bname, BigDecimal bprice, int onum, Date otime, double total_bprice) {
        this.oid = oid;
        this.bimg = bimg;
        this.bname = bname;
        this.bprice = bprice;
        this.onum = onum;
        this.otime = otime;
        this.total_bprice = total_bprice;
    }

    public BigDecimal getBprice() {
        return bprice;
    }

    public void setBprice(BigDecimal bprice) {
        this.bprice = bprice;
    }

    public String getStr_time() {
        return str_time;
    }

    public void setStr_time(String str_time) {
        this.str_time = str_time;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getBimg() {
        return bimg;
    }

    public void setBimg(String bimg) {
        this.bimg = bimg;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public int getOnum() {
        return onum;
    }

    public void setOnum(int onum) {
        this.onum = onum;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public double getTotal_bprice() {
        return total_bprice;
    }

    public void setTotal_bprice(double total_bprice) {
        this.total_bprice = total_bprice;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "oid=" + oid +
                ", bimg='" + bimg + '\'' +
                ", bname='" + bname + '\'' +
                ", onum=" + onum +
                ", otime=" + otime +
                ", total_bprice=" + total_bprice +
                '}';
    }
}
