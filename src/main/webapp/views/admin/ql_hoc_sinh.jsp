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
    <link rel="stylesheet" href="../asset/css/admin/style.css">
    <title>Admin</title>
</head>
<body>
    <div class="trang-admin">

        <!-- modal them hoc sinh -->
        <div class="nen-xam quan-li-hs form-them-hoc-sinh">
            <div class="form-ql-hs">
                <div class="dau-form">
                    <p>Thêm học sinh</p>
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
                <div class="muc">
                    <label for="ten-dang-nhap">Username</label>
                    <input type="text" name="userName" id="ten-dang-nhap" placeholder="Nhập vào tên đăng nhập">
                </div>
                <div class="muc">
                    <label for="mat-khau">Password</label>
                    <input type="text" name="password" id="mat-khau" placeholder="Nhập vàp mật khẩu">
                </div>
                <button class="nut-submit">Thêm học sinh</button>
            </div>

        </div>
        <!--end of modal them hoc sinh -->

        <!-- modal sua thong tin hoc sinh -->
        <div class="nen-xam quan-li-hs form-sua-hoc-sinh">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Chỉnh sửa thông tin học sinh</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ma">Mã</label>
                    <input type="text" name="userID" id="ma" placeholder="MHS">
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
                <div class="muc">
                    <label for="ten-dang-nhap">Username</label>
                    <input type="text" name="userName" id="ten-dang-nhap" placeholder="Nhập vào tên đăng nhập">
                </div>
                <div class="muc">
                    <label for="mat-khau">Password</label>
                    <input type="text" name="password" id="mat-khau" placeholder="Nhập vàp mật khẩu">
                </div>
                <button class="nut-submit">Lưu</button>
            </div>
    
        </div>
        <!--end of modal sua thong tin hoc sinh -->


        <!-- ======================= Đầu trang ================ -->
        <div class="dau-trang">
            <div class="logo">
                <img src="../asset/img/logo4.png" alt="logo">
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
                <button>Đăng Nhập</button>
            </div>
            <% } %>
        </div>

        <!-- ============================= Menu trái================= -->
        <div class="menu-doc">
            <ul class="danh-muc">
                <li class="muc-ql duoc-chon">
                    <i class="uil uil-users-alt"></i>
                    <a href="#">Học sinh</a>
                </li>
                <li class="muc-ql">
                    <i class="uil uil-file"></i>
                    <a href="exams">Đề thi</a>
                </li>
                <li class="muc-ql">
                    <i class="uil uil-setting"></i>
                    <a href="#">Cài đặt</a>
                </li>
                <li class="muc-ql">
                    <i class="uil uil-signout"></i>
                    <a href="https://localhost/luyenthithptqg/logout">Đăng xuất</a>
                </li>
              
            </ul>
        </div>


        <!-- ================================= Nội dung ================== -->
        <div class="noi-dung">
            <p class="ten-muc">QUẢN LÝ HỌC SINH:</p>
            <div class="thong-tin-chung">
                <div class="nut-ql so-luong">
                    <span>Tổng số học sinh: </span>
                    <div class="sl so-luong-hs">
                        <span>100</span>
                        <i class="uil uil-graduation-cap"></i>
                    </div>
                </div>
                <div class="nut-ql them-moi them-moi-hs">
                    <span>Thêm học sinh</span>
                    <i class="uil uil-plus"></i>
                </div>
            </div>
        
            

            <div class="thong-ke">
                <div class="ten-bang">
                    <p>Danh sách học sinh</p>
                </div>
                <div class="bang-thong-ke">
                    <table class="bang danh-sach-hoc-sinh">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>MSV</th>
                                <th>Họ và tên đệm</th>
                                <th>Tên gọi</th>
                                <th>Ngày sinh</th>
                                <th>Email</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Sửa Đổi</th>
                                <th>Xóa</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                               <th>STT</th>
                                <th>MSV</th>
                                <th>Họ và tên đệm</th>
                                <th>Tên gọi</th>
                                <th>Ngày sinh</th>
                                <th>Email</th>
                                <th>Usenrname</th>
                                <th>Password</th>
                                <th>Sửa Đổi</th>
                                <th>Xóa</th>
                            </tr>
                        </tfoot>
                        <tbody>

                            <tr>
                                <td>1</td>
                                <td>b19dccn596</td>
                                <td>Nguyen Van</td>
                                <td>Toan</td>
                                <td>04/10/2001</td>
                                <td>hoangtoan04102001@gmail.com</td>
                                <td>toan</td>
                                <td>***********</td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>b19dccn596</td>
                                <td>Nguyen Van</td>
                                <td>Toan</td>
                                <td>04/10/2001</td>
                                <td>hoangtoan04102001@gmail.com</td>
                                <td>toan</td>
                                <td>***********</td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>b19dccn596</td>
                                <td>Nguyen Van</td>
                                <td>Toan</td>
                                <td>04/10/2001</td>
                                <td>hoangtoan04102001@gmail.com</td>
                                <td>toan</td>
                                <td>***********</td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>b19dccn596</td>
                                <td>Nguyen Van</td>
                                <td>Toan</td>
                                <td>04/10/2001</td>
                                <td>hoangtoan04102001@gmail.com</td>
                                <td>toan</td>
                                <td>***********</td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>b19dccn596</td>
                                <td>Nguyen Van</td>
                                <td>Toan</td>
                                <td>04/10/2001</td>
                                <td>hoangtoan04102001@gmail.com</td>
                                <td>toan</td>
                                <td>***********</td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div class="so-trang">
                    <button class="trang-sau"><<</button>
                    <button class="">1</button>
                    <button class="duoc-chon">2</button>
                    <button class="">3</button>
                    <button class="trang-truoc">>></button>
                </div>

            </div>

        </div>

        
        
    </div>

    <script src="../asset/js/admin/qlhs2.js"></script>
    <!-- <script src="asset/js/common.js"></script> -->
</body>
</html>