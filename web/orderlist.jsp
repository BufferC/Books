<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>网上书城</title>
    <link type="text/css" rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="header" class="wrap">
    <div id="banner"></div>
    <div id="navbar">
        <c:set var="currentPage" value="order" scope="request"/>
        <%@include file="top.jsp"%>
    </div>
</div>

<div id="content" class="wrap">
    <div class="list orderList">
        <c:if test="${empty orders}">
            <div style="text-align: center"><h2>暂无订单信息！</h2></div>
        </c:if>
        <c:if test="${not empty orders}">
            <table style="width:1000px;margin:5px auto">
                <tr class="title">
                    <th class="orderId">订单编号</th>
                    <th class="view">图书图片预览</th>
                    <th class="title">书名</th>
                    <th class="price">商品价格</th>
                    <th class="nums">商品数量</th>
                    <th class="createTime">下单时间</th>
                    <th class="status">订单总价</th>
                </tr>
                <c:forEach items="${orders}" var="order">
                    <tr>
                        <td>${order.oid}</td>
                        <td class="thumb"><img src="${order.bimg}" style="width:120px"/></td>
                        <td>${order.bname}</td>
                        <td>${order.bprice}</td>
                        <td>${order.onum}</td>
                        <td>${order.str_time}</td>
                        <td>${order.total_bprice}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>
</body>
</html>

