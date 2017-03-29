<%-- 
    Document   : index
    Created on : Mar 24, 2017, 11:21:34 AM
    Author     : landon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App Store Page</title>
        <link rel="stylesheet" type="text/css" href="app.css">
    </head>
    <body>
        <div class="header">
        <h1>What Personality 1.2</h1>
        </div>
        <div class="left">
            <div class="selector">
                <button class="button" onclick="home()">Home page</button>
                <button class="button" onclick="questions()">Questions</button>
                <button class="button" onclick="report()">Report</button>
            </div>
        <div class="screenShot">
            <img id="screenShot" src="Resources/313ScreenShot.PNG" height="400" width="600"></img>
        </div>
        </div>
        <div class ="right">
            <div class="launch">
                <button id="launch" onclick="launch()">Launch App</button>
            </div>
        <div class="description">
             <h3>Description: </h3><p>Dealing with other people can be challenging. With different cultural backgrounds, norms, and traditions, it can be like walking through a landmine at times. Wouldn't you want to make it as easy as you can?
                    One way to "simplify this communication process is by understanding how you communicate, and how others communicate. After launching the app, click next to begin your assessment. As the questions appear on screen, arrange 
                    the four descriptive words from top to bottom in the way that best describes you. after question 10, you will see your results and have the option to share them on facebook. </p>
        </div>
        <div class="additionalInfo">
            <h3>Additional Info: </h3> <p>Created by:</p><p>Andre Nell</p><p>Aubrey Raby</p><p>Tenille D.</p><p>Bud Wortham</p><p>Cesear de Leon</p><p>Landon Mecham</p>
        </div>
        </div>
        
        <script>
        function home(){
            document.getElementById("screenShot").setAttribute("src", "Resources/313ScreenShot.PNG");
        }
        
        function questions(){
            document.getElementById("screenShot").setAttribute("src", "Resources/Question.PNG");
        }   
        
        function report(){
            document.getElementById("screenShot").setAttribute("src", "Resources/Report.PNG")
        }
        
        function launch(){
            window.location.assign("intro.jsp");
        }
        </script>
        
    </body>
</html>
