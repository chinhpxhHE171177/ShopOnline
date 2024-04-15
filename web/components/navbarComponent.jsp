<%-- 
    Document   : navigationComponent
    Created on : Jan 20, 2024, 4:46:44 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light" style="background: rgb(69,89,91)">
    <div class="container px-4 px-lg-5">
        <h1><a class="text-white display-6" href="home">Food Mood</a></h1>
        <button class="navbar-toggler" 
                type="button" 
                data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" 
                aria-controls="navbarSupportedContent" 
                aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <!--                <li class="nav-item"><a class="nav-link active" aria-current="page" href="home">Home</a></li>-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" href="#" id="navbarDarkDropdownMenuLink" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Home
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDarkDropdownMenuLink">
                        <li><a class="dropdown-item" href="home1">FOOD</a></li>
                        <li><a class="dropdown-item" href="home2">DRINK</a></li>
                        <li><a class="dropdown-item" href="home3">COFFEE</a></li>
                    </ul>
                </li>
                <li class="nav-item "><a class="nav-link text-white" href="about.jsp">About</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-white" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="shop">All Products</a></li>
                        <li>
                            <hr class="dropdown-divider" />
                        </li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                    </ul>
                </li>
                <c:choose>
                    <c:when test="${sessionScope.account != null && sessionScope.account.role == 1}">
                        <!--<li class="nav-item "><a class="nav-link text-white" href="dashboard" class="nav-link ms-lg-2 fs-2">Dashboard</a></li>-->
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-white" id="navbarDropdown" href="#" role="button"
                               data-bs-toggle="dropdown" aria-expanded="false">Dashboard</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="dashboard">DashBoard</a></li>
                                <li><a class="dropdown-item" href="account-management">Account Management</a></li>
                                <li><a class="dropdown-item" href="product-management">Product Management</a></li>
                            </ul>
                        </li>
                    </c:when>
                </c:choose>
            </ul>

            <form action="search" class="d-flex mx-auto">
                <input value="${txtSearch}" name="txt" class="form-control me-2" type="search" placeholder="Search" aria-label="Search" id="datatable-search-input">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
            <div class="d-flex my-2">
                <a class="btn btn-outline-dark" href="carts">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span id="cart_number" class="badge bg-dark text-white ms-1 rounded-pill">${sessionScope.carts.size()}</span>
                </a>
            </div>

            <c:choose>
                <c:when test="${sessionScope.account != null}">
                    <a href="login" class="btn btn-outline-primary ms-lg-2">${sessionScope.account.displayName}</a>
                    <a href="logout" class="btn btn-outline-primary ms-lg-2">Logout</a>
                    <a href="profile" class="ms-lg-2 fs-2"><i class="bi bi-person-circle"></i></a>
                    </c:when>
                    <c:otherwise>
                    <a href="login" class="btn btn-outline-primary ms-lg-2">Login</a>
                    <a href="register" class="btn btn-outline-primary ms-lg-2">Sign up</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>
</nav>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
<link href="css/mystyle.css" rel="stylesheet" />