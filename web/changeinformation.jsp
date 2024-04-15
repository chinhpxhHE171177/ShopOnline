<%-- 
    Document   : changepassword
    Created on : Feb 24, 2024, 8:52:58 AM
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
        <title>Change Information</title>
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
        <div class="container w-50 h-75 m-lg-3">
            <a href="profile"><i class="bi bi-skip-backward-fill"></i></a>
        </div>

        <form action="change-information" method="POST">
            <c:set value="${sessionScope.account}" var="a"/>
            <div class="w-50 h-75 m-lg-3">
                <h2 style="color: blue; font-family: fantasy;" class="name m-lg-3">${a.displayName}</h2>
                <div class="form-group p-lg-3">
                    <input type="text" name="username"  class="form-control" value="${a.username}" placeholder="Username"/>
                </div>
                <input type="hidden" name="password" value="${sessionScope.a.password}">
                <div class="form-group p-lg-3">
                    <input  type="text" name="displayName" value="${a.displayName}"  class="form-control" placeholder="Full Name" />
                </div>
                <div class="form-group p-lg-3">
                    <input  type="text" name="address" value="${a.address}"  class="form-control" placeholder="Address" />
                </div>
                <div class="form-group p-lg-3">
                    <input  type="email" name="email" value="${a.email}"  class="form-control" placeholder="Email" />
                </div>
                <div class="form-group p-lg-3">
                    <input  type="text" name="phone" value="${a.phone}"  class="form-control" placeholder="Phone" />
                </div>
                <h3 class="name m-lg-3" style="color: green">${requestScope.message}</h3>
                <div class="form-group tm-d-flex p-lg-3">
                    <input type="submit" class="btn btn-primary w-100" value="CHANGE">
                </div>
            </div>
        </form>
        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>