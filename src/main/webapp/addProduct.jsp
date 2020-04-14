<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Company Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/main.css">
       
      
       
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
                        <h4 class="card-title mt-2">Add New Product</h4>
                    </header>
                    <article class="card-body">
                        <% long id = Long.parseLong(request.getParameter("id")); %>
                        <form class ="form-addProduct" id="addProduct-form" action = "/products/add/<%=id%>" method="post">
                            <form :hidden path="id"/>
                            <div class="form-row">
                                <div class="col form-group">
                                    <label>Product Name </label>   
                                    <input type="text" id="p_name" name="p_name" class="form-control" placeholder="">
                                </div> <!-- form-group end.// -->
                                <!-- form-group end.// -->
                            </div> <!-- form-row end.// -->

                            <div class="form-group">
                                <label>Description</label>
                                <input type="text" id="p_description" name="p_description" class="form-control" placeholder="">

                            </div>
                            <!-- form-group end.// -->

                            <div class="form-group">
                                <label>Price</label>
                                <input id="p_price" name="p_price" class="form-control" type="number">
                            </div> <!-- form-group end.// -->

                            <div class="form-group">
                                <label>Discount</label>
                                <input id="p_discount" name="p_discount" class="form-control" type="number">
                            </div> <!-- form-group end.// -->
                            
                            <div class="form-group">
                                <button type="submit" class="btn btn-primary btn-block"> ADD PRODUCT  </button>
                            </div> <!-- form-group// -->      
                            
                        </form>
                    </article> <!-- card-body end .// -->
                  
                </div> <!-- card.// -->
            </div> <!-- col.//-->

        </div> <!-- row.//-->


        <!--container end.//-->

        <br><br>

        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    </body>
</html>
