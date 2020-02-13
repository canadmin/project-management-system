$(document).ready(function () {
    var firstName = $('#firstname').val()
    var lastName = $('#lastname').val()
    var intials = firstName.charAt(0) + lastName.charAt(0);
    var profileImage = $('#profileImage').text(intials.toUpperCase())

    if ($('.navbar-custom').is(':visible')) {
        connect()
    }
    $("#logout").click(function () {
        disconnect();
    })
    $(".profil-header").click(function (event) {
        var isOpen = $(".profile-options").hasClass("close-options");
        if (isOpen) {
            $(".profile-options").show()
        }
        event.stopPropagation();

    });

    $(".notifications-field").click(function (event) {
        var isOpen = $(".notificaions").hasClass("close-options");
        if (isOpen) {
            $(".notificaions").show()
        }
        event.stopPropagation();

    });
    $(window).click(function (e) {
        $(".notificaions").hide();

    });
    $(window).click(function (e) {
        $(".profile-options").hide();

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


function connect() {
    var socket = new SockJS('/notificationSocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/user/notification/to/', function (notification) {
            showNotification(JSON.parse(notification.body));
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }

}


function showNotification(message) {
    $('#notification-alert').removeClass('close-modal');
    if (message.notificationType === 'INVITE') {
        $(".test").append("<a href='/showNotifications'> " + message.notificationMessage + " +  </a>");
    } else {
        $(".test").append("<p>" + message.notificationMessage + "</p>");
    }
    setTimeout(function () {
        $("#notification-add").empty();
        $("#notification-add").append("<p>" + message.notificationMessage + "</p>");
        $('#notification-alert').addClass('close-modal')
    }, 3000);
}