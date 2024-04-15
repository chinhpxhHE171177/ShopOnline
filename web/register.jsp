<%-- 
    Document   : detail.jsp
    Created on : Jan 21, 2024, 9:30:21 PM
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
        <title>Register</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/my_style.css" rel="stylesheet" />
    </head>
    <style>
        body {
            width: 100%;
            height: auto;
            background-image: url("https://e0.pxfuel.com/wallpapers/386/919/desktop-wallpaper-website-background-website-login-page-background.jpg");
        }
    </style>
    <body>
        <h1 class="mt-5" style="text-align: center; font-family: sans-serif; font: bolders">SIGN UP</h1>
        <div style="width: 500px; height: 410px; margin: auto; border: 1px solid #ccc; padding: 1rem; background-color: #ccc" class="mt-5">
            <form action="register" method="post">
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
                    <input type="hidden" class="form-control" id="address" name="address" placeholder="Address" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <!--<label for="username" class="form-label">Username</label>-->
                    <input type="text" class="form-control" id="email" name="email" placeholder="Email" aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <!--<label for="username" class="form-label">Username</label>-->
                    <input type="text" class="form-control" id="phone" name="phone" placeholder="Phone" aria-describedby="emailHelp">
                </div>
                <h3 class="text-danger">${requestScope.error}</h3>
                <button type="submit" class="btn btn-primary w-100">Sign in</button>
                <div class="mb-3 form-check mt-2 p-0">
                    <div><a style="text-decoration: none; font: lighters" href="login">Already have an account?</a></div>
                </div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

