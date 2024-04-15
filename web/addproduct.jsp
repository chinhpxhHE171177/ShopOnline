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
        <title>Add Product</title>
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
        <a style="margin: 0px 10px" href="product-management"><i class="bi bi-skip-backward-fill"></i></a>
        <!-- Product Details  Section -->
        <form action="add-product" method="POST" enctype="multipart/form-data" >
            <div class="w-50 h-75 m-lg-3">
                <div class="form-group p-lg-3">
                    <input type="text" name="name"  class="form-control" placeholder="Product name" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="price"  class="form-control" placeholder="Product price" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="number" name="quantity"  class="form-control" placeholder="Product quantity" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="text" name="describe"  class="form-control" placeholder="Product describe" required="" />
                </div>
                <div class="form-group p-lg-3">
                    <input type="file" name="image"  class="form-control" placeholder="Product image" required="" />
                </div>
                <div class="form-group tm-d-flex p-lg-3">
                    <select name="cid" style="width: 50%; border: 1px solid black">
                        <c:forEach var="sb" items="${requestScope.catego}">
                            <option value="${sb.id}"> ${sb.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group tm-d-flex p-lg-3">
                    <input type="submit" class="btn btn-primary w-100" value="Add">
                </div>
            </div>
        </form>

        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

