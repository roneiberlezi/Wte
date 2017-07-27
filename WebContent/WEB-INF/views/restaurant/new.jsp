<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 26/07/2017
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Where To Eat</title>
</head>
<body>
<form:form modelAttribute="restaurant" servletRelativeAction="add" method="POST">
    Name: <form:input path="name" type="text"/>
    <form:errors path="name"/><br/>
    Average Price: <form:input path="averagePrice" type="BigDecimal"/>
    <form:errors path="averagePrice" /><br/>
    Location: <form:input path="location" type="text"/>
    <form:errors path="location"/><br/>
    Alelo Accepted: <form:checkbox path="aleloAccepted"/><br/>
    Image: <form:input path="imageURL" type="text"/><br/>
    <form:button id="saveButton">Save</form:button>
</form:form>
</body>
</html>
