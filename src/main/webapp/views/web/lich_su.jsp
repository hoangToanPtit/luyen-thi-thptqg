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
    <link rel="stylesheet" href="./asset/css/web/chitietdt2.css">
    <!-- <link rel="stylesheet" href="./asset/css/dethiweb.css"> -->
    <title>Lịch sử</title>
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
        <div class="noi-dung" id="exid<%= request.getAttribute("examId")%>">
            <p class="ten-muc">LỊCH SỬ LÀM BÀI:</p>

            <div class="chi-tiet-de-thi">
                <p class="ten-de">Đề thi thử môn Toán tỉnh Nam Định năm học 2022</p>

                <p class="diem_so_kq" >Điểm số: <span>9/10</span></p>
                <p class="thoi_gian_kq" >Thời gian: <span>40/50</span> phút</p>

                <div class="chua-cau-hoi-dt">

                    <form>
                        <div class="cau-hoi">

                            <div class="nut-danh-dau">
                               <i class="uil uil-check"></i>
                               <i class="uil uil-times"></i>
                            </div>

                            <p class="noi-dung-cau-hoi">
                                <b>Câu <span class="stt">1</span></b>:  1+1s = ?
                            </p>
                            <div class="phuong-an-lua-chon an_chon">
                                <div class="phuong-an">
                                    <input type="radio" id="html" name="phuong_an" value="">
                                    <label for="html">A. câu trả lời 1</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="css" name="phuong_an" value="">
                                    <label for="css">B. câu trả lời 2</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="javascript" name="phuong_an" value="">
                                    <label for="javascript">C. câu trả lời 3</label>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="abc" name="phuong_an" value="">
                                    <label for="abc">D. câu trả lời 4</label>
                                </div>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div class="cau-hoi">
                            
                            <p class="noi-dung-cau-hoi">
                                <b>Câu <span class="stt">1</span></b>:  1+1 = ?
                            </p>
                            <div class="phuong-an-lua-chon an_chon">
                                <div class="phuong-an">
                                    <input type="radio" id="html" name="phuong_an" value="">
                                    <label for="html">A. câu trả lời 1</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="css" name="phuong_an" value="">
                                    <label for="css">B. câu trả lời 2</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="javascript" name="phuong_an" value="">
                                    <label for="javascript">C. câu trả lời 3</label>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="abc" name="phuong_an" value="">
                                    <label for="abc">D. câu trả lời 4</label>
                                </div>
                            </div>
                        </div>
                    </form>
                    <form>
                        <div class="cau-hoi">
                            
                            <p class="noi-dung-cau-hoi">
                                <b>Câu <span class="stt">1</span></b>:  1+1 = ?
                            </p>
                            <div class="phuong-an-lua-chon an_chon">
                                <div class="phuong-an">
                                    <input type="radio" id="html" name="phuong_an" value="">
                                    <label for="html">A. câu trả lời 1</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="css" name="phuong_an" value="">
                                    <label for="css">B. câu trả lời 2</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="javascript" name="phuong_an" value="">
                                    <label for="javascript">C. câu trả lời 3</label>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="abc" name="phuong_an" value="">
                                    <label for="abc">D. câu trả lời 4</label>
                                </div>
                            </div>
                        </div>
                    </form>
    
                </div>

            </div>

        </div>     
        


        
    </div>
	<script src="./asset/js/web/lichsu.js"></script>
</body>
</html>