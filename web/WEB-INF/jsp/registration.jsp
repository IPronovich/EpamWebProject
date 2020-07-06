<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="language.jsp" %>
<html>
<head>
    <title><fmt:message key="form.registration"/></title>
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
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <p><span style="color: red; margin: 70px; font-size: x-large"><fmt:message key="form.registration"/> </span></p>
        <p>
            <label><fmt:message key="form.messageRegistrLogin"/><br>
                <input type="text" name="login" placeholder="login" required>
            </label>
        </p>
        <p>
            if ${not empty requestScope.wronPas}{
            плохой пароль

            <label><fmt:message key="form.messageRegistrPassword"/>
                <input type="password" name="password" placeholder="password" required minlength="6"> <br>
            </label>
            <fmt:message key="form.messageRegistrMinSymbol"/>
        </p>
        <p>
            <label><fmt:message key="form.messageRegistrPasswordRepeat"/>
                <input type="password" name="repeatPassword" placeholder="password" required minlength="6">
            </label>
        </p>
        <button type="submit" name="command" value="registration"
                style="background: green; color: white">
            <fmt:message key="ok"/>
        </button>
    </form>
</div>

</body>
</html>
