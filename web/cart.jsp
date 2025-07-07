<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:set var="currentPage" value="cart" scope="request"/>
        <%@include file="top.jsp"%>
    </div>
</div>
<div id="content" class="wrap">
    <div class="list bookList">
        <c:if test="${empty carts}">
            <div style="text-align: center"><h2>购物车空空如也，快去买些书籍吧！</h2></div>
        </c:if>
        <c:if test="${not empty carts}">
            <form method="post" name="shoping" action="addOrder">
                <table>
                    <tr class="title">
                        <th class="view">图片预览</th>
                        <th class="title">书名</th>
                        <th class="nums">数量</th>
                        <th class="price">价格</th>
                        <th class="nums">合计</th>
                    </tr>


                    <c:forEach items="${carts}" var="cart">
                        <tr>
                            <td class="thumb"><img src="${cart.bimg}"/></td>
                            <td class="title">${cart.bname}</td>
                            <td>
                                <div class="btn-group">
                                    <button type="button" class="btn-minus" onclick="updateCart('${cart.cid}', -1, '${cart.cnum}', '${cart.bid}')">－</button>
                                    <button disabled class="btn-quantity">${cart.cnum}</button>
                                    <button type="button" class="btn-plus" onclick="updateCart('${cart.cid}', 1, '${cart.cnum}', '${cart.bid}')">＋</button>
                                </div>
                            </td>
                            <td>￥${cart.bprice}元</td>
                            <td>￥${cart.bprice * cart.cnum}元</td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="5">
                            <div class="button">
                                <h4>总价：￥${sum}元</h4>
                                <input type="hidden" id="hidden_total_price" name="hidden_total_price"/>
                                <input class="input-chart" type="submit" name="submit" value=""/>
                            </div>
                        </td>
                    </tr>
                </table>
            </form>
        </c:if>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城 &copy; 版权所有
</div>
</body>
<script>
    var value = '${message}';

    if (value) {
        alert(value);
    }
</script>
<script>
    function updateCart(cid, item, cnum, bid) {
        location.href = "updateCart?id=" + cid + "&item=" + item + "&cnum=" + cnum + "&bid=" + bid;
    }
</script>
</html>

