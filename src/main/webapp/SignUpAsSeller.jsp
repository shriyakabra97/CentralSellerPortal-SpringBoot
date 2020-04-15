<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
<head>
    <title>Seller Registration</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="../../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../../css/main.css">
    <script src="../../js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <!--          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                          </button>-->
                <a class="navbar-brand" href="#" style="color:gray ; font-size: 18px">Central Seller Portal</a>
            </div>
        </div>
    </nav>
<br>


    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <header class="card-header">
                    <a href="/" action="index.html" class="float-right btn btn-outline-primary mt-1">Have an Account, Log in</a>
                    <h4 class="card-title mt-2">Seller Sign up</h4>
                </header>
                <article class="card-body">
                    <form class ="form-signin" id="admission-form" action = "/addseller" method="post" ></form>
                        <form :hidden path="id"/>
                        <div class="form-row">
                            <div class="col form-group">
                                <label>Name </label>
                                <input type="text" id="s_name" name="s_name" class="form-control" placeholder="" required>
                            </div> <!-- form-group end.// -->
                            <!-- form-group end.// -->
                        </div> <!-- form-row end.// -->
                        <div class="form-group">
                            <label>Address</label>
                            <input type="text" id="s_address" name="s_address" class="form-control" placeholder="" required>

                        </div>
                        <div class="form-group">
                            <label>Mobile No.</label>
                            <input type="number" id="s_mobile" name="s_mobile" class="form-control" placeholder=""   minlength="10" maxlength="10" required>

                        </div>
                        <div class="form-group">
                            <label>Email address</label>
                            <input type="email" id="s_mail" name="s_mail" class="form-control" placeholder="" required>
                            <small class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Store Name</label>
                            <input type="text" id="s_shop" name="s_shop" class="form-control" placeholder="" required>

                        </div>
                    <script>
                        function check() {
                            var pass1= document.getElementById("s_password");
                            var pass2= document.getElementById("s_pass");
                            if(pass1 !== pass2){
                                document.getElementById("pass-match").innerHTML = "Passwords don't match" ;
                            }

                        }

                    </script>


                        <div class="form-group">
                            <label>Create password</label>
                            <input class="form-control" id="s_password" name="s_password" type="password" minlength="4" required>
                        </div> <!-- form-group end.// -->
                        <div class="form-group">
                            <label>Re-type password</label>
                            <input class="form-control" oninput="check()" id="s_pass" name="s_pass" type="password" minlength="4" required>
                        </div>
                    <p id ="pass-match" style="color:crimson"></p>
<%--                    <script>--%>
<%--                        function check() {--%>
<%--                            var pass1= document.getElementById("s_password");--%>
<%--                            var pass2= document.getElementById("s_pass");--%>
<%--                            if(pass1 != pass2){--%>
<%--                                var text = "Passwords don't match";--%>
<%--                                document.getElementById("pass-match").innerHTML = text ;--%>
<%--                            }--%>

<%--                        }--%>

<%--                    </script>--%>


<%--                    <c:choose>--%>
<%--                        <c:when test= "${s_password.equals(s_pass)}">--%>
<%--                            <p></p>--%>
<%--                        </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <p style="color: #c7254e">Passwords don't match..</p>--%>
<%--                    </c:otherwise>--%>
<%--                    </c:choose>--%>
                    <%--%>
<%--                        if(request.getParameter("s_password")!=null && request.getParameter("s_pass")!=null){--%>
<%--                            String pass_f1 = request.getParameter("s_password");--%>
<%--                            String pass_f2 = request.getParameter("s_pass");--%>
<%--                            if(pass_f1.equals(pass_f2)){--%>
<%--                                String msg = "Passwords match";--%>

<%--                     %>--%>
<%--                    --%>

<%--                    <%--%>

<%--                            }else{--%>
<%--                                String msg = "Passwords don't match.";--%>
<%--                            }--%>
<%--                        }--%>
<%--                    %>--%>
                        <div class="form-group">
                            <button id="sub-btn" type="submit" class="btn btn-primary btn-block"> Register  </button>
                        </div> <!-- form-group// -->
                        <small class="text-muted">By clicking the 'Register' button, you confirm that you accept our <br> Terms of use and Privacy Policy.</small>
                    </form>
                </article> <!-- card-body end .// -->
                <!--<div class="border-top card-body text-center">Have an account? <a href="">Log In</a></div>-->
            </div> <!-- card.// -->
        </div> <!-- col.//-->

    </div> <!-- row.//-->



<!--container end.//-->

<br><br>

</body>
</html>
