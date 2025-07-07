package com.rg.utils;

import com.rg.entity.Book;
import com.rg.entity.PageInfo;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookPageUtils {
    private final QueryRunner queryRunner = new QueryRunner();

    private final Connection connection = JdbcUtils.getConnection();

    // 获取总数据量
    private Long getTotalCount(String keyword) {
        String sql;
        if (keyword != null) {
            sql = "select count(*) from book where bname like '%" + keyword + "%'";
        } else {
            sql = "select count(*) from book";
        }

        try {
            return queryRunner.query(connection, sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    // 获取每页中的数据
    private List<Book> getListByPage(int start, int pageSize, String keyword) {
        String sql;
        if (keyword == null) {
            sql = "select * from book limit ?, ?";
        } else {
            sql = "select * from book where bname like '%" + keyword + "%' limit ?, ?";
        }

        try {
            return queryRunner.query(connection, sql, new BeanListHandler<>(Book.class), start, pageSize);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    // 获取分页信息对象
    public PageInfo<Book> getPageInfo(int pageNo, int pageSize, String keyword) {
        // 获取总数据量
        Long totalCount = getTotalCount(keyword);

        // 获取每页的开头，用于查询数据库
        int start = (pageNo - 1) * pageSize;

        // 获取每页中的所有内容
        List<Book> list = getListByPage(start, pageSize, keyword);

        // 获取分页信息对象
        return new PageInfo<>(totalCount, pageSize, pageNo, list);
    }
}
