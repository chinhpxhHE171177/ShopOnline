<%-- 
    Document   : shop.jsp
    Created on : Jan 20, 2024, 8:49:40 PM
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
        <title>Food, Drink and Coffee</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- bootstrap -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <!-- Bootstrap Font Icon CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
        <link href="css/my_style.css" rel="stylesheet">
    </head>

    <body>
        <!-- Navigation-->
        <%@include file="components/navbarComponent.jsp" %>
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white font-monospace">
                    <h1>Menu</h1>
                    <!--<img src="images/logo & banner/banner4.jpg" width="100%" height="200" alt="alt"/>-->
                </div>
            </div>
        </header>

        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <form action="shop" method="post">
                    <div class="row">
                        <div class="col-md-6 mb-2">
                            <select name="sort-by" class="form-select w-50 col-md-3" aria-label="Default select example">
                                <option value="price-up" ${sortBY == 'price-up' ? 'selected' : ''}>Price ↑</option>
                                <option value="price-down" ${sortBY == 'price-down' ? 'selected' : ''}>Price ↓</option>
                                <option value="name-up" ${sortBY == 'name-up' ? 'selected' : ''}>A to Z</option>
                                <option value="name-down" ${sortBY == 'name-down' ? 'selected' : ''}>Z to A</option>
                                <input type="submit" class="btn btn-primary w-50" value="Sort">
                            </select>
                        </div>
                </form> 
                <form action="search-price" method="GET">
                    <div class="col-md-6">
                        <input type="radio" value="1" name="searchByPrice" ${listprice == '1' ? 'checked' : ''}>8.000 - 30.000
                        <input type="radio" value="2" name="searchByPrice" ${listprice == '2' ? 'checked' : ''}>30.000 - 99.000
                        <input type="radio" value="3" name="searchByPrice" ${listprice == '3' ? 'checked' : ''}>100.000 ↑
                        <div> </div>
                        <div class="form-group tm-d-flex">
                            <input type="submit" class="btn btn-primary w-50" value="Search">
                        </div>
                    </div> 
                </form>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="mb-5">
                        <h3>List of Categories</h3>
                        <ul class="list-group">
                            <c:forEach items="${requestScope.listca}" var="c">
                                <li class="list-group-item btn-outline-primary text-white ${tag == c.id ? "active":""}"><a class="text-dark" style="text-decoration: none" href="filter-category?categoryId=${c.id}">${c.name}</a></li>
                                </c:forEach>
                        </ul>
                    </div>
                    <div class="mb-5">
                        <h3 class="card-header bg-success text-white">Newest Product</h3>
                        <div class="text-center">
                            <a href="detail?productId=${lastpro.id}">
                                <img class="img-fluid" src="images/${lastpro.imageUrl}" alt="alt"/>
                            </a>
                            <a class="text-decoration-none link-dark" href="detail?productId=${lastpro.id}"><h5 class="fw-bolder">${lastpro.name}</h5></a>
                            <p class="card-text">${lastpro.description}</p>
                            <p class="text-danger"><fmt:formatNumber value="${lastpro.price}" pattern=".000 VND" /></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-9">
                    <h3>List of Products</h3>
                    <div><h3 class="d-flex justify-content-center font-monospace text-secondary">${requestScope.mess}</h3></div>
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
                                            <!--<span class="text-muted text-decoration-line-through">150.000</span>-->
                                            <fmt:formatNumber value="${p.price}" pattern=".000 VND" />
                                            <!--${p.price}-->
                                        </div>
                                    </div>
                                    <!-- Product actions-->
                                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
<!--                                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" onclick="addToCartAsync(${p.id})">Add to
                                                cart</a>
                                        </div>-->
                                        <div class="text-center"><a class="btn btn-outline-dark text-primary" href="add-to-cart?productId=${p.id}">Add to
                                                cart</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <!--Paging-->
                    <nav aria-label="Page navigation example" class="d-flex justify-content-center">
                        <ul class="pagination">
                            <li class="page-item ${page == 1 ? 'disabled' : ''}">
                                <a class="page-link" href="shop?page=${page-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <li class="page-item ${i == page ? 'active' : ''}">
                                    <a class="page-link" href="shop?page=${i}">${i}</a>
                                </li>
                            </c:forEach>
                            <li class="page-item ${page == totalPage ? 'disabled' : ''}">
                                <a class="page-link" href="shop?page=${page+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
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
    <script>
        function addToCartAsync(productId) {
            axios.get('add-to-cart-async', {
                params: {
                    productId: productId
                }
            }).then((response) => {
                // lay data thanh cong
                document.getElementById("cart_number").innerHTML = response.data;
                //cap nhat view
            });
        }
    </script>
</body>

</html>



