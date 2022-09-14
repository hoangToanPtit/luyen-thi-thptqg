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
    <link rel="stylesheet" href="./asset/css/web/chitietdt.css">
    <!-- <link rel="stylesheet" href="./asset/css/dethiweb.css"> -->
    <title>Đề thi</title>
    <link rel = "icon" href = "./asset/img/logo1.png"  type = "image/x-icon">
</head>
<body>
    <div class="trang-admin">

        <!-- ======================= Đầu trang ================ -->
        <div class="dau-trang">
            <div class="logo">
                <img src="./asset/img/logo4.png" alt="logo">
            </div>

            <div class="o-tim-kiem">
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
        <div class="menu-doc">
            <ul class="danh-muc">
                <li class="muc-ql ">
                    <i class="uil uil-estate"></i>
                    <a href="home">Home</a>
                </li>
                <li class="muc-ql duoc-chon">
                    <i class="uil uil-file"></i>
                    <a href="exams">Đề thi</a>
                </li>
                <li class="muc-ql">
                    <i class="uil uil-setting"></i>
                    <a href="infor">Cài đặt</a>
                </li>
                <li class="muc-ql">
                    <i class="uil uil-signout"></i>
                    <a href="logout">Đăng xuất</a>
                </li>
              
            </ul>
        </div>


        <!-- ================================= Nội dung ================== -->
        <div class="noi-dung" id="<%= request.getAttribute("examId")%>">
            <p class="ten-muc">CHI TIẾT ĐỀ THI:</p>

            <a href="student_exam?id=<%= request.getAttribute("examId")%>" class="nut_bat_dau_lam_bai">Bắt đầu làm bài</a>

            <div class="chi-tiet-de-thi">
                <p class="ten-de"></p>
                <div class="chua-cau-hoi-dt">

                    
    
                </div>

            </div>

        </div>     
        


        
    </div>
    <script src="./asset/js/web/xemdethi.js"></script>

</body>
</html>