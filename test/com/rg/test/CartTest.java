package com.rg.test;

import com.rg.dao.CartDao;
import com.rg.dao.impl.CartDaoImpl;
import com.rg.entity.Cart;
import org.junit.Test;

import java.util.List;

public class CartTest {
    CartDao cartDao = new CartDaoImpl();
    @Test
    public void testGet() {
        List<Cart> carts = cartDao.getCart(1);
        for (Cart cart : carts) {
            System.out.println(cart);
        }
    }
}
