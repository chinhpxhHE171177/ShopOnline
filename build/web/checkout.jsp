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
        <title>Check Out</title>
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

        <a style="margin: 0px 10px" href="carts"><i class="bi bi-skip-backward-fill"></i></a>
        <!-- Product Details Section -->
        <section class="py-5">
            <div class="container " style="min-height: 500px">
                <h2>CHECK OUT</h2>
                <div class="row">
                    <div class="col-md-8" style="border: 1px solid #ccc; border-radius: 5px; padding:1rem">
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
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${carts}" var="c">
                                    <tr>
                                <input type="hidden" name="productId" value="${c.value.product.id}"/>
                                <th scope="row">${c.value.product.id}</th>
                                <td><img src="images/${c.value.product.imageUrl}" width="50"/></td>
                                <td>${c.value.product.name}</td>
                                <td>${c.value.product.price}</td>
                                <td>${c.value.quantity}</td>
                                <td>${c.value.quantity * c.value.product.price}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                        <h3 style="color: blue">Total Amount:${totalMoney}VND</h3>
                    </div>
                    <div class="col-md-4" style="border: 1px solid #ccc; border-radius: 5px; padding: 1rem">
                        <h3>Information of customer</h3>
                        <form action="check-out" method="post">
                            <div class="mb-3">
                                <label for="name" class="form-label">Name</label>
                                <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp">
                                <div id="emailHelp" class="form-text">We'll never share your info with anyone else.</div>
                            </div>
                            <div class="mb-3">
                                <label for="phone" class="form-label">Phone</label>
                                <input type="text" class="form-control" id="phone" name="phone" aria-describedby="emailHelp">
                            </div> 
                            <div class="mb-3">
                                <label for="address" class="form-label">Address</label>
                                <input type="text" class="form-control" id="address" name="address" aria-describedby="emailHelp">
                            </div>
                            <div class="mb-3">
                                <label for="note" class="form-label">Note</label>
                                <textarea class="form-control" id="note" name="note" rows="3"></textarea>
                            </div>
                            <button type="submit" class="btn btn-primary w-100">Submit</button>
                            <h5 class="form-text">${mess}</h5>
                        </form>
                    </div>
                </div>

            </div>
        </section>

        <%--<%@include file="components/footerComponent.jsp" %>--%>
        <!-- Core theme JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
    </body>

</html>

