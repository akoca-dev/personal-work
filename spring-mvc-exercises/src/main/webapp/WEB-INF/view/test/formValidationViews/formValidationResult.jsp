<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/29/2018
  Time: 7:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <head>
        <spring:url value="/resources/test-main.css" var="testMainCSS"/>
        <link href="${testMainCSS}" rel="stylesheet"/>
        <title>Form Validation</title>
    </head>
</head>

<body>
    <h1>Congratulations...</h1>

    <h3>Name: ${organizationRepresentative.firstName} <br/>Last Name: ${organizationRepresentative.lastName}</h3>
    <h3>Age: ${organizationRepresentative.age} <br/></h3>
    <h3>Zip Code: ${organizationRepresentative.zipCode} <br/></h3>
    <h3>Email: ${organizationRepresentative.email} <br/></h3>
    <h3>Password: ${organizationRepresentative.password} <br/></h3>

    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <a href="${contextPath}/formValidation/home">Click to go to home:</a>
</body>
</html>
