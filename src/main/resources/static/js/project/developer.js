$(document).ready(function () {
    $('#modal-member').click(function () {
        $("#modal-div-member").removeClass("close-modal");
        $("#modal-div-member").show();

    });
    $('#close-dashboard-modal').click(function () {
        $("#modal-div-member").hide();
    });

   $("#search-dev-input").on('input',function () {
        console.log("change");
        var asd= $("#search-dev-input").val();
        var url = "/getAllDeveloper/"+asd;
        $.ajax(
            {
                type:"get",
                url:url,
                data_type:"json",
                success:function (data) {
                    $('.developer-search-result').empty().append(data);
                }
            }
        )
   })
});