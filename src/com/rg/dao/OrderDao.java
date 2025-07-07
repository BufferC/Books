package com.rg.dao;

import com.rg.vo.OrderVO;

import java.util.List;

public interface OrderDao {
    int add(int bid, int cnum, int uid);

    List<OrderVO> getOrderVOs(int uid);
}
