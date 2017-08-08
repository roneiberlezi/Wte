Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});

function getFormattedDate() {
    var todayTime = new Date();
    var month = todayTime .getMonth() + 1;
    var day = todayTime .getDate();
    var year = todayTime .getFullYear();
    return day + "/" + month + "/" + year;
}

function openModal(){
    $.get('/poll/form')
        .done(function (response) {
            // alert("success! " + response);
            console.log(response);
            $('#myModal').modal("show");
        })
        .fail(function (response) {
            alert(response);
    });
}

$(document).ready( function() {

    // $("#modalPlace").load('/resources/includes/poll-modal.jsp').dialog({modal:true});
    $('#datePicker').val(new Date().toDateInputValue());
    $('#title').val( "Poll " + getFormattedDate());


    // this is the id of the form
    $("#pollForm").submit(function(e) {
        var url = "/poll/create"; // the script where you handle the form input.

        $.ajax({
            type: "POST",
            url: url,
            data: $("#pollForm").serialize(), // serializes the form's elements.
            success: function(data)
            {
                if (data){
                    $("#message").removeClass()
                    $("#message").addClass('success-message');
                    $("#message").html("New poll created with success!");
                }else{
                    $("#message").removeClass()
                    $("#message").addClass('error-message');
                    $("#message").html("Error creating new poll!");
                }
            }
        }).fail(function (data) {
            $("#message").removeClass()
            $("#message").addClass('error-message');
            $("#message").html("Error creating new poll!");
        });

        e.preventDefault(); // avoid to execute the actual submit of the form.
    });
});