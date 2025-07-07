package com.rg.dao.impl;

import com.rg.dao.BookDao;
import com.rg.entity.Book;
import com.rg.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {
    QueryRunner runner = new QueryRunner();
    Connection connection = JdbcUtils.getConnection();
    @Override
    public List<Book> getAll() {
        String sql = "select * from book";

        try {
            return runner.query(connection, sql, new BeanListHandler<>(Book.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int decr(int bid) {
        String sql = "update book set bstock = bstock - 1 where bid = ?";
        try {
            return runner.update(connection, sql, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int incr(int bid) {
        String sql = "update book set bstock = bstock + 1 where bid = ?";
        try {
            return runner.update(connection, sql, bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Book getById(int bid) {
        String sql = "select * from book where bid = ?";

        try {
            return runner.query(connection, sql, new BeanHandler<>(Book.class), bid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
