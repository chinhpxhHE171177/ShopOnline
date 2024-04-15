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
        <title>Login</title>
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
        <div style="width: 500px; height: 350px; margin: auto; border: 1px solid #ccc; padding: 1rem; background: #ccc" class="mt-5">
            <h3 style="text-align: center">Login your Account</h3>
            <form action="login" method="post">
                <div class="mb-3">
                    <!--<label for="username" class="form-label">Username</label>-->
                    <input type="text" class="form-control" id="username" name="username" placeholder="username" aria-describedby="emailHelp">
                    <div id="emailHelp" class="form-text">We'll never share your info with anyone else.</div>
                </div>
                <div class="mb-3">
                    <!--<label for="password" class="form-label">Password</label>-->
                    <input type="password" class="form-control" id="password" name="password" placeholder="password">
                </div>
                <div class="mb-3 form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1" name="remember">
                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                </div>
                <h3 class="text-danger">${error}</h3>
                <button type="submit" class="btn btn-primary w-100">Login</button>
                <div class="mb-3 mt-2" style="font: lighters">
                    <div class="form-text"><a style="text-decoration: none" href="register">Haven't have account yet?</a></div>
                </div>
            </form>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

