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

    <h1>Form Validation Test Bed</h1>

    <h3>Please Register</h3>
    <form:form action="registerOrganizationRepresentative" modelAttribute="organizationRepresentative">
        <form:label path="firstName" cssClass="clabel">First Name</form:label>
        <form:input path="firstName" cssClass="cinput" placeHolder="Enter first name"/>
        <form:errors path="firstName" cssClass="cb"/>


        <form:label path="lastName" cssClass="clabel">Last Name</form:label>
        <form:input path="lastName" cssClass="cinput" placeHolder="Enter last name"/>
        <form:errors path="lastName" cssClass="cb"/>


        <form:label path="age" cssClass="clabel">Age</form:label>
        <form:input path="age" cssClass="cinput" placeHolder="Enter age"/>
        <form:errors path="age" cssClass="cb"/>

        <form:label path="zipCode" cssClass="clabel">Zip Code:</form:label>
        <form:input path="zipCode" cssClass="cinput" placeHolder="Enter zip code"/>
        <form:errors path="zipCode" cssClass="cb"/>

        <form:label path="email" cssClass="clabel">Email:</form:label>
        <form:input path="email" cssClass="cinput" placeHolder="Email:"/>
        <form:errors path="email" cssClass="cb"/>

        <spring:hasBindErrors name="organizationRepresentative">
            <c:forEach items="${errors.globalErrors}" var="globalError">
                <c:if test="${fn:contains(globalError , 'Email')}">
                    <c:out value="${globalError.defaultMessage}"/>
                </c:if>
            </c:forEach>
        </spring:hasBindErrors>

        <form:label path="verifyEmail" cssClass="clabel">Verify Email:</form:label>
        <form:input path="verifyEmail" cssClass="cinput" placeHolder="Verify Email:"/>
        <form:errors path="verifyEmail" cssClass="cb"/>

        <form:label path="password" cssClass="clabel">Password:</form:label>
        <form:password path="password" cssClass="cinput" placeHolder="Password:"/>
        <form:errors path="password" cssClass="cb"/>

        <spring:hasBindErrors name="organizationRepresentative">
            <c:forEach items="${errors.globalErrors}" var="globalError">
                <c:if test="${fn:contains(globalError , 'Password')}">
                    <c:out value="${globalError.defaultMessage}"/>
                </c:if>
            </c:forEach>
        </spring:hasBindErrors>

        <form:label path="verifyPassword" cssClass="clabel">Verfiy Password:</form:label>
        <form:password path="verifyPassword" cssClass="cinput" placeHolder="Verify Password:"/>
        <form:errors path="verifyPassword" cssClass="cb"/>

        <input type="submit" value="Submit" class="csubmit"/>

        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

        <c:if test="${formErrors ne null}">
            <a href="${contextPath}/formValidation/home">Click to start a fresh form</a>
        </c:if>
    </form:form>

</body>
</html>
