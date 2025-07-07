package com.rg.servlet;

import com.rg.dao.OrderDao;
import com.rg.dao.impl.OrderDaoImpl;
import com.rg.entity.User;
import com.rg.vo.OrderVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet("/getOrder")
public class GetOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession(false).getAttribute("user");

        OrderDao orderDao = new OrderDaoImpl();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        List<OrderVO> list = orderDao.getOrderVOs(user.getUid());
        for (OrderVO orderVO : list) {
            orderVO.setStr_time(formatter.format(orderVO.getOtime()));
        }
        req.setAttribute("orders", list);
        req.getRequestDispatcher("orderlist.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
