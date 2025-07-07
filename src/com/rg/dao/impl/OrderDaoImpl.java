package com.rg.dao.impl;

import com.rg.dao.OrderDao;
import com.rg.utils.JdbcUtils;
import com.rg.vo.OrderVO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    QueryRunner runner = new QueryRunner();
    Connection connection = JdbcUtils.getConnection();
    @Override
    public int add(int bid, int cnum, int uid) {

        String sql = "insert into bookorder(bid, onum, uid) values (?, ?, ?)";

        try {
            return runner.update(connection, sql, bid, cnum, uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<OrderVO> getOrderVOs(int uid) {
        String sql = "select oid, book.bid, onum, otime, bprice, bname, (bprice * onum) as total_bprice, bimg from bookorder inner join book on book.bid = bookorder.bid where uid = ? order by otime desc";

        try {
            return runner.query(connection, sql, new BeanListHandler<>(OrderVO.class), uid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
