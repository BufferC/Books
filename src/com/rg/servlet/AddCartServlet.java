package com.rg.servlet;

import com.rg.dao.BookDao;
import com.rg.dao.CartDao;
import com.rg.dao.impl.BookDaoImpl;
import com.rg.dao.impl.CartDaoImpl;
import com.rg.entity.Cart;
import com.rg.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addCart")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = (User) req.getSession(false).getAttribute("user");

        int result;

        BookDao bookDao = new BookDaoImpl();
        result = bookDao.decr(Integer.parseInt(id)); // 先减库存

        if (result > 0) {
            CartDao cartDao = new CartDaoImpl();
            Cart cart = cartDao.getCart(id, user.getUid()); // 查询购物车
            if (cart == null) {
                result = cartDao.add(id, user.getUid()); // 新增购物车记录
            } else {
                result = cartDao.update(cart.getCid(), cart.getCnum() + 1); // 购物车商品数量+1
            }

            if (result > 0) {
                resp.sendRedirect(req.getContextPath() + "/getCart");
            } else {
                bookDao.incr(Integer.parseInt(id));   // 添加购物车失败，恢复库存
                req.setAttribute("message", "加入购物车失败！");
                req.getRequestDispatcher("/getBooks").forward(req, resp);
            }
        } else {
            req.setAttribute("message", "库存没有啦！！");
            req.getRequestDispatcher("/getBooks").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
