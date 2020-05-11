<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/6/2018
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <spring:url value="/resources/main-test.css" var="testMainCss"/>
    <link href="${testMainCss}" rel="stylesheet"/>

    <title>Session Attr Results</title>
</head>
<body>

    <h3>${timeHeading}</h3>
    <h3>${durationHeading}</h3>

    <h3>No of visits in this session</h3>
    <c:out value="${visitorCount.count}"/>

    <h3>Visitors List</h3>

    <c:forEach var="visitor" items="${visitorData.visitorList}">
        <c:out value="${visitor.name}----${visitor.email}"/><br><br>
    </c:forEach>


    <br><br>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    <a href="${contextPath}/registerVisitor/home">Generate another visit</a>

</body>
</html>
