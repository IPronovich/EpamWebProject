<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: koksR4
  Date: 02.06.2020
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="language.jsp" %>
<style>
    .divh2 {
        height: 12%; /* Размеры */
        outline: 1px solid darkgrey; /* Чёрная рамка */
        margin: auto;
        background: #ffce11;
    }
</style>


<div class="divh2">
    <div style="display: inline; margin-left: 50px">
        <a style="text-decoration: none" href="/catalog">
            <button type="submit"
                    style="background: #ffce11; font-family: Verdana ; font-weight: bold;border-radius: 20px;
                     color: black; height: 45px; width: auto; margin-top: 30px">
                <fmt:message key="header.catalog"/>
            </button>
        </a>
    </div>
    <div style="display: inline; margin-left: 50px">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/about">
            <button type="submit"
                    style="background: #ffce11; font-family: Verdana ;  font-weight: bold;border-radius: 20px;
                    color: black; height: 45px; width: auto; margin-top: 8px">
                <fmt:message key="header.about"/>
            </button>
        </a>

    </div>
    <div style="display: inline; margin-left: 50px">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/delivery">
            <button type="submit"
                    style="background: #ffce11;font-family: Verdana ;  font-weight: bold; ; border-radius: 20px;
                    color: black; height: 45px; width: auto; margin-top: 8px">
                <fmt:message key="header.delivery"/>
            </button>
        </a>

    </div>
    <div style="display: inline; margin-left: 50px">
        <a style="text-decoration: none" href="${pageContext.request.contextPath}/payment">
            <button type="submit"
                    style="background: #ffce11; font-family: Verdana ; font-weight: bold;border-radius: 20px;
                    color: black; height: 45px; width: auto; margin-top: auto">
                <fmt:message key="header.payment"/>
            </button>
        </a>
    </div>

    <c:if test="${not empty sessionScope.customer && sessionScope.customer.role.name().equals('ADMIN')}">
        <div style="display: inline; margin-left: 100px">
            <a style="text-decoration: none" href="/admin-page">
                <button type="submit"
                        style="background: #ffce11; font-family: Verdana ; font-weight: bold;border-radius: 20px;
                    color: black; height: 45px; width: auto; margin-top: auto">
                    <fmt:message key="header.adminPage"/>
                </button>
            </a>
        </div>
    </c:if>

</div>






