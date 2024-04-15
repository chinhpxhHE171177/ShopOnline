<%-- 
    Document   : carts
    Created on : Jan 22, 2024, 5:19:52 PM
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
        <title>Cart</title>
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
            <div class="container " style="min-height: 500px">
                <c:choose>
                    <c:when test="${sessionScope.carts == null ||sessionScope.carts.size() == 0}">
                        <h1 style="color: blue; font-family: cursive">List cart is empty!</h1>
                    </c:when>
                    <c:otherwise>
                        <h3>List of Products</h3>
                        <table class="table" >
                            <thead>
                                <tr>
                                    <th scope="col">#</th>
                                    <th scope="col">Image</th>
                                    <th scope="col">Name</th>
                                    <th scope="col">Price</th>
                                    <th scope="col">Quantity</th>
                                    <th scope="col">Total Price</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="c">
                                <form action="update-quantity">
                                    <tr>
                                    <input type="hidden" name="productId" value="${c.value.product.id}"/>
                                    <th scope="row">${c.value.product.id}</th>
                                    <td><img src="images/${c.value.product.imageUrl}" width="50"/></td>
                                    <td>${c.value.product.name}</td>
                                    <td>${c.value.product.price}</td>
                                    <td><input onchange="this.form.submit()" type="number" name="quantity" value="${c.value.quantity}"></td>
                                    <td>${c.value.quantity * c.value.product.price}</td>
                                    <td><a href="delete-cart?productId=${c.value.product.id}" class="btn btn-outline-danger"><i class="bi bi-trash"></i>DELETE</a></td>
                                    </tr>
                                </form>
                            </c:forEach>
                            </tbody>
                        </table>
                        <h3 style="color: blue">Total Amount:${totalMoney}VND</h3>
                        <a href="check-out" class="btn btn-success w-25" >Check out</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </section>

        <%@include file="components/footerComponent.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>

</html>

