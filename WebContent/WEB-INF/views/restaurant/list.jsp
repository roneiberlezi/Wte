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

    <%@include file="votes-modal.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="content-color col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">
            <input id="searchBox" type="text" class="form-control search-input" placeholder="Search for restaurants" />

            <div class="list-group">
                <c:forEach var="restaurant" items="${restaurants}">

                    <a id="itemRestaurant${restaurant.id}" href="#" class="list-group-item list-group-item-action flex-column align-items-start${vote.restaurant.id == restaurant.id ? ' active' : ''}">
                        <div class="row content">

                            <div class="col-md-3 justify-content-between">
                                <div class="thumbnail text-center" >
                                    <img src="${restaurant.imageURL}" class="img-size">
                                    <h4 id="restaurantVoteId${restaurant.id}" class="color-black">${restaurant.votes.size()} Votes</h4>
                                    <c:if test="${poll.state.toString() eq 'O'}">
                                        <button type="button" class="btn btn-danger" onclick="vote(${restaurant.id}, this)">Vote!</button>
                                    </c:if>
                                    <button type="button" class="btn btn-danger" onclick="listVotesModal(${restaurant.id})">View Votes</button>
                                </div>
                            </div>

                            <div class="col-md-6 justify-content-between">
                                <h4 class="mb-1">${restaurant.name}</h4>
                                <small>R$ ${restaurant.averagePrice}</small>

                                <p class="mb-1">${restaurant.location}</p>
                                <c:if test="${restaurant.aleloAccepted}">
                                    <img src="/resources/images/alelo-logo.png" class="img-rounded" width="50" height="50">
                                </c:if>

                                <br>
                                <button type="button" class="btn btn-danger" onclick="location.href='edit?id=${restaurant.id}';">Edit</button>
                                <button type="button" class="btn btn-danger" onclick="location.href='remove?id=${restaurant.id}';">Remove</button>
                            </div>

                            <div class="col-md-3 justify-content-between">
                                <c:if test="${(poll.restaurant.id == restaurant.id) and (poll.state.toString() eq 'C')}">
                                    <img src="/resources/images/winner.png" class="img-size center-block">
                                    <%--<h3 class="text-center">Winner!</h3>--%>
                                </c:if>
                                <c:if test='${vote.restaurant.id == restaurant.id and poll.state.toString() eq "C"}'>
                                    <h3 class="text-center">Your Vote!</h3>
                                </c:if>
                            </div>
                        </div>
                    </a>


                </c:forEach>

                <br>
                <input type="button" class="btn btn-primary" value="Add Restaurant" onclick="location.href='new'">
            </div>
        </div>

        <div class="col-md-3 text-left">

            <div class="tree well">
                <ul class="no-padding">
                    <li>
                        <span><i class="fa fa-history"></i> Poll History</span>
                        <ul>
                            <c:forEach var="pollIterator" items="${historyPolls}" varStatus = "status">
                                <li>
                                    <span class="${poll.id eq pollIterator.id ? 'history-active' : ''}"><i class="fa fa-calendar"></i> ${pollIterator.date}${status.first ? ' (Current Poll)' : ''}</span> <a href="/restaurant/${pollIterator.id}">View Poll</a>
                                    <ul>
                                        <c:forEach var="restaurant" items="${pollIterator.restaurants}">
                                            <c:if test="${restaurant.votes.size() > 0}">
                                                <li>
                                                    <span><i class="fa fa-cutlery"></i>  <span class="badge">${restaurant.votes.size()}</span> ${restaurant.name}</span>
                                                </li>
                                            </c:if>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>

        </div>
    </div>
</div>

    <script src="<c:url value="/resources/js/restaurant-list.js" />"></script>
    <script src="<c:url value="/resources/js/jquery.quicksearch.js" />"></script>

</body>
</html>