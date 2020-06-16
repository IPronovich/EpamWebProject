<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 05.06.2020
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
    <style>
        div {
            width: 300px;
            height: 450px; /* Размеры */
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

    <form action="${pageContext.request.contextPath}/profile" method="post">
        <p><span style="color: red; margin: 30px; font-size: x-large">Личные данные</span></p>
        <p>
            <label>Email <br>
                <input type="text" name="email" value="${sessionScope.customer.email}">
            </label>
        </p>
        <p>
            <label>Имя <br>
                <input type="text" name="name" value="${sessionScope.customer.name}">
            </label>
        </p>
        <p>
            <label>Фамилия <br>
                <input type="text" name="lastName" value="${sessionScope.customer.lastName}">
            </label>
        </p>
        <p>
            <label>Адресс <br>
                <input type="text" name="address" value="${sessionScope.customer.address}">
            </label>
        </p>
        <p>
            <label>Телефон <br>
                <input type="text" name="phone" value="${sessionScope.customer.phoneNumber}">
            </label>
        </p>

        <button type="submit" name="command" value="save_user_changes"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            Сохранить изменения
        </button>
    </form>

</div>
</body>
</html>
