<%@page contentType="text/html; charset=utf-8" language="java" %>
<div class="userMenu">
    <ul>
        <c:if test="${not empty user}">
            <li><span>欢迎您，<strong>${user.uname}</strong></span>&nbsp;&nbsp;&nbsp;</li>
        </c:if>
        <c:if test="${empty user}">
            <li><a href="login.jsp">请登录</a></li>
        </c:if>
        <li class="${currentPage == 'index' ? 'current' : ''}"><a href="getBooks"><strong>首页</strong></a></li>
        <c:if test="${not empty user}">
            <li class="${currentPage == 'order' ? 'current' : ''}"><a href="getOrder">我的订单</a></li>
            <li class="${currentPage == 'cart' ? 'current' : ''}"><a href="getCart">购物车</a></li>
            <li><a href="logout">退出登录</a></li>
        </c:if>
        <c:if test="${currentPage == 'index'}">
            <li>
                <form method="get" action="search">
                    搜索：<input id="keyword" class="input-text" type="text" name="keyword"/>
                    <input type="submit" value="&nbsp;√&nbsp;">
                </form>
            </li>
        </c:if>
    </ul>
</div>