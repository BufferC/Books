package com.rg.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class BookOrder {
    private int oid;
    private int bid;
    private int onum;
    private int uid;
    private Date otime;

    public BookOrder() {
    }

    public BookOrder(int oid, int bid, int onum, int uid, Date otime) {
        this.oid = oid;
        this.bid = bid;
        this.onum = onum;
        this.uid = uid;
        this.otime = otime;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "BookOrder{" +
                "oid=" + oid +
                ", bid=" + bid +
                ", onum=" + onum +
                ", uid=" + uid +
                ", otime=" + otime +
                '}';
    }
}
