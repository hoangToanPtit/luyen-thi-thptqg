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
    <link rel="stylesheet" href="./asset/css/web/caidat.css">
    <title>Cài đặt</title>
    <link rel = "icon" href = "./asset/img/logo1.png"  type = "image/x-icon">
</head>
<body>
    <div class="trang-admin">

        <!-- modal sua thong tin hoc sinh -->
        <div class="nen-xam quan-li-hs form-sua-hoc-sinh">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Chỉnh sửa thông tin học sinh</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ho-va-ten-dem">Họ và tên đệm</label>
                    <input type="text" name="firstName" id="ho-va-ten-dem" placeholder="Nhập họ và tên đệm">
                </div>
                <div class="muc">
                    <label for="ten-hoc-sinh">Tên gọi</label>
                    <input type="text" name="lastName" id="ten-hoc-sinh" placeholder="Nhập họ và tên đệm">
                </div>
                <div class="muc">
                    <label for="ngay-sinh">Ngày sinh</label>
                    <input type="text" name="dateOfBirth" id="ngay-sinh" placeholder="dd/mm/yyyy">
                </div>
                <div class="muc">
                    <label for="email">Email</label>
                    <input type="text" name="email" id="email" placeholder="...@gmail.com">
                </div>
                <button class="nut-submit">Lưu</button>
            </div>
    
        </div>
        <!--end of modal sua thong tin hoc sinh -->


        <!-- modal sua thong tin hoc sinh -->
        <div class="nen-xam quan-li-hs form-doi-mat-khau">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Đổi mật khẩu</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="mat-khau">Mật khẩu cũ</label>
                    <input type="password" name="password" id="mat-khau" placeholder="Nhập vào mật khẩu hiện tại">
                </div>
                <small style="color: red;"></small>
                <div class="muc">
                    <label for="mat-khau-moi">Mật khẩu mới</label>
                    <input type="password" name="new-password" id="mat-khau-moi" placeholder="Nhập vào mật khẩu mới">
                </div>
                <small style="color: red;"></small>
                <div class="muc">
                    <label for="nhac-mat-khau">Nhắc lại mật khẩu mới</label>
                    <input type="password" name="re-password" id="nhac-mat-khau" placeholder="Nhắc lại mật khẩu mới">
                </div>
                <small style="color: red;"></small>
                <button class="nut-submit">Đổi mật khẩu</button>
            </div>
    
        </div>
        <!--end of modal sua thong tin hoc sinh -->        

        <!-- ======================= Đầu trang ================ -->
        <div class="dau-trang">
            <div class="logo">
                <img src="./asset/img/logo4.png" alt="logo">
            </div>

            <div class="o-tim-kiem">
                <i class="uil uil-search"></i>
                <input type="text" placeholder="Nhập nội dung tìm kiếm">
            </div>
            <div class="tai-khoan" style="display: none;">
                <img src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" alt="">
                <span>Admin</span>
            </div>
            <%
            	if(session.getAttribute("userId")!=null){
            %>
            <div class="tai-khoan tk-dn" id="tk<%= session.getAttribute("userId") %>">
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
                <li class="muc-ql">
                    <i class="uil uil-file"></i>
                    <a href="exams">Đề thi</a>
                </li>
                <li class="muc-ql duoc-chon">
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
        <div class="noi-dung">
            <div class="noi-dung-trai">
                <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTPZQ_Z6Jir7-1quljeW8Nea3KQ3uXEVbtQ6w&usqp=CAU" alt="">
                <p class="ten-tk">Nguyễn Văn Toản</p>
                <!-- <div class="mn thong-tin">Thông tin cá nhân</div>
                <div class="mn doi-mk">Đổi mật khẩu</div>
                <div class="mn lich-su">Lịch sử làm bài</div> -->
                <a href="logout" style="text-decoration: none;">
                <div class="mn lich-su">Đăng xuất</div>
                </a>
            </div>

            <div class="noi-dung-phai">
                <div class="thong-tin-ca-nhan">
                    <h2>Thông tin cá nhân</h2>
                    <div class="tt ho_ten_dem">
                        <h3>Họ và tên đệm:</h3>
                        <p>Nguyễn Văn</p>
                    </div>
                    <div class="tt ten_goi">
                        <h3>Tên gọi:</h3>
                        <p>Toản</p>
                    </div>
                    <div class="tt dob">
                        <h3>Ngày sinh:</h3>
                        <p>04/10/2001</p>
                    </div>
                    <div class="tt email">
                        <h3>Email:</h3>
                        <p>hoangtoan04102001@gmail.com</p>
                    </div>
                    <button>Chỉnh sửa</button>
                </div>

                <div class="tai-khoan-ca-nhan">
                    <h2>Thông tin tài khoản</h2>
                    <div class="tt ten_dang_nhap">
                        <h3>Tên đăng nhập:</h3>
                        <p>Toan123</p>
                    </div>
                    <div class="tt">
                        <h3>Mật khẩu:</h3>
                        <p>*********</p>
                    </div>
                    <button>Đổi mật khẩu</button>
                </div>

                <div class="lich-su-lam-bai">
                    <h2>Lịch sử làm bài</h2>
                    <div class="bang-lich-su">
                        <table class="bang" cellspacing="10px">
                            <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>Tên đề</th>
                                    <th>Điểm số</th>
                                    <th>Thời gian (phút)</th>
                                    <th>Xem</th>
                                </tr>
                            </thead>
                            <tfoot>
                                <tr>
                                   <th>STT</th>
                                   <th>Tên đề</th>
                                   <th>Điểm số</th>
                                   <th>Thời gian (phút)</th>
                                   <th>Xem</th>
                                </tr>
                            </tfoot>
                            <tbody>    
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div class="cuoi-trang">
            <i class="uil uil-copyright"></i> NVT-LTWEB
        </div>
        
    </div>

    <script src="./asset/js/web/caidat.js"></script>
</body>
</html>