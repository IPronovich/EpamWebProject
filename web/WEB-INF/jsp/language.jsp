<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 17.06.2020
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${not empty sessionScope.language ? sessionScope.language : 'ru_RU'}"/>
<fmt:setBundle basename="translation"/>
