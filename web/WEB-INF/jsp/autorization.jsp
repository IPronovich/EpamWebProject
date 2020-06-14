<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 04.06.2020
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
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
        <p><span style="color: red; margin: 70px; font-size: x-large">АВТОРИЗАЦИЯ</span></p>
        <p>
            <label>Введите Ваш логин <br>
                <input type="text" name="login" placeholder="login">
            </label>
        </p>
        <p>
            <label>Введите Ваш пароль
                <input type="password" name="password" placeholder="password">
            </label>
        </p>

        <button type="submit" name="command" value="autorization"
                style="background: green; color: white">
            ВОЙТИ
        </button>

        <p>
            <a href="${pageContext.request.contextPath}/registration"> Зарегестрироваться на сайте</a>
        </p>
    </form>

</div>
</body>
</html>
