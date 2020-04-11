<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
    <title>Update Seller Profile</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="color:gray ; font-size: 18px">Central Seller Portal</a>
        </div>
    </div>
</nav>
<br>
<div class="row justify-content-center">
    <div class="col-md-6">
        <div class="card">
            <header class="card-header">

                <h4 class="card-title mt-2">Update Seller Profile</h4>
            </header>
            <article class="card-body">
                <% long id = Long.parseLong(request.getParameter("id")); %>
                <form class ="form-update" id="updation-form" action = "/UpdateSeller/<%=id%>" method="post">
                    <form :hidden path="id"/>
                    <div class="form-row">
                        <div class="col form-group">
                            <label>Name </label>
                            <input type="text" id="s_name" name="s_name" class="form-control" placeholder="">
                        </div> <!-- form-group end.// -->
                        <!-- form-group end.// -->
                    </div> <!-- form-row end.// -->
                    <div class="form-group">
                        <label>Address</label>
                        <input type="text" id="s_address" name="s_address"  class="form-control" placeholder="">

                    </div>
                    <div class="form-group">
                        <label>Mobile No.</label>
                        <input type="number" id="s_mobile" name="s_mobile"  class="form-control" placeholder="">

                    </div>
                    <div class="form-group">
                        <label>Email address</label>
                        <input type="email" id="s_mail" name="s_mail" class="form-control" placeholder="">
                    </div> <!-- form-group end.// -->
                    <div class="form-group">
                        <label>Store Name</label>
                        <input type="text" id="s_shop" name="s_shop"  class="form-control" placeholder="">

                    </div>


                    <div class="form-group">
                        <label>Password</label>
                        <input class="form-control" id="s_password" name="s_password"  type="password">
                    </div> <!-- form-group end.// -->

                    <br>
                    <div class="form-group">
                        <button  type="submit"  class="btn btn-primary btn-block"> Save Changes</button>
                    </div> <!-- form-group// -->

                </form>
            </article> <!-- card-body end .// -->
            <!--<div class="border-top card-body text-center">Have an account? <a href="">Log In</a></div>-->
        </div> <!-- card.// -->
    </div> <!-- col.//-->

</div> <!-- row.//-->

<br><br>

</body>
</html>