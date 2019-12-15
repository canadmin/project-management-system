$(document).ready(function () {
    var firstName = $('#firstname').val()
    var lastName = $('#lastname').val()
    var intials = firstName.charAt(0)+lastName.charAt(0);
    var profileImage=$('#profileImage').text(intials.toUpperCase())

    if($('.navbar-custom').is(':visible')){
        connect()
    }
    $(".profil-header").click(function (event) {
        var isOpen = $(".profile-options").hasClass("close-options");
        if(isOpen){
            $(".profile-options").show()
        }
        event.stopPropagation();

    });

    $(".notifications-field").click(function (event) {
        var isOpen = $(".notificaions").hasClass("close-options");
        if(isOpen){
            $(".notificaions").show()
        }
        event.stopPropagation();

    });
    $(window).click(function (e) {
        $(".notificaions").hide();

    });
    $('#create-new-project').click(function () {
        $("#modal-div").removeClass("close-modal");
       $("#modal-div").show();
    });
    $('#close-dashboard-modal').click(function () {
        $("#modal-div").hide();
    });

});
var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
    var socket = new SockJS('/notificationSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/notification/to/', function (notification) {
            showGreeting(JSON.parse(notification.body).notificationMessage);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}


function showGreeting(message) {
    $(".test").append("<p>" + message + "</p>");
}