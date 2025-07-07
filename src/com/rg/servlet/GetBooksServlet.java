package com.rg.servlet;

import com.rg.entity.Book;
import com.rg.entity.PageInfo;
import com.rg.utils.BookPageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/getBooks")
public class GetBooksServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取当前页
        String param = req.getParameter("pageNo");

        // 如果没有传递当前页，默认就是第一页
        int pageNo = 1;

        if (param != null) {
            pageNo = Integer.parseInt(param);
        }

        // 规定好每页显示多少条数据
        int pageSize = 4;

        BookPageUtils pageUtils = new BookPageUtils();
        PageInfo<Book> pageInfo = pageUtils.getPageInfo(pageNo, pageSize, null);

        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
