<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/2/2018
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test Results</title>
</head>
<body>

    <h1>${testSerial} Mapping test results</h1>

    <c:forEach var="parameter" items="${param}">
        <c:out value="${parameter.key}"/> = <c:out value="${parameter.value}"/>
    </c:forEach>

    <h3>${theOrgName}</h3><br>
    <h3>${theEmpCount}</h3><br>
    <h3>${since}</h3><br>
    <h3>${area}</h3><br>
</body>
</html>
