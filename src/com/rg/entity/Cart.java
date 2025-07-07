package com.rg.entity;

public class Cart {
    private int cid;
    private int bid;
    private int uid;
    private int cnum;

    public Cart() {
    }

    public Cart(int cid, int bid, int uid, int cnum) {
        this.cid = cid;
        this.bid = bid;
        this.uid = uid;
        this.cnum = cnum;
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

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", bid=" + bid +
                ", uid=" + uid +
                ", cnum=" + cnum +
                '}';
    }
}
