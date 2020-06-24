<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 16.06.2020
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="px" %>

<html>
<head>
    <title>КОРЗИНА</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>
<%@include file="language.jsp" %>
<style>
    table {
        font-family: arial, sans-serif;
        width: 60%;
    }

    th {
        border: 1px solid #dddddd;
        text-align: -moz-center;
        padding: 8px;
    }
</style>

<c:if test="${ empty sessionScope.basket}">
    <h1> Ваша корзина пуста</h1>
</c:if>

<c:if test="${not empty sessionScope.basket}">
    <form action="/basket" method="post">
        <c:forEach var="product" items="${sessionScope.basket}">
            <table>
                <tr>
                    <th>
                        <a style="text-decoration: none"
                           href="${pageContext.request.contextPath}/productInfo?id=${product.id}">
                            <img src="${product.img}"> </a>
                    </th>
                    <th>
                        <table style="width: auto">
                            <tr>
                                <th>
                                    <a style="text-decoration: none"
                                       href="${pageContext.request.contextPath}/productInfo?id=${product.id}">
                                            ${product.brand.name} ${product.model} </a>
                                </th>
                            </tr>
                            <tr>
                                <th>
                                        ${product.description}
                                </th>
                            </tr>
                        </table>
                    </th>
                    <th>
                        <form action="/basket" method="post">
                            <input type="hidden" name="prodId" value="${product.id}">
                            <button type="submit" name="command" value="delete_from_basket">
                                Удалить
                            </button>
                        </form>
                    </th>
                    <th>
                        <fmt:formatNumber value="${product.price}" type="CURRENCY" currencySymbol="р."/>
                    </th>
                </tr>
            </table>
        </c:forEach>
    </form>

    <table>
        <tr>
            <th style="background-color: #dddddd">
                СУММА <px:priceSumTag products="${sessionScope.basket}"/>
            </th>
        </tr>
    </table>

    <form action="/basket" method="post">
        <button type="submit" name="command" value="checkout"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            ОФОРМИТЬ ЗАКАЗ
        </button>
    </form>
</c:if>

</body>

</html>
