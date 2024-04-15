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
        <title>Change Password</title>
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

        <form action="change-password" method="POST">
            <c:set value="${sessionScope.account}" var="a"/>
            <div class="w-50 h-75 m-lg-3">
                <h2 style="color: blue; font-family: fantasy;" class="name m-lg-3">${a.displayName}</h2>
                <div class="form-group p-lg-3">
                    <input type="password" name="oldPass"  class="form-control" placeholder="Old Password"/>
                </div>
                <input type="hidden" name="username"  class="form-control" value="${sessionScope.a.username}"/>
                <div class="form-group p-lg-3">
                    <input  type="password" name="newPass"  class="form-control" placeholder="New Password" />
                </div>
                <h3 class="name m-lg-3" style="color: red">${requestScope.message}</h3>
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