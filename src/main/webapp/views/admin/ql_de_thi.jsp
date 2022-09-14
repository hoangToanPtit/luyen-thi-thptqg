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
    <link rel="stylesheet" href="../asset/css/admin/styledt.css">
    <link rel="stylesheet" href="../asset/css/admin/detailExam.css">
    <title>Admin</title>
</head>
<body>
    <div class="trang-admin">

        <!-- modal them de thi-->
        <div class="nen-xam quan-li-hs form-them-de-thi">
            <div class="form-ql-hs">
                <div class="dau-form">
                    <p>Thêm đề thi mới</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ho-va-ten-dem">Tên đề thi</label>
                    <input type="text" name="name" id="ho-va-ten-dem" placeholder="Nhập tên đề thi">
                </div>
                <div class="muc">
                    <label for="ten-hoc-sinh">Môn học</label>
                    <input type="text" name="subject" id="ten-hoc-sinh" placeholder="Nhập tên môn học">
                </div>
                <div class="muc">
                    <label for="ngay-sinh">Nguồn</label>
                    <input type="text" name="source" id="ngay-sinh" placeholder="Nhập vào tên tỉnh ra đề">
                </div>
                <div class="muc">
                    <label for="email">Năm học</label>
                    <input type="text" name="year" id="email" placeholder="Nhập vào năm ra đề">
                </div>
                <div class="muc">
                    <label for="ten-dang-nhap">Số câu hỏi</label>
                    <input type="text" name="amount" id="ten-dang-nhap" placeholder="Nhập vào số lượng câu hỏi">
                </div>
                <div class="muc">
                    <label for="mat-khau">Thời gian làm bài (phút)</label>
                    <input type="text" name="time" id="mat-khau" placeholder="Nhập vào thời gian làm bài">
                </div>
                <button class="nut-submit">Thêm đề thi</button>
            </div>

        </div>
        <!--end of modal them de thi -->

        <!-- modal sua thong tin chung cua de thi -->
        <div class="nen-xam quan-li-hs form-sua-thong-tin-chung-de-thi">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Chỉnh sửa thông tin chung của đề thi</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ma">Mã đề</label>
                    <input type="text" name="examID" id="ma" placeholder="MHS">
                </div>
                <div class="muc">
                    <label for="ho-va-ten-dem">Tên đề thi</label>
                    <input type="text" name="name" id="ho-va-ten-dem" placeholder="Nhập tên đề thi">
                </div>
                <div class="muc">
                    <label for="ten-hoc-sinh">Môn học</label>
                    <input type="text" name="subject" id="ten-hoc-sinh" placeholder="Nhập tên môn học">
                </div>
                <div class="muc">
                    <label for="ngay-sinh">Nguồn</label>
                    <input type="text" name="source" id="ngay-sinh" placeholder="Nhập vào tên tỉnh ra đề">
                </div>
                <div class="muc">
                    <label for="email">Năm học</label>
                    <input type="text" name="year" id="email" placeholder="Nhập vào năm ra đề">
                </div>
                <div class="muc">
                    <label for="ten-dang-nhap">Số câu hỏi</label>
                    <input type="text" name="amount" id="ten-dang-nhap" placeholder="Nhập vào số lượng câu hỏi">
                </div>
                <div class="muc">
                    <label for="mat-khau">Thời gian làm bài (phút)</label>
                    <input type="text" name="time" id="mat-khau" placeholder="Nhập vào thời gian làm bài">
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
                <li class="muc-ql ">
                    <i class="uil uil-users-alt"></i>
                    <a href="students">Học sinh</a>
                </li>
                <li class="muc-ql duoc-chon">
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
            <p class="ten-muc">QUẢN LÝ ĐỀ THI:</p>
            <div class="thong-tin-chung">
                <div class="nut-ql so-luong">
                    <span>Tổng số đề thi: </span>
                    <div class="sl so-luong-dt">
                        <span>100</span>
                        <i class="uil uil-graduation-cap"></i>
                    </div>
                </div>
                <div class="nut-ql them-moi them-moi-dt">
                    <span>Thêm đề thi</span>
                    <i class="uil uil-plus"></i>
                </div>
            </div>
        
            

            <div class="thong-ke">
                <div class="ten-bang">
                    <p>Danh sách đè thi</p>
                </div>
                <div class="bang-thong-ke">
                    <table class="bang danh-sach-de-thi">
                        <thead>
                            <tr>
                                <th>STT</th>
                                <th>Mã đề</th>
                                <th>Tên đề thi</th>
                                <th>Môn học</th>
                                <th>Nguồn</th>
                                <th>Năm học</th>
                                <th>Tổng số câu hỏi</th>
                                <th>Thời gian</th>
                                <th>Chi tiết</th>
                                <th>Sửa Đổi</th>
                                <th>Xóa</th>
                            </tr>
                        </thead>
                        <tfoot>
                            <tr>
                               <th>STT</th>
                                <th>Mã đề</th>
                                <th>Tên đề thi</th>
                                <th>Môn học</th>
                                <th>Nguồn</th>
                                <th>Năm học</th>
                                <th>Tổng số câu hỏi</th>
                                <th>Thời gian</th>
                                <th>Chi tiết</th>
                                <th>Sửa Đổi</th>
                                <th>Xóa</th>
                            </tr>
                        </tfoot>
                        <tbody>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
                                <td><i class="uil uil-edit nut-sua"></i></td>
                                <td><i class="uil uil-trash-alt nut-xoa"></i></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>10</td>
                                <td>Đề 1</td>
                                <td>Toán</td>
                                <td>Tỉnh Nam Định</td>
                                <td>2022</td>
                                <td>50</td>
                                <td>60</td>
                                <td><i class="uil uil-eye nut-xem-chi-tiet"></i></td>
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

    <script src="../asset/js/admin/qldt.js"></script>
    <!-- <script src="asset/js/common.js"></script> -->
</body>
</html>