<%-- 
    Document   : addproduct
    Created on : Feb 21, 2024, 12:14:08 AM
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
        <title>Update Product</title>
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
        <c:set var="p" value="${requestScope.product}"/>

        <a style="margin: 0px 10px" href="product-management"><i class="bi bi-skip-backward-fill"></i></a>
        <!-- Product Details  Section -->
        <form action="update-product" method="POST" >
            <div class="w-50 h-75 m-lg-3">
                <div class="form-group p-lg-3">
                    <input type="number" name="id"  class="form-control" readonly value="${p.id}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="name"  class="form-control" value="${p.name}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="price"  class="form-control" value="${p.price}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="quantity"  class="form-control" value="${p.quantity}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="describe"  class="form-control" value="${p.description}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <img src="images/${p.imageUrl}" alt="Product Image" width="100" height="100"/>
                </div>
                <div class="form-group p-lg-3">
                    <input type="file" name="image"  class="form-control" value="${p.imageUrl}" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="mfgDate"  class="form-control" value="${p.mfgDate}" required="" />
                </div>
<!--                <div class="form-group p-lg-3">
                    <input type="number" name="categoryId"  class="form-control" readonly value="${p.categoryId}" required="" />
                </div>-->
                <div class="form-group tm-d-flex p-lg-3">
                    <select name="categoryId" style="width: 50%; border: 1px solid black">
                        <c:forEach var="sb" items="${requestScope.catego}">
                            <option <c:if test="${sb.id == p.categoryId}">selected</c:if> value="${sb.id}"> ${sb.name}</option> 
                        </c:forEach>
                    </select>
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

