package com.rg.dao.impl;

import com.rg.dao.CartDao;
import com.rg.entity.Cart;
import com.rg.utils.JdbcUtils;
import com.rg.vo.CartVO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    QueryRunner runner = new QueryRunner();
    Connection connection = JdbcUtils.getConnection();
    @Override
    public Cart getCart(String bid, int uid) {
        String sql = "select * from cart where bid = ? and uid = ?";
        try {
            return runner.query(connection, sql, new BeanHandler<>(Cart.class), bid, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Cart> getCart(int uid) {
        String sql = "select * from cart where uid = ?";
        try {
            return runner.query(connection, sql, new BeanListHandler<>(Cart.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(String bid, int uid) {
        String sql = "insert into cart(bid, uid, cnum) values(?, ?, 1)";
        try {
            return runner.update(connection, sql, bid, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int update(int cid, int cnum) {
        String sql = "update cart set cnum = ? where cid = ?";
        try {
            return runner.update(connection, sql, cnum, cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public CartVO getVO(int cid) {
        String sql = "select cart.cid, cart.bid, cart.cnum, bname, bimg, bprice from cart inner join book on cart.bid = book.bid where cid = ?";
        try {
            CartVO cartVO = runner.query(connection, sql, new BeanHandler<>(CartVO.class), cid);
            cartVO.setTotal_bprice(cartVO.getBprice().multiply(new BigDecimal(cartVO.getCnum())));
            return cartVO;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<CartVO> getAllCartVO(int uid) {
        List<Cart> carts = getCart(uid);

        List<CartVO> cartVOS = new ArrayList<>();

        for (Cart cart : carts) {
            CartVO cartVO = getVO(cart.getCid());
            cartVOS.add(cartVO);
        }
        return cartVOS;
    }

    @Override
    public int clear(int uid) {
        String sql = "delete from cart where uid = ?";
        try {
            return runner.update(connection, sql, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
