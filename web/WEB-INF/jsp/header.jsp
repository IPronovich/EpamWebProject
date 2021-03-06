<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="language.jsp" %>
<link href="/bootstrap/1/css/bootstrap.min.css" rel="stylesheet">
<link href="/bootstrap/1/css/bootstrap-theme.min.css" rel="stylesheet">

<style>
    .divT {
        height: 12%; /* Размеры */
        outline: 1px solid darkgrey; /* Чёрная рамка */
        border: 25px solid #fff; /* Белая рамка */
        border-radius: 20%; /* Радиус скругления */
        margin: auto;
    }
</style>


<div class="divT">

    <div style="display: inline">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/olener">
            <img src="${pageContext.servletContext.contextPath}/images/logo.jpg">
        </a>

    </div>

    <div style="display: inline; margin-left: 50px">

        <form action="${pageContext.request.contextPath}/search" method="post" style="display: inline">

            <input type="text" name="text" style="height: 40px" size="140" placeholder="Поиск в каталоге. Например,
&#34;мобильный телефон&#34;">

            <button type="submit" name="command" value="search"
                    style="background: red; color: white; height: 40px; width: 75px">
                <fmt:message key="header.search"/>
            </button>
        </form>
    </div>

    <c:if test="${ empty sessionScope.customer}">
        <div style="display: inline; margin-left: 50px">
            <a style="text-decoration: none" href="/authentication">
                <button type="submit"
                        style="background: silver; border-radius: 20px; color: black; height: 40px; width: 75px">
                    <fmt:message key="header.signIn"/>
                </button>
            </a>

        </div>

    </c:if>


    <c:if test="${not empty sessionScope.customer}">
        <div style="display: inline; margin-left: 50px">
            <a style="text-decoration: none" href="/profile">
                <button type="submit"
                        style="background: silver; border-radius: 20px; color: black; height: 40px; width: auto">
                        ${sessionScope.customer.login}
                </button>
            </a>

        </div>
    </c:if>

    <div style="display: inline">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/basket">
            <img src="${pageContext.servletContext.contextPath}/images/basket2.png" width="50" , height="50">
            <c:if test="${not empty sessionScope.basket}">
                ${sessionScope.basket.size()}
            </c:if>

        </a>

    </div>

    <form action="/olener" method="post" style="display: inline; margin-left: 220px;">
        <input hidden name="command" value="lokalization">
        <button type="submit" name="language" value="ru_RU">RUS</button>
        <button type="submit" name="language" value="en_US">ENG</button>
    </form>


</div>






