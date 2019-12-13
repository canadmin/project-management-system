$(document).ready(function () {
    var firstName = $('#firstname').val()
    var lastName = $('#lastname').val()
    var intials = firstName.charAt(0)+lastName.charAt(0);
    var profileImage=$('#profileImage').text(intials.toUpperCase())


    $(".profil-header").click(function (event) {
        var isOpen = $(".profile-options").hasClass("close-options");
        if(isOpen){
            $(".profile-options").show()
        }
        event.stopPropagation();

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