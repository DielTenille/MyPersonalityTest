<%-- 
    Document   : personality-questions
    Created on : Mar 10, 2017, 8:00:45 PM
    Author     : andrenell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="Resources/main.css">
        <!--        <style>
                    #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
                    #sortable li { margin: 0 3px 3px 3px; padding: 0.5em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
                    #sortable li span { position: absolute; margin-left: -1.3em; }
                </style>-->
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $("#sortable").sortable();
                $("#sortable").disableSelection();
            });
        </script>    
        <title>What Personality Type Am I? | CS313 Group 6</title>
    </head>
    <body>
        <div class="container">
            <div class="jumbotron text-center">
                <h1>Question ${pageNumber} of 10</h1>
                <hr>
                <h3 class="big">Sort the following words in order of most like you to least like you.</h3>
            </div>
            <div class="row text-center">
                <div class="col-sm-4 col-sm-offset-4">


                    <h2 class="text-uppercase">Most Like Me</h2>
                    <hr>
                    <ul id="sortable">
                        <li class="ui-state-default btn-primary"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${options[0]}</li>
                        <li class="ui-state-default btn-primary"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${options[1]}</li>
                        <li class="ui-state-default btn-primary"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${options[2]}</li>
                        <li class="ui-state-default btn-primary"><span class="ui-icon ui-icon-arrowthick-2-n-s"></span>${options[3]}</li>
                    </ul>
                    <hr>
                    <h2 class="text-uppercase">Least Like Me</h2>

                </div>
            </div>

            <a class="btn btn-primary pull-right" href="Next?action=next">NEXT</a>
        </div>
    </body>
</html>
