<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/2/2018
  Time: 6:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Request Map And Param Home</title>
</head>
<body>
    <h1>Welcome to test Home</h1>

    <form action="test1">
        <input type="text" name="orgName" placeholder="Enter Org Name"/>
        <input type="submit" value="submit"/>
    </form>

    <form action="test2" method="get">
        <input type="text" name="orgName" placeholder="Enter Org Name"/>
        <input type="submit" value="submit"/>
    </form>

    <form action="test3" method="get">
        <input type="submit" value="submit"/>
    </form>

    <form action="test4" method="get">
        <input type="text" name="orgName" placeholder="Enter Org Name"/>
        <input type="submit" value="submit"/>
    </form>

    <form action="test5" method="get">
        <input type="text" name="orgName" placeholder="Enter Org Name"/>
        <input type="submit" value="submit"/>
    </form>
</body>
</html>
