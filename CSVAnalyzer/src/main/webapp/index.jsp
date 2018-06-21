<html>
    <head>
        <title>CSV Analyzer</title>
    </head>
    <body>
        <h1>CSV Analyzer</h1>
        <form id="fileUpload" method="POST" enctype="multipart/form-data">
            <label>Choose CSV file</label>
            <input name="file" type="file">
            <label>Threshold</label>
            <input type="range" id="threshold" name="threshold"
                   min="0" max="100" />
            <input type="submit" id="submit">

        </form>

        <p id="list"></p>
        <p id="dup"></p>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
        <script>
            $(document).ready(function () {
                $("#submit").click(function (event) {
                    $("#list").empty();
                    $("#dup").empty();
                    event.preventDefault();
                    var form = $('#fileUpload')[0];
                    var data = new FormData(form);
                    $("#submit").prop("disabled",true);

                    $.ajax({
                        type:"POST",
                        enctype: 'multipart/form-data',
                        url: '/api/uploadFile',
                        data: data,
                        processData: false,
                        contentType: false,
                        cache: false,
                        timeout: 600000,
                        success: function (e) {
                            $("#list").append("<h2><b>CSV Details :<b></h2></br><table>");
                            $.each(e.personList, function() {
                                $("#list").append("<tr>");
                                $.each(this, function(k, v) {
                                    $("#list").append("<td>"+v+"</td>");
                                });
                                $("#list").append("</tr>");
                            });
                            $("#list").append("</table>");

                            $("#dup").append("<h2><b>Duplicate Data :</b></h2></br> <table>");
                            $.each(e.duplicateList, function() {
                                $("#dup").append("<tr >");
                                $.each(this, function() {
                                    $("#dup").append("<tr >");


                                    $.each(this, function (k, v) {
                                        $("#dup").append("<td>"+v+"</td>");
                                    });
                                    $("#dup").append("</tr>");

                                });
                                $("#dup").append("</tr>");

                            });
                            $("#dup").append("</table>");
                            $("#submit").prop("disabled", false);

                        },
                        error: function (e) {

                            $("#result").text("error");
                            console.log("ERROR : ", e);
                            $("#submit").prop("disabled", false);

                        }
                    });

                });
            });
        </script>

    </body>
</html>