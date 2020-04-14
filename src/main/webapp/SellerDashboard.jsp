
<%@ page import="com.acms.CentralSellerPortal.Entities.Seller" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.acms.CentralSellerPortal.Entities.Product" %>
<%@ page import="org.springframework.http.ResponseEntity" %>
<%@ page import="com.acms.CentralSellerPortal.Controllers.SellerController" %>
<%@ page import="com.acms.CentralSellerPortal.Controllers.ProductController" %>
<%@ page import="org.springframework.web.bind.annotation.RequestMapping" %>
<%--<%@ page import="org.springframework.web.bind.annotation.RequestBody" %>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Seller Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <link rel="stylesheet" href="../css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="../css/main.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css" rel='stylesheet' type='text/css'>


</head>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" method="get" style="color:gray ; font-size: 18px">Central Seller Portal</a>
        </div>
    </div>
</nav>
<br>

<div class="jumbotron">
    <div class="container">



        <% long id = Long.parseLong(request.getParameter("id")); %>
<%--        <jsp:useBean id="seller" scope="request" class="com.acms.CentralSellerPortal.Entities.Seller"/>--%>
        <form class ="form-view" id="view-form"  action = "/viewSeller/<%=id%>" method="get">
            <form :hidden path="id"/>
            <div class="form-row">
                <div class="form-group">
                    <button  type="submit"   class="btn btn-primary btn-block"> View Your Profile</button>
                </div> <!-- form-group// -->
                <!-- form-group end.// -->
            </div>
        </form>


<%--        ${seller}--%>
        <td>Welcome   ${sellerName}         </td>
        <br>
        <td>ID: <%=id%>                             </td>
        <br>
        <td>Contact No:   ${sellerContactNo}</td>
        <br>
        <td>E-mail:   ${sellerEmailId}      </td>
        <br>
        <td>Store Name:    ${shopName}       </td>
        <br>
        <td>Address:   ${sellerAddress}     </td>
        <br>
        <br>
        <a class="btn btn-primary" href="/UpdateSellerProfile.jsp?id=<%=id%>"  action="UpdateSellerprofile.jsp" role="button">Update Profile</a>
        <a class="btn btn-primary" href="/index.html" role="button">Logout</a>
    </div>
</div>

<div class="container">
    <div class="row">
        <form class ="form-view" id="view-form-products"  action = "/products/displayBySellerId/<%=id%>" method="get">
            <form :hidden path="id"/>
            <div class="form-row">
                <div class="form-group">
                    <button  type="submit"   class="btn btn-primary btn-block"> View Your Products</button>
                </div> <!-- form-group// -->
                <!-- form-group end.// -->
            </div>
        </form>


        <div class="col-md-12">
            <h4> ${sellerName}, Here are your Listed Products</h4>
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
<%--                    <jsp:useBean id="productList" scope="request" type="java.util.List" class="com.acms.CentralSellerPortal.Entities.Product"/>--%>
                    <c:forEach var="e" items="${productList}">
                    <tr>
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
<dev class="container">
    <a id="add_row"  href="/AddProduct.jsp?id=<%=id%>"  action="AddProduct.jsp"  class="btn btn-primary float-right" style="color: white; margin-right: 30px ;margin-bottom: 30px ; margin-top: 10px" role="button">Add Product</a>
</dev>

<br>


</body>
</html>