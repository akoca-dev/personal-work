<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/1/2018
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Location</title>
</head>
<body>
    <c:out value="${greeting}"/>

    <form action="listOrgs">
        <input type="text" name="locationName">
        <input type="submit" value="List Orgs"/>
    </form>
</body>
</html>
