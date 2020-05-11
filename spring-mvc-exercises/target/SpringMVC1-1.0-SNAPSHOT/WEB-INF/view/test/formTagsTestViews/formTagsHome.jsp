<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/11/2018
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <spring:url value="/resources/test-main.css" var="testMainCSS"/>
    <link href="${testMainCSS}" rel="stylesheet"/>
    <title>Form Tags Home</title>
</head>
<body>
    <form:form action="registerOrg" modelAttribute="orgRegistration">
        <form:label path="organizationName">Organization Name:</form:label>
        <form:input path="organizationName" placeholder="Enter org name" />

        <form:label path="country">Country:</form:label>
        <form:select path="country">
            <form:option value="none"/>
            <form:option value="Country1"/>
            <form:option value="Country2"/>
            <form:option value="Country3"/>
            <form:option value="Country4"/>
            <form:option value="Country5"/>
        </form:select>

        <form:label path="turnover">Turnover:</form:label>
        <form:select path="turnover" items="${turnoverList}"/>

        <form:label path="type">Type:</form:label>
        <form:select path="type">
            <form:option value="none">Select</form:option>
            <form:options items="${typeList}"/>
        </form:select>

        <form:label path="since">Since:</form:label>
        <form:select path="since" items="${serviceLengthList}"/>

        <br>

        <form:label path="registeredPreviously">Registered Previously?:</form:label>
        <form:checkbox path="registeredPreviously" items="${registeredPreviouslyList}"/>
        <br>

        <p><form:label path="like">Liked the web site?:</form:label>
        <form:checkbox path="like" value="yes"/>Like</p>
        <br>

        <form:label path="optionalServices">Optional Services Subscriptions:</form:label>
        <form:checkbox path="optionalServices" value="emailService"/>${subscriptionList.emailService}
        <form:checkbox path="optionalServices" value="promotionalService"/>${subscriptionList.promotionalService}
        <form:checkbox path="optionalServices" value="newsLetterService"/>${subscriptionList.newsLetterService}
        <br>

        <form:label path="premiumServices">Premium Services:</form:label>
        <form:checkboxes path="premiumServices" items="${premiumServiceList}"/>
        <br>

        <form:label path="overseasOperations">Overseas Operations:</form:label>
        <p><form:radiobutton path="overseasOperations" value="yes"/>Yes</p>
        <p><form:radiobutton path="overseasOperations" value="no"/>No</p>
        <br>

        <form:label path="employeeStrength">Workforce Size:</form:label>
        <form:radiobuttons path="employeeStrength" items="${employeeStrengthList}"/>
        <br>

        <input type="submit" value="submit"/>
    </form:form>

</body>
</html>
