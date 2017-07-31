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

function callback(results, status) {
    if (status == google.maps.places.PlacesServiceStatus.OK) {
        list = document.getElementById('googleResult')
        $("#googleResult").html("");

        for (var i = 0; i < results.length; i++) {
            var place = results[i];
            console.log(results[i])
            $("#googleResult").append(
                '<a href="#item" class="list-group-item list-group-item-action flex-column align-items-start">' +
                    '<div class="row content">' +
                        '<div class="col-md-6 justify-content-between">' +
                            '<h4 class="mb-1" id="name">' + results[i].name + '</h4>' +
                            '<p class="mb-1" id="address">'+ results[i].vicinity +'</p>' +
                            '<br>' +
                        '</div>' +
                        '<div class="col-md-6 justify-content-between">' +
                            '<img class="img-responsive center-block" id="imgurl" src="' + results[i].icon + '">' +
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

    //Registers click handler over restaurant list
    $(".list-group").click(function(e) {
        $(".list-group-item").removeClass("active");
        parent = $(e.target).closest(".list-group-item")[0];
        parent.classList.add("active");

        $("#restaurantName").val(parent.querySelector('#name').innerHTML);
        $("#restaurantAddress").val(parent.querySelector('#address').innerHTML);
        $("#imageURL").val(parent.querySelector('#imgurl').src);
        $("#imagePreview").attr('src', parent.querySelector('#imgurl').src);

    });

    //Registers keyup handler to update nearby restaurants by the typed name
    $("#restaurantName").keyup(function () {
        search($(this).val());
    });
})();