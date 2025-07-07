package com.rg.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "characterEncoding", value = "UTF-8"),
                @WebInitParam(name = "contextType", value = "text/html; charset=UTF-8")})
public class EncodingFilter implements Filter {
    // 声明编码集和文本内容
    private String characterEncoding;
    private String contextType;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 通过过滤器配置对象中的初始化参数获取编码集和文本内容
        characterEncoding = filterConfig.getInitParameter("characterEncoding");
        contextType = filterConfig.getInitParameter("contextType");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String uri = request.getRequestURI();
        if (!uri.startsWith(request.getContextPath() + "/images/") && !uri.startsWith(request.getContextPath() + "/css")) {
            // 设置请求和响应对象的编码集
            request.setCharacterEncoding(characterEncoding);
            response.setContentType(contextType);
        }

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
