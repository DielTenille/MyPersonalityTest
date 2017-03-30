<%-- 
    Document   : Report
    Created on : Mar 10, 2017, 8:30:11 PM
    Author     : andrenell
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title>My Personality Type | CS313 Group 6</title>
    </head>
    <body>

        <div class="container">
            <div class="jumbotron text-center">
                <a class="btn btn-success pull-right" href="intro.jsp">Home</a>
                <h1>And your personality type is...${topType}</h1>
            </div>
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1 text-center">
                    <c:forEach var="result" items="${report}">
                        <h3 class="text-uppercase">${result}</h3>
                    </c:forEach> 
                </div>
            </div>
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <h2>Personality Types Described:</h2>
                    <div class="col-sm-6">
                        <h3>The <span class="text-primary big">D</span> Personality Style</h3>
                        <div class="col-sm-2">
                            <img class="img-circle pull-left" src="Resources/D.png" />
                        </div>
                        <div class="col-sm-9 pull-right">
                            <p>Action and Results focused, responsive, driving and competitive. These
                                individuals like to deal with things they can see, hear and touch. They live in the ‘now’. They are sales people, professional athletes, entrepreneurs, marketing executives, investors, military strategists, politicians and business people.</p>
                        </div>
                    </div>
                    <div class="col-sm-6">
                        <h3>The <span class="text-primary big">I</span> Personality Style</h3>
                        <div class="col-sm-2 pull-left">
                            <img class="img-circle" src="Resources/I.png" />
                        </div>
                        <div class="col-sm-9 pull-right">
                            <p>These individuals are usually your long range thinkers dealing with creative
                                ideas, theory, working in the abstract, originality and imagination.
                                They are found working in architecture, science, writing, directing, art and
                                music, engineering, city planning, creativity in advertising, corporate
                                planning and as idea people.</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1"> 

                        <div class="col-sm-6">
                            <h3>The <span class="text-primary big">S</span> Personality Style</h3>
                            <div class="col-sm-2 pull-left">
                                <img class="img-circle" src="Resources/S.png" />
                            </div>
                            <div class="col-sm-9 pull-right">
                                <p>Communicate through feeling and intuition. They have strong people
                                    orientation and have empathy and sensitivity to others. They place emphasis
                                    on relationship building to gain outcomes. They are nurses, secretaries,
                                    psychologists, teachers, psychiatrists, counselors, hairdressers, decorators,
                                    entertainers, authors, dramatists, social workers, retailers, etc. They are
                                    usually found in personnel, Human Resources and training and development.</p>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <h3>The <span class="text-primary big">C</span> Personality Style</h3>
                            <div class="col-sm-2">
                                <img class="img-circle pull-left" src="Resources/C.png" />
                            </div>
                            <div class="col-sm-9 pull-right">
                                <p>Logic, rationality, order, facts, objective thinking, problem solving and
                                    analysis. They are accountants, lawyers, systems people, engineers,
                                    researchers, economists, referees, executives, technicians, technical sales
                                    people, quality controllers, financial people, data processing personnel and
                                    actuaries</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="btn btn-primary pull-right" href="FacebookSignIn">Sign In To FaceBook to Share</a>
        </div>
    </body>
</html>
