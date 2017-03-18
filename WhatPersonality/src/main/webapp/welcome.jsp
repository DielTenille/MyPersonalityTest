<%-- 
    Document   : welcome
    Created on : Mar 18, 2017, 11:10:17 AM
    Author     : t2alaska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>Welcome</title>
    </head>
    <body>
        <script>
            window.fbAsyncInit = function () {
                FB.init({
                    appId: '1691761467790037',
                    xfbml: true,
                    version: 'v2.8'
                });
                FB.AppEvents.logPageView();
            };

            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id)) {
                    return;
                }
                js = d.createElement(s);
                js.id = id;
                js.src = "//connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));
        </script>
        <div class="container">
            <div class="jumbotron text-center">
                <h1>Welcome</h1>
                <div class="row">
                <a class="btn btn-primary" href="ShowFriends">Click here to see your friends</a>
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-12 col-sm-offset-1 text-center">
                <div
                    class="fb-like"
                    data-share="true"
                    data-width="450"
                    data-show-faces="true">
                </div>
                    </div>
                </div>
        </div>
    </body>
</html>
