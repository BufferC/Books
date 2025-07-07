package com.rg.servlet;

import com.rg.dao.UserDao;
import com.rg.dao.impl.UserDaoImpl;
import com.rg.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserDao userDao = new UserDaoImpl();

        User user = userDao.getUser(username);

        if (user != null) {
            req.setAttribute("message", "注册失败，该用户名已存在");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            int result = userDao.add(username, password);

            if (result > 0) {
                req.getRequestDispatcher("/register_success.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "注册失败");
                req.getRequestDispatcher("/register.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
