var listRestaurants;
var pollId = '';

function listVotesModal(restaurantId) {
    $("#votes-content").html("");
    listRestaurants.forEach(function (restaurant) {
        if (restaurant.id == restaurantId){
            if (restaurant.votes.length > 0){
                restaurant.votes.forEach(function (vote) {
                    $("#votes-content").append('<h5 >' + vote.user.name + '</h5></br>');
                });
            }else{
                $("#votes-content").append('<h5 >No votes yet!</h5></br>');
            }
        }
    });

    $("#votes-content").append(
        '<div class="modal-footer">' +
            '<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>' +
        '</div>'
    );

    $("#votesModal").modal("show");
}

function vote(restaurantId, e) {
    var url = "/rest/vote";

    $.ajax({
        type: "POST",
        url: url,
        data: "restaurantId=" + restaurantId,
        success: function(success)
        {
            if (success){
                $(".list-group-item").removeClass("active");
                parent = $(e).closest(".list-group-item")[0];
                parent.classList.add("active");
                refreshVotes();
            }else{
                //TODO - Falha ao votar
            }
        }
    }).fail(function (data) {
        //TODO - Falha ao votar
    });
}

function refreshVotes() {
    var url = "/rest/list-restaurants/" + pollId;
    $.ajax({
        type: "GET",
        url: url,
        success: function(restaurants)
        {
            if (restaurants){
                listRestaurants = restaurants;
                restaurants.forEach(function (restaurant) {
                    $("#restaurantVoteId" + restaurant.id).html(restaurant.votes.length + " Votes");
                });
            }
        }
    });
}

function filterRestaurants(filter) {
    // var w = value.split(' ');
    var url = "/restaurant/filter";
    $.ajax({
        type: "POST",
        url: url,
        data: "filter=" + filter,
        success: function(restaurants)
        {
            if (restaurants){
                consolose.log(restaurants);
            }
        }
    });
}


$(function () {

    pollId = window.location.href.substr(window.location.href.lastIndexOf('/') + 1);
    refreshVotes();
    setInterval(refreshVotes, 10000);

    $("#searchBox").keyup(function () {
        filterRestaurants($(this).val());
    });

    // $("#searchBox").quicksearch(".list-group a");

    $('.tree li:has(ul)').addClass('parent_li').find(' > span').attr('title', 'Collapse this branch');
    $('.tree li.parent_li > span').on('click', function (e) {
        var children = $(this).parent('li.parent_li').find(' > ul > li');
        if (children.is(":visible")) {
            children.hide('fast');
            $(this).attr('title', 'Expand this branch');
        } else {
            children.show('fast');
            $(this).attr('title', 'Collapse this branch');
        }
        e.stopPropagation();
    });

})();