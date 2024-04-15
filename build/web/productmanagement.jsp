<%-- 
    Document   : dashboard
    Created on : Feb 22, 2024, 10:15:19 PM
    Author     : Admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Management</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Bootstrap Font Icon CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <!--<link rel="stylesheet" href="css/mystyle.css">-->
        <link href="css/my_style.css" rel="stylesheet">
    </head>

    <style>
        /* Style for list items */
        .tm-paging-item {
            list-style-type: none; /* Remove default list style */
            margin: 20px 10px;
            padding: 5px; /* Add padding for better readability */
            /*background-color: #f0f0f0;  Background color for list items */
            border-radius: 5px; /*Add rounded corners */
            border: 1px solid #007bff;
            display: inline-block;
        }

        /* Style for edit and delete icons */
        .bi {
            margin-left: 5px; /* Add space between icon and text */
            color: #007bff; /* Set icon color */
            text-decoration: none; /* Remove default underline */
        }

        /* Style for hover effect on edit and delete icons */
        .bi:hover {
            color: #0056b3; /* Change icon color on hover */
        }
    </style>

    <script type="text/javascript">
        function doDeletebyCategory(id) {
            if (confirm("Are you sure to delete category with id =" + id)) {
                window.location = "delete-category?id=" + id;
            }
        }
    </script>

    <script type="text/javascript">
        function doDeletebyProduct(id) {
            if (confirm("Are you sure to delete product with id =" + id)) {
                window.location = "delete-product?id=" + id;
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
                    <h5 class="font-monospace text-secondary">Product Management</h5>
                    <!--<img src="images/logo & banner/banner4.jpg" width="100%" height="200" alt="alt"/>-->
                </div>
            </div>
        </header>
        <a href="home"><i class="bi bi-skip-backward-fill"></i></a>

        <div class="addProduct mt-3">
            <a class="bg-success text-white" style="text-decoration: none; margin: 30px 20px; 
               font-size: large; border: 1px solid #000; padding: 10px 30px" href="add-product">Add Product</a>
        </div>

        <!-- Section-->
        <section class="main"> <div class="tm-paging mt-3 col-md-12 text-center ">
                <a class="btn btn-outline-dark" href="add-category">
                    <i class="bi bi-plus-circle-fill"></i>
                </a>
                <c:forEach items="${requestScope.listca}" var="c">
                    <li class="tm-paging-item">
                        <a style="text-decoration: none; padding: 10px 30px" href="filter-category-dashboard?categoryId=${c.id}">${c.name}</a>
                        <a href="update-category?id=${c.id}"><i class="bi bi-pencil-square"></i></a>
                        <a href="#" onclick="doDeletebyCategory('${c.id}')"><i class="bi bi-trash"></i></a>
                    </li>
                </c:forEach>
            </div>
            <div class="container">
               
                <div class="row">
                    <div class="col-md-12">
                        <!--<h3>List of Products</h3>-->
                        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3  justify-content-center">
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
                                                <h5 class="fw-bolder">${p.name}</h5><br>

                                                <h5 class="fw-light">${p.description}</h5><br>
                                                <!-- Product price-->
                                                <!--<span class="text-muted text-decoration-line-through">150.000</span>-->
                                                <fmt:formatNumber value="${p.price}" pattern=".000 VND" />
                                                <!--${p.price}-->
                                            </div>
                                        </div>
                                        <!-- Product actions-->
                                        <div class="d-flex flex-row">
                                            <a href="update-product?id=${p.id}"><i class="bi bi-pencil-square"></i></a>
                                            <a href="#" onclick="doDeletebyProduct('${p.id}')"><i class="bi bi-trash"></i></a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!--footer-->
        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/axios@1.6.7/dist/axios.min.js"></script>

    </body>

</html>
