<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Каталог Olener</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<jsp:include page="secondHeader.jsp"></jsp:include>


<c:forEach var="category" items="${requestScope.catalog}">
    <div style="width: 300px; height:auto; outline: 1px solid darkgrey; border: 5px outset black; text-align: center;
             vertical-align: middle">

        <a style="text-decoration: none"
           href="${pageContext.request.contextPath}/catalog?id=${category.id}"> ${category.description} </a> <br>
    </div>

</c:forEach>
</body>
</html>
