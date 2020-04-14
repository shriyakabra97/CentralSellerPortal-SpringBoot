<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.acms.CentralSellerPortal.Entities.Seller" %>
<%@ page import="com.acms.CentralSellerPortal.Entities.Product" %>
<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Seller Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    ]
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>


</head>

<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" method="get" style="color:gray ; font-size: 18px">Central Seller Portal</a>ihub.
        </div>
    </div>
</nav>
<br>

<div class="jumbotron">
    <div class="container">

        <% long id = Long.parseLong(request.getParameter("id")); %>
        <form class ="form-view" id="view-form"  action = "/viewSeller/<%=id%>" method="get">
            <form :hidden path="id"/>
            <div class="form-row">
                <div class="form-group">
                    <button  type="submit"  class="btn btn-primary btn-block"> Your Profile</button>
                </div> <!-- form-group// -->
                <!-- form-group end.// -->
            </div>
        </form>

        ${seller}
        <td>Welcome ${seller.sellerName}</td>
        <br>
        <td>ID: <%=id%></td>
        <br>
        <td>Contact No:${seller.sellerContactNo}></td>
        <br>
        <td>E-MAIL:    ${seller.sellerEmailId}      </td>
        <br>
        <td>Store Name:${seller.shopName}       </td>
        <br>
        <td>Address:   ${seller.sellerAddress}     </td>
        <br>

        <a class="btn btn-primary" href="/UpdateSellerprofile.jsp?id=<%=id%>"  action="UpdateSellerprofile.jsp" role="button">Update Profile</a>
        <br>
        <a class="btn btn-primary" href="/addProduct.jsp?id=<%=id%>"  action="addProduct.jsp" role="button">Add New Product</a>
        <br>
        <a class="btn btn-primary" href="/index.html" role="button">Logout</a>
        <br>

        <form class ="form-getProducts" id="getProducts-form"  action = "/products/displayBySellerId/<%=id%>" method="get">
            <form :hidden path="id"/>
            <div class="form-row">
                <div class="form-group">
                    <button  type="submit"  class="btn btn-primary btn-block"> Your Products</button>
                </div> <!-- form-group// -->
                <!-- form-group end.// -->
            </div>
        </form>
    </div>
</div>



<div class="container">
    <div class="row">

        <div class="col-md-12">
            <h4>Your Listed Products</h4>
            <div class="table-responsive">

                <table id="mytable" class="table table-bordred table-striped">
                    <thead>
                    <th>ProductID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price(Rs.)</th>
                    <th>Discount(%)</th>
                    <th>Edit</th>
                    <th>Delete</th>
                    </thead>

                    <tbody>
                    <c:forEach var="e" items="${productList}" >
                    <tr>
                        <!--<td><input type="checkbox" class="checkthis" /></td>-->
                        <td>${e.productId}</td>
                        <td>${e.productName}</td>
                        <td>${e.productDescription}</td>
                        <td>${e.price}</td>
                        <td>${e.discount}</td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Edit"><button class="btn btn-primary btn-xs" data-title="Edit" data-toggle="modal" data-target="#edit" ><i class="fas fa-pencil-square-o"></i></button></p></td>
                        <td><p data-placement="top" data-toggle="tooltip" title="Delete"><button class="btn btn-danger btn-xs" data-title="Delete" data-toggle="modal" data-target="#delete" ><i class="fas fa-trash"></i></button></p></td>
                    </tr>
                    </c:forEach>
                    </tbody>

                </table>

                <div class="clearfix"></div>

            </div>

        </div>
    </div>
</div>


</body>
</html>
