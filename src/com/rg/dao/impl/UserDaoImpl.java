package com.rg.dao.impl;

import com.rg.dao.UserDao;
import com.rg.entity.User;
import com.rg.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public User getUser(String username, String password) {
        Connection connection = JdbcUtils.getConnection();

        QueryRunner runner = new QueryRunner();

        String sql = "select * from user where uname = ? and upwd = ?";

        try {
            return runner.query(connection, sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int add(String username, String password) {
        Connection connection = JdbcUtils.getConnection();

        QueryRunner runner = new QueryRunner();

        String sql = "insert into user(uname, upwd) values(?, ?)";

        try {
            return runner.update(connection, sql, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public User getUser(String username) {
        Connection connection = JdbcUtils.getConnection();

        QueryRunner runner = new QueryRunner();

        String sql = "select * from user where uname = ?";

        try {
            return runner.query(connection, sql, new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
