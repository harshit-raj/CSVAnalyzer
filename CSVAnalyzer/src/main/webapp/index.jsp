<html>
    <head>
        <title>CSV Analyzer</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <style>
            #outerTable{

            }
        </style>

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
                            $("#list").append("<h2><b>CSV Details :<b></h2></br>");
                            var tabC;
                            tabC = $("<table/>");
                            $.each(e.personList, function() {
                                var tr;
                                tr = $("<tr/>");
                                $.each(this, function(k, v) {
                                    tr.append("<td>"+v+"</td>");
                                });
                                tabC.append(tr);
                            });
                            $("#list").append(tabC);

                            $("#dup").append("<h2><b>Duplicate Data :</b></h2></br>");
                            var dupT;
                            dupT = $("<table/>");
                            $.each(e.duplicateList, function() {
                                var dupR;
                                dupR = $("<tr/>");
                                var inTab;
                                inTab =$("<table/>");

                                $.each(this, function() {
                                    var inDupR;
                                    inDupR = $("<tr/>");
                                    $.each(this, function (k, v) {
                                        inDupR.append("<td>"+v+"</td>");
                                    });
                                    inTab.append(inDupR);

                                });
                                dupR.append(inTab);
                                dupT.append(dupR);

                            });
                            $("#dup").append(dupT);
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