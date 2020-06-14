<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 09.06.2020
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ДОБАВЛЕНИЕ ТОВАРА</title>
    <style>
        div {
            width: 500px;
            height: auto; /* Размеры */
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

    <form action="${pageContext.request.contextPath}/admin-page" method="post">
        <p><span style="color: red; margin: 70px; font-size: x-large">ИЗМЕНЕНИЕ ИНФОРМАЦИИ О ТОВАРЕ</span></p>

        <input type="hidden" value="${requestScope.product.id}" name="productId">

        <p>
            <label>Категоря товара <br>
                <select name="catalogId">
                    <c:forEach var="catalog" items="${requestScope.catalog}">
                        <option value="${catalog.id}">${catalog.description}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <p>
            <label>Производитель <br>
                <select name="brandId">
                    <c:forEach var="brand" items="${requestScope.brands}">
                        <option value="${brand.id}">${brand.name}</option>
                    </c:forEach>
                </select>
            </label>
        </p>
        <p>
            <label>Модель<br>
                <input type="text" style="font-size: x-large" name="model" value="${requestScope.product.model}">
            </label>
        </p>
        <p>
            <label>Описание
                <textarea style="font-size: x-large" cols=40 rows=10 name="description">
                    ${requestScope.product.description}
                </textarea>
            </label>
        </p>
        <p>
            <label>Цена<br>
                <input type="text" style="font-size: x-large" name="price" value="${requestScope.product.price}">
            </label>
        </p>
        <p>
            <label>Фото<br>
                <input type="text" style="font-size: x-large" name="img" value="${requestScope.product.img}">
            </label>
        </p>
        <p>
            <label>Количество<br>
                <input type="text" style="font-size: x-large" name="quantity" value="${requestScope.product.quantity}">
            </label>
        </p>

        <button type="submit" name="command" value="save_product_changes"
                style="background: green; border-radius: 10px; color: white; height: 40px; width:auto">
            Сохранить изменения
        </button>
    </form>
</div>
    
</body>
</html>
