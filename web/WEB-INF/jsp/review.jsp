<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 08.06.2020
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
    table {
        font-family: arial, sans-serif;
        border-collapse: collapse;
        width: 50%;
    }

    td, th {
        border: 5px solid #dddddd;
        text-align: left;
        padding: 8px;
    }

    tr:nth-child(even) {
        background-color: #dddddd;
    }
</style>

<html>
<head>
    <title>Отзывы</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>

<div>
    <c:if test="${ empty sessionScope.customer}">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/autorization">
            <button type="submit"
                    style="border: 5px solid white; background: #14ad14; color:white;  border-radius: 10px; height: 50px; width: auto;">
                <h2 style="text-align: center; display: inline">ОСТАВИТЬ ОТЗЫВ </h2>
            </button>
        </a>

    </c:if>

    <c:if test="${not empty sessionScope.customer}">

    <form action="/review" method="post" style="display: inline">
        <input type="hidden" value="${requestScope.prod_id}" name="id">
        <button type="submit" name="command" value="review_form"
                style="border: 5px solid white; background: #14ad14; color:white;
                  border-radius: 10px; height: 50px; width: auto;">
            <h2 style="text-align: center; display: inline">ОСТАВИТЬ ОТЗЫВ </h2>
        </button>

        <h3 style="display: inline"> Ваш отзыв может значительно повлиять на выбор товара или услуги</h3>
        </c:if>

</div>

<c:forEach var="review" items="${requestScope.reviews}">

    <table>
        <tr>
            <th style="color: blue">${review.customer.login}</th>
        </tr>
        <tr>
            <th> ${review.title} </h2></th>
        </tr>
        <tr>
            <td>${review.text}</td>
        </tr>
    </table>
</c:forEach>


</body>
</html>