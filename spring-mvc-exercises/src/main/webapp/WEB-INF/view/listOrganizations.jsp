<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/1/2018
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Organizations</title>
</head>
<body>

    <c:out value="${greeting}"/> <br>

    <c:out value="${locationName}"/> <br/>

    <c:forEach var="org" items="${myOrgList}">
        <c:out value=":${org.companyName}"/><br>/>
        <c:out value=":${org.yearOfIncorporation} <br>"/>
        <c:out value=":${org.postalCode} <br>"/>
        <c:out value=":${org.slogan} <br>"/>
        <c:out value=":${org.employeeCount} <br><br><br>"/>
    </c:forEach>

</body>
</html>
