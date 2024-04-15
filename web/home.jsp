<%-- 
    Document   : home.jsp
    Created on : Jan 20, 2024, 8:49:40 PM
    Author     : Admin
--%>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Food, Drink and Coffee</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />

        <!-- Icon Font Stylesheet -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

        <!-- Libraries Stylesheet -->
        <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
        <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="css/my_style.css">
    </head>

    <body>
        <!-- Navigation-->
        <%@include file="components/navbarComponent.jsp" %>

        <div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="1" aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleDark" data-bs-slide-to="2" aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active" data-bs-interval="10000">
                    <a href="home1"><img src="images/logo & banner/banner1.jpg" class="d-block w-100" alt="banner_food"></a>
                    <!--                    <div class="carousel-caption d-none d-md-block text-danger">
                                            <h5>First slide label</h5>
                                            <p>Some representative placeholder content for the first slide.</p>
                                        </div>-->
                </div>
                <div class="carousel-item" data-bs-interval="5000">
                    <img src="images/logo & banner/banner2.jpg" class="d-block w-100" alt="banner_drink">
                    <!--                    <div class="carousel-caption d-none d-md-block">
                                            <h5>Second slide label</h5>
                                            <p>Some representative placeholder content for the second slide.</p>
                                        </div>-->
                </div>
                <div class="carousel-item">
                    <img src="images/logo & banner/banner3.jpg" class="d-block w-100" alt="banner_coffee">
                    <!--                    <div class="carousel-caption d-none d-md-block">
                                            <h5>Third slide label</h5>
                                            <p>Some representative placeholder content for the third slide.</p>
                                        </div>-->
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleDark" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>

        <!-- Content in body -->
        <div class="welcome">
            <!--<div class="small text-white stretched-link">View access: ${view}</div>-->
            <h1 style="text-align: center; font-family:  Georgia; color: red; margin-top: 20px;">Welcome</h1>
            <h1 style="text-align: center; font-family: Georiga"> to The World of Testy and Fresh Food, Drink & Coffee</h1>
        </div>
        <div class="intro">
            <div class="row intro_content">
                <div class="about col-lg-4 col-md-4">
                    <div class="intro_content_details">
                        <i class="far fa-newspaper fs-1"></i>
                        <h5>What new's</h5>
                        <p>We always update new products in here!</p>
                    </div>
                </div>
                <div class="contact_info col-lg-4 col-md-4">
                    <div class="intro_content_details">
                        <i class="fas fa-th-list fs-1"></i>
                        <h5>Online Order</h5>
                        <p>All orders will be processed and delivered quickly to customers,
                            ensuring the quality of food and drinks.</p>
                    </div>
                </div>
                <div class="openning col-lg-4 col-md-4">
                    <div class="intro_content_details">
                       <i class="fas fa-thumbs-up fs-1"></i>
                        <h5>Favor</h5>
                        <p>Please always love and support us a lot. Thank you!</p>
                    </div>
                </div>
            </div>
            <h3 hidden="" class="text-dark">${views}</h3>
        </div>
        
         <!-- Featurs Section Start -->
        <div class="container-fluid featurs py-5">
            <div class="container py-5">
                <div class="row g-4">
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square fs-1 mb-2 mx-auto">
                                <i class="fas fa-car-side"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Free Shipping</h5>
                                <p class="mb-0">Free on order over 500K</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square fs-1 mb-2 mx-auto">
                                <i class="fas fa-user-shield"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Security Payment</h5>
                                <p class="mb-0">100% security payment</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square fs-1 mb-2 mx-auto">
                                <i class="fas fa-exchange-alt"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>Day Return</h5>
                                <p class="mb-0">Return orders with the same day</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 col-lg-3">
                        <div class="featurs-item text-center rounded bg-light p-4">
                            <div class="featurs-icon btn-square fs-1 mb-2 mx-auto">
                                <i class="fas fa-phone"></i>
                            </div>
                            <div class="featurs-content text-center">
                                <h5>24/7 Support</h5>
                                <p class="mb-0">Support every time fast</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         
        <!-- Featurs Section End -->

        <!--footer--> 
        <%@include file="components/footerComponent.jsp" %>

        <!-- Core theme JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
        <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
        <script src="js/script.js"></script>
    </body>
</html>

