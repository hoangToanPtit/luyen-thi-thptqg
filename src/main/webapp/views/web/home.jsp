<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- iconsout -->
    <!-- https://iconscout.com/unicons/explore/line -->
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
    <!-- iconsout -->
    <link rel="stylesheet" href="./asset/css/web/style3.css">
    <link rel="stylesheet" href="./asset/css/web/home.css">
    <title>Đề thi</title>
</head>
<body>
    <div class="trang-admin">

        <!-- ======================= Đầu trang ================ -->
        <div class="dau-trang">
            <div class="logo">
                <img src="./asset/img/logo4.png" alt="logo">
            </div>

            <div class="o-tim-kiem" style="display: none;">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Nhập nội dung tìm kiếm">
            </div>
            <%
            	if(session.getAttribute("userId")!=null){
            %>
            <div class="tai-khoan">
                <img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="">
                <span><%= session.getAttribute("lastName") %> <%= session.getAttribute("firstName") %></span>
            </div>
            <% }else{ %>
            <div class="tai-khoan">
                <a href="login"><button>Đăng Nhập</button></a>
            </div>
            <% } %>
        </div>

        <!-- ============================= Menu trái================= -->
        


        <!-- ================================= Nội dung ================== -->
        <div class="noi-dung">
            <div class="gioi_thieu">
                <h1>LUYỆN THI THPTQG</h1>
                <p>
                    Giúp học sinh ôn luyện, tối ưu điểm số cho kỳ thi THPTQG.
                </p>
                <p>
                    Tổng hợp các đề thi chính thức và các đề thi thử của các tỉnh.
                </p>
                <p>
                    Làm bài, nhận kết quả trực tiếp trên hệ thống.
                </p>
                <p>
                    Hãy đăng ký để sử dụng các chức năng của hệ thống.
                </p>

               
                <a href="exams">Tìm kiếm đề thi</a>
                <a href="signup">Đăng ký</a>
              
            </div>

            <div class="nut-chuyen-trang">

            
                <img src="./asset/img/edu_onl.webp" alt="">
            </div>
            
        </div>

        
        <div class="cuoi-trang">
            <i class="uil uil-copyright"></i> NVT-LTWEB
        </div>
    </div>

</body>
</html>