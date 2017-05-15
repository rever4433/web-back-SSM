function verify() {
    $.get("ajax?name="+$("#username").val(),null,function (data) {
        $("#result").html(data)
    });
}
