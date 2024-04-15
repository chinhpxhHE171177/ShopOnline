<%-- 
    Document   : accountupdate
    Created on : Feb 29, 2024, 8:59:36 PM
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
        <title>Update Account</title>
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
            <a href="account-management"><i class="bi bi-skip-backward-fill"></i></a>
        </div>

        <form action="update-account" method="POST">
            <c:set value="${requestScope.account}" var="a"/>
            <div class="w-50 h-75 m-lg-3">
                <div class="form-group p-lg-3">
                    <input type="number" name="id" class="form-control" readonly value="${a.id}"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="username" class="form-control" readonly value="${a.username}" placeholder="Username"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="password" name="password" class="form-control" readonly value="${a.password}" placeholder="Password"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="displayName" class="form-control" readonly value="${a.displayName}" placeholder="Full Name" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="address" class="form-control" readonly value="${a.address}" placeholder="Address" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="email" name="email" class="form-control" readonly value="${a.email}" placeholder="Email" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="phone" class="form-control" readonly value="${a.phone}" placeholder="Phone" />
                </div>
                <div class="form-group p-lg-3">
                    <select name="role" class="form-control">
                        <option value="2" ${a.role == 2 ? 'selected' : ''}>User</option>
                        <option value="1" ${a.role == 1 ? 'selected' : ''}>Admin</option>
                    </select>
                </div>
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
