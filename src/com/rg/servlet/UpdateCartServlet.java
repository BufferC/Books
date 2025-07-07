package com.rg.servlet;

import com.rg.dao.BookDao;
import com.rg.dao.CartDao;
import com.rg.dao.impl.BookDaoImpl;
import com.rg.dao.impl.CartDaoImpl;
import com.rg.entity.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateCart")
public class UpdateCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cid = Integer.parseInt(req.getParameter("id"));
        int item = Integer.parseInt(req.getParameter("item"));
        int cnum = Integer.parseInt(req.getParameter("cnum"));
        int bid = Integer.parseInt(req.getParameter("bid"));

        CartDao cartDao = new CartDaoImpl();
        BookDao bookDao = new BookDaoImpl();
        Book book = bookDao.getById(bid);

        if (book.getBstock() - item <= 0) {
            req.setAttribute("message", "库存有限，无法再添加！");
        } else {
            cartDao.update(cid, item + cnum);
            if (item > 0) {
                bookDao.decr(item);
            } else {
                bookDao.incr(item);
            }
        }

        req.getRequestDispatcher("/getCart").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
