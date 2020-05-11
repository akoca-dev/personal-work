<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/6/2018
  Time: 4:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<html>
<head>
    <spring:url value="/resources/main-test.css" var="testMainCss"/>
    <link href="${testMainCss}" rel="stylesheet"/>
    <%--<link href="c:url value="/resources/main-test.css"/>" rel = "stylesheet"/--%>
    <title>Session Attr Home</title>
</head>
<body>
        <h1>Session attr test bed</h1>

        <form:form action="visitor" modelAttribute="visitorStats">
            <form:label path="currentVisitorName">Name:</form:label>
            <form:input path="currentVisitorName"/>

            <form:label path="currentVisitorEmail">Email:</form:label>
            <form:input path="currentVisitorEmail"/>

            <input type="submit" value="Submit"/>
        </form:form>
</body>
</html>
