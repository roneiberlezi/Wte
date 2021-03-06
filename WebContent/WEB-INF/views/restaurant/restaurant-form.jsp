<%--
  Created by IntelliJ IDEA.
  User: I863273
  Date: 26/07/2017
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <%@include file="/resources/includes/header.jsp"%>
<body>
    <%@include file="/resources/includes/nav-bar.jsp"%>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">
            <a class="list-group-item list-group-item-action flex-column align-items-start">

                <div class="row">
                    <div class="col-md-6">

                        <form:form modelAttribute="restaurant" servletRelativeAction="saveOrUpdate" method="POST">
                            <form:input class="form-control" path="id" type="hidden" value="${restaurant.id}"/>
                            <div class="input-group">
                                <span class="input-group-addon same-size">Name</span>
                                <form:input class="form-control" id="restaurantName" path="name" type="text" value="${restaurant.name}"/>
                            </div>
                            <form:errors cssClass="error-message" path="name"/><br/>

                            <div class="input-group">
                                <span class="input-group-addon same-size">R$</span>
                                <form:input class="form-control" path="averagePrice" type="BigDecimal" placeholder="price" value="${restaurant.averagePrice}"/>
                            </div>
                            <form:errors cssClass="error-message" path="averagePrice" /><br/>

                            <div class="input-group">
                                <span class="input-group-addon same-size">Description</span>
                                <form:textarea class="form-control" path="description" type="text" value="${restaurant.description}"/>
                            </div>
                            <br/>

                            <div class="input-group">
                                <span class="input-group-addon same-size">Location</span>
                                <form:input id="restaurantAddress" class="form-control" path="location" type="text" value="${restaurant.location}"/>
                            </div>
                            <form:errors cssClass="error-message" path="location"/><br/>

                            <div class="input-group">
                                <span class="input-group-addon same-size">Image URL</span>
                                <form:input class="form-control" path="imageURL" type="text" value="${restaurant.imageURL}"/>
                            </div>
                            <br/>

                            <div class="input-group">
                                Accepts Alelo: <form:checkbox path="aleloAccepted" value="${restaurant.aleloAccepted}"/>
                            </div>
                            <br/>

                            <form:button class="btn btn btn-primary" id="saveButton">Save</form:button>
                            <form:button class="btn btn btn-primary" type="button" name="cancel" value="cancel" onClick="window.location='/';">Cancel</form:button>
                        </form:form>
                    </div>

                    <div class="col-md-6">
                        <div class="thumbnail" >
                            <img class="img-responsive center-block img-size-edit vcenter" id="imagePreview" src="${restaurant.imageURL}">
                        </div>
                    </div>

                </div>
            </a>


            <br/>

            <div id="googleResult" class="list-group">

            </div>

            <div id="map"></div>

        </div>
    </div>
</div>


    <script type="text/javascript" src="/resources/js/restaurant-form.js"></script>
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5IR7EGbu4u3cjoCEDRi0WMGmevAuL6gw&libraries=places"></script>

</body>
</html>
