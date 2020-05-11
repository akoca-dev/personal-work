<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/11/2018
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <spring:url value="/resources/test-main.css" var="testMainCSS"/>
    <link href="${testMainCSS}" rel="stylesheet"/>
    <title>Form Tags Result</title>
</head>
<body>
        <h3>Org Name is: ${registeredOrganization.organizationName}</h3>
        <h3>Org Name is: ${registeredOrganization.country}</h3>

        <h3>Turnover:
            <c:forEach var="entry" items="${turnoverList}">
                <c:if test="${registeredOrganization.turnover eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>

        <h3>Type:
            <c:forEach var="entry" items="${typeList}">
                <c:if test="${registeredOrganization.type eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>

        <h3>Since:
            <c:forEach var="entry" items="${serviceLengthList}">
                <c:if test="${registeredOrganization.since eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>

        <h3>Registered Previously?:
            <c:forEach var="entry" items="${registeredPreviouslyList}">
                <c:if test="${registeredOrganization.registeredPreviously eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>

        <h3>
            <c:choose>
                <c:when test="${registeredOrganization.like eq 'yes'}"><b>Like</b></c:when>
                <c:otherwise><b>Do not like</b></c:otherwise>
            </c:choose>
        </h3>

        <h3>Optional Services:
            <c:forEach var="entry1" items="${subscriptionList}">
                <c:forEach var="entry2" items="${registeredOrganization.optionalServices}">
                    <c:if test="${entry2 eq entry1.key}">
                        <c:set var="optService" scope="request" value="${optService}${entry1.value}"/>
                    </c:if>
                </c:forEach>
            </c:forEach>

            <b>${optService}</b>
        </h3>

        <h3>Premium Services Signed Up For:
            <c:forEach var="entry1" items="${premiumServiceList}">
                <c:forEach var="entry2" items="${registeredOrganization.premiumServices}">
                    <c:if test="${entry2 eq entry1.key}">
                        <c:set var="premiumService" scope="request" value="${premiumService}${entry1.value}"/>
                    </c:if>
                </c:forEach>
            </c:forEach>

            <b>${premiumService}</b>
        </h3>

        <h3>Has Overseas Operations: ${registeredOrganization.overseasOperations}</h3>

        <h3>Workforce size:
            <c:forEach var="entry" items="${employeeStrengthList}">
                <c:if test="${registeredOrganization.employeeStrength eq entry.key}">
                    <b>${entry.value}</b>
                </c:if>
            </c:forEach>
        </h3>
</body>
</html>
