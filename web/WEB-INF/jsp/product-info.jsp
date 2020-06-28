<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 06.06.2020
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <title>Olener ${requestScope.product.model}</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>
<style>
    table {
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
<table>
    <tr>
        <th>
            <img height="134" src="${requestScope.product.img}">

        </th>
        <th>
            <table>
                <tr style="border-color: white">
                    <th style="border-color: white">
                        ${requestScope.product.brand.name} ${requestScope.product.model}
                    </th>
                </tr>
                <tr>
                    <th width="700px" style="border-color: white">
                        ${requestScope.product.description}
                    </th>
                </tr>
            </table>
        </th>

        <th width="190px">
            <c:if test="${requestScope.product.quantity == 0}"><h2 style="text-align: center">Нет в наличии</h2></c:if>
            <c:if test="${requestScope.product.quantity != 0}"><h2
                    style="text-align: center">
                <fmt:formatNumber value=" ${requestScope.product.price}" type="CURRENCY" currencySymbol="р."/></h2>
            </c:if>
        </th>

        <c:if test="${not empty sessionScope.customer}">
            <th width="190px">
                <form action="/basket" method="post" style="display: inline">
                    <input type="hidden" value="${requestScope.product.id}" name="productId">
                    <button type="submit" name="command" value="add_to_basket"
                            style="background: orange; color: white; height: auto; width: auto; margin-left: 40px">
                        <h2 style="text-align: center">В корзину</h2>
                    </button>
                </form>
            </th>
        </c:if>

    </tr>
</table>
<f>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/review?id=${requestScope.product.id}">
        <button type="submit"
                style="border: 5px solid #dddddd; background: white; color: #0a0a49; height: 50px; width: auto;">
            <h2 style="text-align: center; display: inline">ОТЗЫВЫ ПОКУПАТЕЛЕЙ </h2>
            <h3 style="display: inline">${requestScope.count_review} </h3>
        </button>
    </a>

    <c:if test="${not empty sessionScope.customer && sessionScope.customer.role.name().equals('ADMIN')}">
    <form action="/admin-page" method="post" style="display: inline">
        <input type="hidden" value="${requestScope.product.id}" name="productId">
        <button type="submit" name="command" value="change_product_info_form"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            ИЗМЕНИТЬ
        </button>
    </form>
    </c:if>


</body>
</html>
