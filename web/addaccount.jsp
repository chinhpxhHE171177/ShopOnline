<%-- 
    Document   : adduser
    Created on : Feb 29, 2024, 3:50:33 PM
    Author     : Admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Add Account</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/my_style.css" rel="stylesheet" />
    </head>

    <body>
        <!--Navigation-->
        <%@include file = "components/navbarComponent.jsp" %>
        <a style="margin: 0px 10px" href="account-management"><i class="bi bi-skip-backward-fill"></i></a>
        <!-- Product Details Section -->
        <form action="add-account" method="post">
            <h3 class="text-danger m-3">${requestScope.error}</h3>
                <div class="w-50 h-75 m-lg-3">
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="text" class="form-control" id="username" name="username" placeholder="Username" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <!--<label for="password" class="form-label">Password</label>-->
                        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                    </div>
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="text" class="form-control" id="fullname" name="fullname" placeholder="Full Name" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="text" class="form-control" id="address" name="address" placeholder="Address" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="text" class="form-control" id="email" name="email" placeholder="Email" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <!--<label for="username" class="form-label">Username</label>-->
                        <input type="number" class="form-control" id="role" name="role" placeholder="Role" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <input type="submit" class="btn btn-primary w-100" value="Add">
                    </div>
                </div>
            </form>
        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>
