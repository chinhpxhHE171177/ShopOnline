//document.addEventListener("DOMContentLoaded", function () {
//    var nut = document.querySelectorAll('div.nut ul li');
//    var slides = document.querySelectorAll('div.slide div');
//    var currentSlide = 0;
//
//    function showSlide(slideIndex) {
//        for (var i = 0; i < slides.length; i++) {
//            slides[i].classList.remove('s1');
//        }
//        slides[slideIndex].classList.add('s1');
//    }
//
//    function nextSlide() {
//        currentSlide++;
//        if (currentSlide >= slides.length) {
//            currentSlide = 0;
//        }
//        showSlide(currentSlide);
//    }
//
//    function previousSlide() {
//        currentSlide--;
//        if (currentSlide < 0) {
//            currentSlide = slides.length - 1;
//        }
//        showSlide(currentSlide);
//    }
//
//    for (var i = 0; i < nut.length; i++) {
//        nut[i].addEventListener('click', function () {
//            var nutnay = this;
//            var vitrislide = 0;
//            for (var i = 0; nutnay === nutnay.previousElementSibling; i++) {
//                //chay den khi nut nay  = null thi dung.
//                // chay xong lenh nay khi click vao nut ta lay dc vitrislide
//            }
//            currentSlide = vitrislide;
//            showSlide(currentSlide);
//        });
//    }
//
//    auto();
//    function auto() {
//        var thoigian = setInterval(function () {
//            nextSlide();
//        }, 7000);
//
//        for (var i = 0; i < 3; i++) {
//            nut[i].addEventListener('click', function () {
//                clearInterval(thoigian);
//                //Click vào một nút bất kì dừng auto chuyển slide
//            });
//        }
//    }
//
//    var x = setInterval(function () {
//        console.log('dm');
//    }, 1000);
//
//}, false);




// show hide password

