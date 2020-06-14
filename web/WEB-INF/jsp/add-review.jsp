<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 08.06.2020
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Olener</title>
    <style>
        div {
            width: 500px;
            height: 600px; /* Размеры */
            outline: 5px solid darkgrey; /* Чёрная рамка */
            border: 25px solid #fff; /* Белая рамка */
            border-radius: 20%; /* Радиус скругления */
            margin: auto;
            margin-top: 50px;
        }
    </style>
</head>
<body>
<div>
    <img src="${pageContext.servletContext.contextPath}/images/test.jpg" style="margin-top: 20px">
    <form action="${pageContext.request.contextPath}/review" method="post">
        <p><span style="color: blue; margin: 70px; font-size: x-large">ВАШ ОТЗЫВ</span></p>

        <input type="hidden" value="${requestScope.prod_id}" name="id">
        <p>
            <label>Заголовок<br>
                <textarea style="font-size: x-large" cols=40 rows=2 wrap="hard" maxlength=120 name="title" required>

                </textarea>
            </label>
        </p>
        <p>
            <label>Ваш отзыв об этой модели
                <textarea style="font-size: x-large" cols=40 rows=10 wrap="hard" maxlength=420 name="text">
                </textarea>
            </label>

        </p>

        <button type="submit" name="command" value="add_review"
                style="border: 5px solid white; background: #14ad14; color:white;  border-radius: 10px; height: 50px; width: auto;">
            <h2 style="text-align: center; display: inline">ОСТАВИТЬ ОТЗЫВ </h2>
        </button>
    </form>
</div>

</body>
</html>
