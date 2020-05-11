<%--
  Created by IntelliJ IDEA.
  User: ahmet
  Date: 10/4/2018
  Time: 1:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <h1>${testData1A}</h1>

    <h3>${testData1B}</h3>

    <h3>${testData2}</h3>

    <h3>${testData3.city} and ${testData3.zipCode}</h3>

    <h3>${address}</h3>

    <form:form action="test5" modelAttribute="anAddress">
        <form:label path="city">Enter City</form:label>
        <form:input path="city"/>

        <form:label path="zipCode">Enter Zipcode</form:label>
        <form:input path="zipCode"/>

        <input type="submit" value="submit"/>
    </form:form>

    <br><br><br>

    <form:form action="modelAttrTest">
        <input value="Relocate" type="submit">
    </form:form>
</body>
</html>
