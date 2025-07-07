package com.rg.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将请求和响应对象强转为支持HTTP协议的对象
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);

        String uri = request.getRequestURI();

        if (uri.startsWith(request.getContextPath() + "/images/") || uri.startsWith(request.getContextPath() + "/css") || uri.endsWith("/login.jsp") || uri.endsWith("/login") || uri.endsWith("/relogin.jsp") || uri.endsWith("/register") || uri.endsWith("/register.jsp") || uri.endsWith("/register_success.jsp")) {// 判断请求URI是否以指定登录路径结尾
            filterChain.doFilter(request, response);// 放行
        } else if (session == null) {// 如果session为空，说明没有登录，跳转至登录页面
            response.sendRedirect("relogin.jsp");
        } else if (session.getAttribute("user") != null) {// session不为空，并且user参数也不为空
            filterChain.doFilter(request, response);// 放行
        } else {
            response.sendRedirect("login.jsp");// 跳转至登录页面
        }
    }

    @Override
    public void destroy() {
    }
}