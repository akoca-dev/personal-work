<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/1/2018
  Time: 1:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Org Home Page</h1>

    <p>Welcome ${greeting}</p>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/location">Click to get org details</a>
</body>
</html>