<%-- 
    Document   : usermanager
    Created on : Feb 29, 2024, 3:13:20 PM
    Author     : Admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Account Management</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Bootstrap Font Icon CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="css/my_style.css" rel="stylesheet">
    </head>

    <script type="text/javascript">
        function doDeletebyAccount(id) {
            if (confirm("Are you sure to delete account with id =" + id)) {
                window.location = "delete-account?id=" + id;
            }
        }
    </script>
    <body>

        <!-- Navigation-->
        <%@include file="components/navbarComponent.jsp" %>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white font-monospace">
                    <h1 style="font-family: monospace; font: italics">Admin Home</h1>
                    <h5 class="font-monospace text-secondary">Account Management</h5>
                    <!--<img src="images/logo & banner/banner4.jpg" width="100%" height="200" alt="alt"/>-->
                </div>
            </div>
        </header>
        <div class="row">
            <!--<h1 class="font-monospace text-secondary">Account Management</h1>-->
            <a class="text-decoration-none p-0 fs-5" href="add-account"><i class="bi bi-person-plus"></i>Add Account</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Username</th>
                        <th>Password</th>
                        <th>Display Name</th>
                        <th>Address</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Status</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="acc" items="${account}">
                        <tr>
                            <td>${acc.id}</td>
                            <td>${acc.username}</td>
                            <td>${acc.password}</td>
                            <td>${acc.displayName}</td>
                            <td>${acc.address}</td>
                            <td>${acc.email}</td>
                            <td>${acc.phone}</td>
                            <td>${acc.role == 1 ? 'Admin' : 'User'}</td>
                            <td class="text-center fs-5">
                                <a href="update-account?id=${acc.id}"><i class="bi bi-pen"></i></a>
                                <a href="#" onclick="doDeletebyAccount('${acc.id}')"><i class="bi bi-trash"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <!--footer-->
        <%--<%@include file="components/footerComponent.jsp" %>--%>
    </body>
</html>