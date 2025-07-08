package com.rg.dao;

import com.rg.entity.Cart;
import com.rg.vo.CartVO;

import java.util.List;

public interface CartDao {
    Cart getCart(String bid, int uid);

    List<Cart> getCart(int uid);

    int add(String bid, int uid);

    int update(int cid, int cnum);

    CartVO getVO(int cid);

    List<CartVO> getAllCartVO(int uid);

    int clear(int uid);

    int delete(int cid);
}
