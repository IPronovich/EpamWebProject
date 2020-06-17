<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 04.06.2020
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="language.jsp" %>
<html>
<head>
    <title><fmt:message key="form.autorization"/></title>
    <style>
        div {
            width: 300px;
            height: 350px; /* Размеры */
            outline: 1px solid darkgrey; /* Чёрная рамка */
            border: 25px solid #fff; /* Белая рамка */
            border-radius: 20%; /* Радиус скругления */
            margin: auto;
            margin-top: 50px;
        }
    </style>
</head>
<body>

<div>
    <a style="text-decoration: none" href="${pageContext.request.contextPath}/olener">
        <img src="${pageContext.servletContext.contextPath}/images/logo.jpg" style="margin-top: 20px">
    </a>

    <form action="${pageContext.request.contextPath}/autorization" method="post">
        <p><span style="color: red; margin: 70px; font-size: x-large"><fmt:message key="form.autorization"/> </span></p>
        <p>
            <label><fmt:message key="form.messageLogin"/> <br>
                <input type="text" name="login" placeholder="login">
            </label>
        </p>
        <p>
            <label><fmt:message key="form.messagePassword"/>
                <input type="password" name="password" placeholder="password">
            </label>
        </p>

        <button type="submit" name="command" value="autorization"
                style="background: green; color: white">
            <fmt:message key="header.signIn"/>
        </button>

        <p>
            <a href="${pageContext.request.contextPath}/registration"> <fmt:message key="form.messageRegistration"/></a>
        </p>
    </form>

</div>
</body>
</html>
