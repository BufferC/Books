<%@page contentType="text/html; charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <c:set var="currentPage" value="index" scope="request"/>
        <%@include file="top.jsp"%>
    </div>
</div>
<div id="content" class="wrap">
    <div class="list bookList">
        <c:if test="${not empty pageInfo}">
            <form method="post" name="shoping">
                <table>
                    <tr class="title">
                        <th class="title">书名</th>
                        <th class="info">简介</th>
                        <th class="price">价格</th>
                        <th class="store">库存</th>
                        <th class="view">图片预览</th>
                        <th class="button">操作</th>
                    </tr>

                    <c:forEach items="${pageInfo.list}" var="book">
                        <tr style="height: 150px">
                            <td class="title" style="text-align: center">${book.bname}</td>
                            <td class="info">
                                <div class="text-wrapper">
                                        ${book.btext}
                                </div>
                            </td>
                            <td>¥${book.bprice}</td>
                            <td>${book.bstock}</td>
                            <td class="thumb"><img src="${book.bimg}"/></td>
                            <td class="button">
                                <button class="input-btn" type="button"
                                        onclick="addCart(${book.bid}, ${book.bstock})"></button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="page-spliter">
                        <%--如果当前页为第一页，则首页和上一页设置无法选中--%>
                    <c:if test="${pageInfo.pageNo == 1}">
                        <a href="javascript:return false;" style="text-decoration: none; color: orangered">首页</a>
                        <a href="javascript:return false;" style="text-decoration: none; color: orangered">上一页</a>
                    </c:if>
                        <%--如果当前不为第一页--%>
                    <c:if test="${pageInfo.pageNo != 1}">
                        <c:if test="${not empty keyword}">
                            <a href="search?pageNo=1&keyword=${keyword}" style="text-decoration: none">首页</a>
                            <a href="search?pageNo=${pageInfo.pageNo - 1}&keyword=${keyword}" style="text-decoration: none">上一页</a>
                        </c:if>
                        <c:if test="${empty keyword}">
                            <%--设置首页直接跳转为第一页，传递pageNo为1--%>
                            <a href="getBooks?pageNo=1" style="text-decoration: none">首页</a>
                            <%--设置上一页，传递pageNo为 当前页 - 1--%>
                            <a href="getBooks?pageNo=${pageInfo.pageNo - 1}" style="text-decoration: none">上一页</a>
                        </c:if>
                    </c:if>
                        <%--遍历当前页数--%>
                    <c:forEach var="pageNo" begin="1" end="${pageInfo.pageCount}">
                        <%--如果是当前页，就设置不可点击--%>
                        <c:if test="${pageNo == pageInfo.pageNo}">
                            <a class="current" href="javascript:return false;"
                               style="text-decoration: none; color: orangered">${pageNo}</a>
                        </c:if>
                        <%--非当前页设置可点击--%>
                        <c:if test="${pageNo != pageInfo.pageNo}">
                            <c:if test="${not empty keyword}">
                                <a style="text-decoration: none" href="search?pageNo=${pageNo}&keyword=${keyword}">${pageNo}</a>
                            </c:if>
                            <c:if test="${empty keyword}">
                                <a style="text-decoration: none" href="getBooks?pageNo=${pageNo}">${pageNo}</a>
                            </c:if>
                        </c:if>
                    </c:forEach>
                        <%--如果当前页为最后一页，则尾页和下一页设置无法选中--%>
                    <c:if test="${pageInfo.pageNo == pageInfo.pageCount}">
                        <a href="javascript:return false;" style="text-decoration: none; color: orangered">下一页</a>
                        <a href="javascript:return false;" style="text-decoration: none; color: orangered">尾页</a>
                    </c:if>

                        <%--如果当前不为最后一页--%>
                    <c:if test="${pageInfo.pageNo != pageInfo.pageCount}">
                        <c:if test="${not empty keyword}">
                            <%--设置下一页，传递pageNo为 当前页 + 1--%>
                            <a href="search?pageNo=${pageInfo.pageNo + 1}&keyword=${keyword}" style="text-decoration: none">下一页</a>
                            <%--设置尾页直接跳转为最后一页，传递pageNo为总页数--%>
                            <a href="search?pageNo=${pageInfo.pageCount}&keyword=${keyword}" style="text-decoration: none">尾页</a>
                        </c:if>
                        <c:if test="${empty keyword}">
                            <%--设置下一页，传递pageNo为 当前页 + 1--%>
                            <a href="getBooks?pageNo=${pageInfo.pageNo + 1}" style="text-decoration: none">下一页</a>
                            <%--设置尾页直接跳转为最后一页，传递pageNo为总页数--%>
                            <a href="getBooks?pageNo=${pageInfo.pageCount}" style="text-decoration: none">尾页</a>
                        </c:if>
                    </c:if>
                    共${pageInfo.totalCount}条内容，共${pageInfo.pageCount}页
                </div>
            </form>
        </c:if>
    </div>
</div>
<div id="footer" class="wrap">
    网上书城&copy;版权所有
</div>
<script>
    var value = '${message}';

    if (value) {
        alert(value);
    }

    if ('${keyword}') {
        document.getElementById('keyword').value = '${keyword}';
    }
</script>
<script>
    function addCart(id, stock) {
        if (stock > 0) {
            location.href = "addCart?id=" + id;
        } else {
            alert('库存不足，无法购买！！')
        }
    }
</script>
</body>
</html>