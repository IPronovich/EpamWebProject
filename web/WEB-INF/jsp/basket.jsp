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
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>

<c:if test="${ empty sessionScope.basket}">
    <h1> Ваша корзина пуста</h1>
</c:if>

<c:if test="${not empty sessionScope.basket}">
    <form action="/basket" method="post">

        <c:forEach var="product" items="${sessionScope.basket}">

        <input type="hidden" value="${product.id}" name="productId">


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

                <th>
                    <button type="submit" name="command" value="delete_product_from_basket">
                        Удалить
                    </button>
                </th>

                <th width="190px">

                    <fmt:formatNumber value="${product.price}" type="CURRENCY" currencySymbol="р."/>
                </th>

            </tr>


            </c:forEach>

    </form>

    <table>

        <div>
            На сумму <fmt:formatNumber value="${sessionScope.sum}" type="CURRENCY" currencySymbol="р."/>
        </div>

    </table>

</c:if>


</body>

</html>
