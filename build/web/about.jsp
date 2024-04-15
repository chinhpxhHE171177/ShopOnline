<%-- 
    Document   : home.jsp
    Created on : Jan 20, 2024, 8:49:40 PM
    Author     : Admin
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>About Us</title>
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

    <body>
        <!-- Navigation-->
        <%@include file="components/navbarComponent.jsp" %>
        <div class="banner">
            <img src="images/logo & banner/banner5.jpg" alt="about_us"/>
            <div class="banner-text">
                About Us
            </div>
        </div>

        <div class="content">
            <div class="row">
                <div class="about1 col-lg-4 mb-5 mb-lg-0 col-md-6">
                    <img src="images/logo & banner/about2.jpg" width="100%" alt="">
                </div>
                <div class="about2 col-lg-4 mb-5 mb-lg-0 col-md-6">
                    <img src="images/logo & banner/about1.jpg" alt="">
                </div>
                <div class="about3 col-lg-4">
                    <h1>About Us</h1>
                    <p>With the desire to bring to the Vietnamese market the best quality food, drinks and coffee 
                        from famous brands and countries - Food Mood was born with the first store in Thach Hoa, Thach That, Hanoi.</p>
                    <p style="font-weight: lighter">Với ước muốn mang đến thị trường việt nam những đồ ăn, thức uống và coffee chất lượng nhất cũng như 
                        đến từ những thương hiệu và các nước nổi tiếng - Food Mood đã ra đời với của hàng đầu tiên tại Thạch Hòa, Thạch Thất, Hà Nôi.</p>
                    <p>With 8 years of experience, our restaurant has consolidated and developed to bring safe and healthy food and drinks to everyone.
                        Especially along with the chefs are culinary experts in Vietnam. We believe that it will satisfy the experiencer.</p>
                    <p style="font-weight: lighter">Với 8 năm kinh nghiệm, nhà hàng chúng tôi đã củng cố và phát triển để mang đến những thực phẩm và thức uống an toàn và lành mạnh đến mọi người.
                        Đặc biệt cùng với các đầu bếp là các chuyên gia về ẩm thực tại Việt nam. Chúng tôi tin rằng sẽ làm hài lòng người trải nghiệm.</p>
                    <h6>- Clean Environment</h6>
                    <h6>- Experience Chefs</h6>
                    <h6>- Fresh And Creative Dishes</h6>
                </div>
                <div class="about3 col-lg-5 mb-5 mb-lg-0 col-md-6 mt-5">
                    <img src="images/logo & banner/about3.jpg" width="100%" alt="">
                </div>
                <div class="about5 col-lg-5 mt-5">
                    <p>Customers can choose their favorite dishes thanks to the variety of food and drinks we have. 
                        In addition, we also serve quality coffee to ensure customers get the best enjoyment from our products.</p>
                    <p style="font-weight: lighter">Khách hàng có thể lựa chọn những món ăn yêu thích nhờ vào sự đa dạng của những đồ ăn thức uống mà chúng tôi có.
                        Ngoài ra chúng tôi còn phục vụ cả cà phê chất lượng để đảm bảo những khách hàng có được sự hưởng đãi tốt nhất từ sản phẩm của chúng tôi.</p>
                    <div class="about4 col-lg-5 mb-5 mb-lg-0 col-md-6 mt-5 w-100">
                        <img src="images/logo & banner/about4.jpg" alt="">
                    </div>
                </div>
            </div>
        </div>

        <!--footer--> 
        <%@include file="components/footerComponent.jsp" %>
    </body>
</html>
<!-- Core theme JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
<script src="js/script.js"></script>
