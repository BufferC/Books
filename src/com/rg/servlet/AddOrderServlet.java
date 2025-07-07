package com.rg.servlet;

import com.rg.dao.CartDao;
import com.rg.dao.OrderDao;
import com.rg.dao.impl.CartDaoImpl;
import com.rg.dao.impl.OrderDaoImpl;
import com.rg.entity.User;
import com.rg.vo.CartVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        synchronized (this) {
            User user = (User) session.getAttribute("user");

            CartDao cartDao = new CartDaoImpl();

            List<CartVO> allCartVO = cartDao.getAllCartVO(user.getUid());

            int result;

            for (CartVO cartVO : allCartVO) {
                OrderDao orderDao = new OrderDaoImpl();

                result = orderDao.add(cartVO.getBid(), cartVO.getCnum(), user.getUid());
                if (result == 0) {
                    break;
                }
            }

            result = cartDao.clear(user.getUid());

            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/buy_success.jsp");
            } else {
                req.setAttribute("message", "下单失败！");
                req.getRequestDispatcher("getCart").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
