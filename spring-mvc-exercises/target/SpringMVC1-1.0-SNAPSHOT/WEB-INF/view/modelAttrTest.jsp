<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/5/2018
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:if test="${newTestData1 != null && newTestData2 != null}">
        <h3>City: ${newTestData1}</h3>
        <h3>Zip Code: ${newTestData2}</h3>
        <br>
        <br>

        <h3>${anAddress}</h3>

        <h3>${address}</h3>
    </c:if>

    <c:if test="${newTestData3 != null}">
        <h3>New Address: ${newTestData3}</h3>
    </c:if>
</body>
</html>
