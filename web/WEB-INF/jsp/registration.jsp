<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
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
        <p><span style="color: red; margin: 70px; font-size: x-large">РЕГИСТРАЦИЯ</span></p>
        <p>
            <label>Придумайте Ваш логин <br>
                <input type="text" name="login" placeholder="login" required>
            </label>
        </p>
        <p>
            <label>Придумайте Ваш пароль
                <input type="password" name="password" placeholder="password" required minlength="6" min="6"> <br>
            </label>
            минимум 6 символов
        </p>
        <p>
            <label>Повторите Ваш пароль
                <input type="password" name="repeatPassword" placeholder="password" required minlength="6" min="6">
            </label>
        </p>
        <button type="submit" name="command" value="registration"
                style="background: green; color: white">
            ЗАРЕГЕСТРИРОВАТЬСЯ
        </button>
    </form>
</div>

</body>
</html>
