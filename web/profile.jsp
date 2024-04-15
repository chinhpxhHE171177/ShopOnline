<%-- 
    Document   : profile
    Created on : Feb 23, 2024, 9:59:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Profile</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Bootstrap Font Icon CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="css/my_style.css">

    </head>
</head>
<body>
    <!-- Navigation-->
    <%@include file="components/navbarComponent.jsp" %>
    <div>
        <a style="margin: 0px 10px" href="home"><i class="bi bi-skip-backward-fill"></i></a>

        <c:set var="a" value="${sessionScope.account}"/>
        <h3 style="font-family: fantasy; color: #664d03" class="col-12 text-center tm-section-title">
            Welcome ${a.role == 1 ? "Admin " : "User " } ${a.displayName}</h3>
        <div style="font-family: serif;" class="row mt-5 w-100">
            <div class="col-lg-6">
                <div style="background-color: #e6dbb9" class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Full Name</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${a.displayName}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Email</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${a.email}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Phone</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${a.phone}</p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0">Address</p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0">${a.address}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="col-lg-6">
                <img src="https://ashleymarahart.com/wp-content/uploads/2020/11/AboutMe.jpg" alt="alt"/>
            </div> 
            <div class="edit">
                <a style="text-decoration: none" href="change-password">Change Password</a>
            </div>
            <div class="edit">
                <a style="text-decoration: none" href="change-information">Change Information</a>
            </div>
        </div>
        <!-- Footer-->
        <%--<%@include file="components/navbarComponent.jsp" %>--%>
</body>
</html>
