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

    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <title>Where To Eat</title>
</head>
<body>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">

            <div class="list-group">

                <c:forEach var="restaurant" items="${restaurants}">

                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">


                        <div class="row content">

                            <div class="col-md-6 justify-content-between">
                                <h5 class="mb-1">${restaurant.name}</h5>
                                <small>R$ ${restaurant.averagePrice}</small>

                                <%--<img src="/resources/images/exemplo.jpg" class="img-rounded" width="300" height="300">--%>

                                <p class="mb-1">${restaurant.description}</p>
                                <c:if test="${restaurant.aleloAccepted}">
                                    <img src="/resources/images/alelo-logo.png" class="img-rounded" width="50" height="50">
                                </c:if>

                                <br>
                                <button type="button" class="btn btn-primary" onclick="location.href='edit?id=${restaurant.id}';">Edit</button>
                                <button type="button" class="btn btn-danger" onclick="location.href='remove?id=${restaurant.id}';">Remove</button>
                            </div>

                            <div class="col-md-6 justify-content-between">
                                <img src="http://placehold.it/200x200" class="img-responsive center-block">
                            </div>

                        </div>
                    </a>

                </c:forEach>

                <br>
                <input type="button" class="btn btn-primary" value="Add Restaurant" onclick="location.href='new'">
            </div>
        </div>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script>
    function remove(id) {
        $("#"+id).remove();
    }

</script>
</body>
</html>