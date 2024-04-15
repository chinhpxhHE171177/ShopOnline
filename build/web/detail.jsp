<%-- 
    Document   : detail.jsp
    Created on : Jan 21, 2024, 9:30:21 PM
    Author     : Admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Shop Food, Drink and Coffee</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>

    <body>
        <!--Navigation-->
        <%@include file = "components/navbarComponent.jsp" %>
        <!-- Product Details Section -->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6">
                        <img class="img-fluid mb-4 mb-md-0 w-75 h-25 mt-2 float-end" src="images/${product.imageUrl}" alt="Product Image">
                    </div>
                    <div class="col-md-6">
                        <div class="card p-5" style="background-color: #bacbe6; font-family: monospace; justify-content: center" >
                            <!--<div class="small mb-1">${product.id}</div>-->
                            <h1 class="display-5 fw-bolder">${product.name}</h1>
                            <div class="fs-5 mb-3 ">
                                <!--<span class="text-decoration-line-through">$45.00</span>-->
                                <fmt:formatNumber value="${product.price}" pattern=".000 VND" />
                            </div>
                            <div>
                                <p class="lead link-secondary">${product.description}</p>
                            </div>
                            <div class="d-flex">
                                <a href="add-to-cart?productId=${product.id}" class="btn btn-outline-dark flex-shrink-0 " type="button">
                                    <i class="bi-cart-fill me-1 "></i>
                                    Add to cart
                                </a>
                                <a href="carts" class="btn btn-outline-success flex-shrink-0 ms-2" type="button">
                                    <i class="bi-cart-fill me-1"></i>
                                    Buy now
                                </a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!-- Related items section-->
        <section class="row py-5 bg-light">
            <div class="container px-4 px-lg-5 mt-5 col-md-10">
                <h2 class="fw-bolder mb-4">Related products</h2>
                <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="0">
                    <!-- Carousel indicators -->
                    <ol class="carousel-indicators">
                        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#myCarousel" data-slide-to="1"></li>
                        <li data-target="#myCarousel" data-slide-to="2"></li>
                    </ol>  
                </div>
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-4  justify-content-center">
                    <c:forEach items="${requestScope.listpro}" var="p">
                        <div class="col mb-5">
                            ${p.id}
                            <div class="card h-100">
                                <!-- Sale badge-->
                                <div class="badge bg-dark text-white position-absolute"
                                     style="top: 0.5rem; right: 0.5rem">Sale</div>
                                <!-- Product image-->
                                <a href="detail?productId=${p.id}">
                                    <img class="card-img-top" src="images/${p.imageUrl}" width="100%" height="300px"
                                         alt="..." />
                                </a>
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <a class="text-decoration-none link-dark" href="detail?productId=${p.id}"><h5 class="fw-bolder">${p.name}</h5></a>
                                        <!-- Product reviews-->
                                        <div class="d-flex justify-content-center small text-warning mb-2">
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                            <div class="bi-star-fill"></div>
                                        </div>
                                        <!-- Product price-->
                                        <fmt:formatNumber value="${p.price}" pattern=".000 VND" />
                                    </div>
                                </div>
                                <!-- Product actions-->
                                <div class="d-flex justify-content-center text-center pb-3">
                                    <a href="add-to-cart?productId=${p.id}" class="btn btn-outline-dark flex-shrink-0 " type="button">
                                        <i class="bi-cart-fill me-1 "></i>
                                        Add to cart
                                    </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
        </section>

        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

