<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 21.06.2020
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="px" %>
<%@include file="language.jsp" %>


<html>
<head>
    <title>История заказов</title>
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
<table>
    <tr style="background-color: #dddddd">
        <th>
            <fmt:message key="history.order"/>
        </th>
        <th>
            <fmt:message key="header.date"/>
        </th>
        <th>
            <fmt:message key="history.status"/>
        </th>
    </tr>


    <c:forEach items="${requestScope.productBookings}" var="productBooking">
        <tr>
            <th>
                    ${productBooking.booking.id}
            </th>
            <th>
                    ${productBooking.booking.date}
            </th>
            <th>
                    ${productBooking.booking.bookingStatus.description}
            </th>
        </tr>

        <c:forEach items="${productBooking.products}" var="product">
            <tr>
                <th><img height="80" width="80" src="${product.img}"></th>
                <th> ${product.model}</th>
                <th> ${product.description}</th>
                <th><fmt:formatNumber value="${product.price}" type="CURRENCY" currencySymbol="р."/></th>
            </tr>
        </c:forEach>

        <tr>
            <th style="background-color: #dddddd">
                <fmt:message key="form.price"/> <px:priceSumTag products="${productBooking.products}"/>
            </th>
        </tr>

    </c:forEach>
</table>

</body>
</html>