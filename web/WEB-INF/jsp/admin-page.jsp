<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 09.06.2020
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>OLener</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>

<form action="/admin-page" method="post" style="display: inline">
    <button type="submit" name="command" value="add_product_form"
            style="border: 5px solid white; background: #14ad14; color:white;  border-radius: 10px; height: 50px; width: auto;">
        <h2 style="text-align: center; display: inline">ДОБАВИТЬ ТОВАР </h2>
    </button>
    <button type="submit" name="command" value="show_orders"
            style="border: 5px solid white; background:skyblue; color:white;  border-radius: 10px; height: 50px; width: auto;">
        <h2 style="text-align: center; display: inline"> ЗАКАЗЫ </h2>
    </button>
</form>
</body>
</html>