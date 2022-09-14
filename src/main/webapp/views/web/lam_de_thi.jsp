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
    <link rel="stylesheet" href="./asset/css/web/lamdethi.css">
    <!-- <link rel="stylesheet" href="./asset/css/dethiweb.css"> -->
    <title>Làm bài</title>
    <link rel = "icon" href = "./asset/img/logo1.png"  type = "image/x-icon">
</head>
<body>
    <div class="trang-admin">

        <!-- ======================= Đầu trang ================ -->
        <div class="dau-trang">
            <div class="logo_nho">
            	<a href="exams">
	                <img src="./asset/img/logo1.png" alt="logo">
	                <i class="uil uil-angle-left-b"></i>
	                <p>Quay lại</p>
            	</a>
            </div>

            <div class="thoi_gian">
                <i class="uil uil-clock-three"></i>
                <span>00:00</span>
            </div>

            <div class="nut_dieu_khien">
                <div class="nut_nop_bai">Nộp bài</div>
                <div class="nut_tam_dung">Tạm dừng</div>
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



        <!-- ================================= Nội dung ================== -->
        <!-- Thông báo kết quả -->
        <div class="ket_qua">
            <div class="nd_ket_qua">
                <div class="dau_ket_qua">
                    <img src="./asset/img/logo1.png" alt="logo">
                    <h2>KẾT QUẢ</h2>
                </div>
                <div class="sau_ket_qua">
                    <div><p>Điểm số: </p><span class="diem_so">0/0</span></div>
                    <div><p>Thời gian: </p><span class="thoi_gian_kq">0/0</span></div>
                </div>
                <div class="nut_xem_bl">
                    <button class="xem_kq_chi_tiet">Xem chi tiết</button>
                    <button class="nut_dong_kq">Đóng</button>
                </div>
            </div>
        </div>
        <!-- Kết thúc phần thông báo kết quả -->
        <div class="che_trang"></div>
        <div class="noi-dung" id="exid<%= request.getAttribute("examId")%>">

            <div class="chi-tiet-de-thi">
                <p class="ten-de"></p>
                <div class="chua-cau-hoi-dt">

                    
    
                </div>

            </div>

            <div class="bang_danh_dau">
                <h2>Tổng số câu hỏi: 50</h2>
                <div class="phan_danh_dau">
                    <!-- <div class="cau_danh_dau"></div> -->
                </div>
                
                <div class="huong_dan_danh_dau">
                    <div class=" huong_dan danh_dau_cau_da_lam">
                        <div></div>
                        <p>Câu hỏi đã làm</p>
                    </div>
                    <div class=" huong_dan danh_dau_cau_xem_lai">
                        <div></div>
                        <p>Câu hỏi đánh dấu xem lại</p>
                    </div>
                    <div class=" huong_dan danh_dau_cau_chua_lam">
                        <div></div>
                        <p>Câu hỏi chưa làm</p>
                    </div>
                </div>
            </div>
        </div>


        
    </div>

    <script src="./asset/js/web/lamdethi.js"></script>

</body>
</html>