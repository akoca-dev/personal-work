<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/2/2018
  Time: 5:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>MVC Test Home</title>
</head>
<body>
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>

    <a href="${contextPath}/requestMapAndParamTest/home">Click to get test bed for RequestMapping and RequestParam</a><br>
    <a href="${contextPath}/modelAttributeTest/home5">Click to get test bed for ModelAttribute</a><br>
    <a href="${contextPath}/registerVisitor/home">Click to get test bed for sessionAttr</a><br>
    <a href="${contextPath}/formTags/home">Click to get test bed for form tests</a><br>
    <a href="${contextPath}/formValidation/home">Click to go to test bed for form validation:</a>
    <a href="${contextPath}/location">Click to go to test bed for organization list:</a>

</body>
</html>