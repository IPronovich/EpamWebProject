<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 06.06.2020
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@include file="language.jsp" %>


<html>
<head>
    <title>PRODUCT Olener</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>

<style>
    .tableH {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: auto;
    }

    td, th {
        border: 1px solid #dddddd;
        text-align: left;
        padding: 8px;
    }
</style>

<c:if test="${empty requestScope.products}">
    НИЧЕГО НЕ НАЙДЕНО
</c:if>

<c:forEach var="product" items="${requestScope.products}">

    <table class="tableH">
        <tr>
            <th>
                <a style="text-decoration: none"
                   href="${pageContext.request.contextPath}/productInfo?id=${product.id}">
                    <img width="auto" height="auto" src="${product.img}"> </a>
            </th>
            <th>
                <table>
                    <tr style="border-color: white">
                        <th style="border-color: white">
                            <a style="text-decoration: none"
                               href="${pageContext.request.contextPath}/productInfo?id=${product.id}">
                                    ${product.brand.name} ${product.model} </a>
                        </th>
                    </tr>
                    <tr>
                        <th width="700px" style="border-color: white">
                                ${product.description}
                        </th>
                    </tr>
                </table>
            </th>

            <th width="190px">
                <c:if test="${product.quantity == 0}"><h2 style="text-align: center">Нет в наличии</h2></c:if>
                <c:if test="${product.quantity != 0}"><h2 style="text-align: center">
                    <fmt:formatNumber value="${product.price}" type="CURRENCY" currencySymbol="р."/></h2></c:if>
            </th>

        </tr>
    </table>
</c:forEach>

</body>
</html>