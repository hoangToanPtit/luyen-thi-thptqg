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
    <link rel="stylesheet" href="./asset/css/web/dethiweb2.css">
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
        <div class="noi-dung" style="min-height: 92vh">
           <div class="mon_hoc">
               <div class="mon duoc_chon mon_toan">
                   Toán
               </div>
               <div class="mon mon_li">
                   Vật Lí
               </div>
               <div class="mon mon_hoa">
                   Hóa Học
               </div>
               <div class="mon mon_sinh">
                   Sinh Học
               </div>
               <div class="mon mon_su">
                   Lịch Sử
               </div>
               <div class="mon mon_dia">
                   Địa Lí
               </div>
               <div class="mon mon_gdcd">
                   GDCD
               </div>
               <div class="mon mon_anh">
                   Tiếng Anh
               </div>
           </div>


           <div class="phan_giua">
               <div class="danh_sach_de_thi">
                    
                    
               </div>
               
               <div class="bo_loc">
                    <h2>Bộ lọc tìm kiếm:</h2>
                    <div>
                        <div class="ten_trương_tim_kiem">Nguồn:</div>
                        <select name="source" id="nguon_goc">
                            <option  >Tỉnh/Thành phố</option>
                        </select>
                    </div>
                    <div>
                        <div class="ten_trương_tim_kiem">Năm: </div>
                        <select name="" id="nam_bat_dau">
                            <option  >2017</option>
                            <option  >2018</option>
                            <option  >2019</option>
                        </select>
                        <select name="" id="nam_ket_thu">
                            <option  >2022</option>
                            <option  >2021</option>
                            <option  >2020</option>
                        </select>
                    </div>

                    <div style="display: none;">
                        <div class="ten_trương_tim_kiem">Trạng thái: </div>
                        <div class="select_trang_thai">
                            <div>
                                <input type="checkbox" name="trang_thai" id="trang_thai_da_lam" value="">
                                <label for="trang_thai_da_lam" >Chưa làm</label>
                            </div>
                            <div>
                                <input type="checkbox" name="trang_thai" id="trang_thai_chua_lam" value="">
                                <label for="trang_thai_chua_lam" >Đã làm</label>
                            </div>
                        </div>
                    </div>

                    <div class="nut_loc_bai_viet">Tìm kiếm</div>

               </div>
           </div>
        </div>

        
        
    </div>


	<div class="cuoi-trang">
        <i class="uil uil-copyright"></i> NVT-LTWEB
    </div>
        
    <script src="./asset/js/web/dtweb2.js"></script>
    <!-- <script src="asset/js/common.js"></script> -->
</body>
</html>