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
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/custom.css" />">
    <title>Where To Eat</title>
</head>
<body>

<div class="container-fluid text-center">
    <div class="row content">
        <div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2 col-xs-8 col-xs-offset-2 text-left">
            <a class="list-group-item list-group-item-action flex-column align-items-start">

                <div class="row content">
                    <div class="col-md-6 justify-content-between">

                        <form:form modelAttribute="restaurant" servletRelativeAction="saveOrUpdate" method="POST">
                            <form:input class="form-control" path="id" type="hidden" value="${restaurant.id}"/>
                            <div class="input-group">
                                <span style="width:15ch; text-align:left;" class="input-group-addon">Name</span>
                                <form:input class="form-control" id="restaurantName" path="name" type="text" value="${restaurant.name}"/>
                            </div>
                            <form:errors path="name"/><br/>

                            <div class="input-group">
                                <span style="width:15ch; text-align:left;" class="input-group-addon">R$</span>
                                <form:input class="form-control" path="averagePrice" type="BigDecimal" placeholder="price" value="${restaurant.averagePrice}"/>
                            </div>
                            <form:errors path="averagePrice" /><br/>

                            <div class="input-group">
                                <span style="width:15ch; text-align:left;" class="input-group-addon">Description</span>
                                <form:textarea class="form-control" path="description" type="text" value="${restaurant.description}"/>
                            </div>
                            <br/>

                            <div class="input-group">
                                <span style="width:15ch; text-align:left;" class="input-group-addon">Location</span>
                                <form:input class="form-control" path="location" type="text" value="${restaurant.location}"/>
                            </div>
                            <form:errors path="location"/><br/>

                            <div class="input-group">
                                <span style="width:15ch; text-align:left;" class="input-group-addon">Image URL</span>
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

                    <div class="col-md-6 justify-content-between">
                        <img src="http://placehold.it/200x200" class="img-responsive center-block">
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA5IR7EGbu4u3cjoCEDRi0WMGmevAuL6gw&libraries=places"></script>


<script>
    var latitude;
    var longitude;
    var map;
    var pyrmont;

    function getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.watchPosition(showPosition);
        }
    }

    function showPosition(position) {
        latitude = position.coords.latitude;
        longitude = position.coords.longitude;

        initialize();
    }

    function initialize() {
        pyrmont = new google.maps.LatLng(latitude, longitude);
        map = new google.maps.Map(document.getElementById('map'), {
            center: pyrmont,
            zoom: 15
        });

        service = new google.maps.places.PlacesService(map);

        search('')
    }

    function search(text) {
        var request = {
            location: pyrmont,
            radius: '5000',
            name: text,
            types: ['food', 'restaurant']
        };

        service.nearbySearch(request, callback);
    }

    $("#restaurantName").keyup(function () {
       search($(this).val());
    });


    function callback(results, status) {
        if (status == google.maps.places.PlacesServiceStatus.OK) {

            list = document.getElementById('googleResult')

            $("#googleResult").html("");

            for (var i = 0; i < results.length; i++) {
                var place = results[i];


                $("#googleResult").append(
                    '<a href="#item" class="list-group-item list-group-item-action flex-column align-items-start">' +
                        '<div class="row content">' +
                            '<div class="col-md-6 justify-content-between">' +
                                '<h4 class="mb-1">' + results[i].name + '</h4>' +
                                '<p class="mb-1">'+ results[i].vicinity +'</p>' +
                                '<br>' +
                            '</div>' +
                            '<div class="col-md-6 justify-content-between">' +
                                '<img src="' + results[i].icon + '" class="img-responsive center-block">' +
                            '</div>' +
                        '</div>' +
                    '</a>'
                );
            }
        }
    }


    //on Ready
    $(function () {
        getLocation();

        $(".list-group").click(function(e) {
            $(".list-group-item").removeClass("active");
            $(e.target).closest(".list-group-item").addClass("active");
        });
    })();


</script>

</body>
</html>
