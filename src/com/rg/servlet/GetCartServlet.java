package com.rg.servlet;

import com.rg.dao.CartDao;
import com.rg.dao.impl.CartDaoImpl;
import com.rg.entity.User;
import com.rg.vo.CartVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@WebServlet("/getCart")
public class GetCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession(false).getAttribute("user");

        CartDao cartDao = new CartDaoImpl();

        List<CartVO> cartVOs = cartDao.getAllCartVO(user.getUid());

        BigDecimal sum = new BigDecimal(0);
        for (CartVO cartVO : cartVOs) {
            sum = sum.add(cartVO.getTotal_bprice());
        }

        req.setAttribute("sum", sum);
        req.setAttribute("carts", cartVOs);
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
