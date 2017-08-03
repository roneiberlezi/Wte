<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 26/07/2017
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="/resources/includes/header.jsp"%>
<body>
    <%@include file="/resources/includes/nav-bar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="content-color col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">

            <div class="list-group">

                <c:forEach var="restaurant" items="${restaurants}">

                    <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">


                        <div class="row content">

                            <div class="col-md-3 justify-content-between">
                                <div class="thumbnail" >
                                    <%--<img src="${restaurant.imageURL}" class="img-responsive center-block img-size thumbnail">--%>
                                    <img src="${restaurant.imageURL}" class="img-size">
                                </div>
                            </div>

                            <div class="col-md-9 justify-content-between">
                                <h4 class="mb-1">${restaurant.name}</h4>
                                <small>R$ ${restaurant.averagePrice}</small>

                                <p class="mb-1">${restaurant.location}</p>
                                <c:if test="${restaurant.aleloAccepted}">
                                    <img src="/resources/images/alelo-logo.png" class="img-rounded" width="50" height="50">
                                </c:if>

                                <br>
                                <button type="button" class="btn btn-primary" onclick="location.href='edit?id=${restaurant.id}';">Edit</button>
                                <button type="button" class="btn btn-danger" onclick="location.href='remove?id=${restaurant.id}';">Remove</button>
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
</body>
</html>