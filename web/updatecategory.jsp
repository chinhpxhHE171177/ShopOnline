<%-- 
    Document   : addcategory
    Created on : Feb 22, 2024, 4:55:32 PM
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
        <title>Update Category</title>
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
        <c:set var="c" value="${requestScope.category}"/>
        <!--        <form action="update-category" method="post">
                    Enter ID:<input type="number" readonly name="id" value="${c.id}"/><br/>
                    Enter Name:<input type="text" name="name" value="${c.name}"/><br/>
                    <input type="submit" value="UPDATE"/>
                </form>-->

        <a style="margin: 0px 10px" href="product-management"><i class="bi bi-skip-backward-fill"></i></a>
        <!-- Product Details  Section -->
        <form action="update-category" method="POST">
            <div class="w-50 h-75 m-lg-3">
                <div class="form-group p-lg-3">
                    <input type="number" name="id"  class="form-control" readonly value="${c.id}" />
                </div>
                <div class="form-group p-lg-3">
                    <input  type="text" name="name"  class="form-control" value="${c.name}" />
                </div>
                <div class="form-group tm-d-flex p-lg-3">
                    <input type="submit" class="btn btn-primary w-100" value="UPDATE">
                </div>
            </div>
        </form>
        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>


