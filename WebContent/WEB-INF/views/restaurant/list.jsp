<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 26/07/2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Where To Eat</title>
</head>
<body>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
        <th>Location</th>
        <th>Alelo Accepted?</th>
        <th>Image</th>
    </tr>
    <c:forEach var="restaurant" items="${restaurants}">

        <tr id="${restaurant.id}">
            <td>${restaurant.name}</td>
            <td>${restaurant.averagePrice}</td>
            <td>${restaurant.location}</td>
            <td>${restaurant.aleloAccepted}</td>
            <td>${restaurant.imageURL}</td>
            <td><a href="edit?id=${restaurant.id}">Edit</a></td>
            <td><a href="remove?id=${restaurant.id}">Remove</a></td>
            </td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Add Restaurant" onclick="location.href='new'">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
    function remove(id) {
        $("#"+id).remove();
    }

</script>
</body>
</html>