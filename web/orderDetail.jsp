<%-- 
    Document   : OrderDetail
    Created on : Mar 7, 2024, 10:11:04 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Order Details</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Bootstrap Font Icon CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/my_style.css">
    </head>
    <body>
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white font-monospace">
                    <h1>List Orders</h1>
                </div>
            </div>
        </header>
        <h5><a href="dashboard"><i class="bi bi-skip-backward-fill"></i></a></h5>
    <center>
        <table class=" table table-group-divider table-striped table-hover w-75 mt-3">
            <thead>
                <tr>
                    <th>Order Id</th>
                    <th>Product Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Note</th>
                    <th>Created Date</th>
                    <th>Total Price</th>
                    <th>Name</th>
                    <th>Phone</th>
                    <th>Address</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="o" items="${requestScope.orderDetail}">
                    <tr>
                        <td>${o.id}</td>
                        <td>${o.productName}</td>
                        <td>${o.quantity}</td>
                        <td>${o.price}</td>
                        <td>${o.note}</td>
                        <td>${o.date}</td>
                        <td>${o.totalPrice}</td>
                        <td>${o.displayName}</td>
                        <td>${o.phone}</td>
                        <td>${o.address}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </center>
</body>
</html>
