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

        <!-- modal sua thong tin chung cua de thi -->
        <div class="nen-xam  form-sua-thong-tin-chung-de-thi">
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

        <!-- modal them cau hoi vao de thi -->
        <div class="nen-xam form-them-cau-hoi">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Thêm câu hỏi mới</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ho-va-ten-dem">Câu hỏi</label>
                    <input type="text" name="description" id="ho-va-ten-dem" placeholder="Nhập nội dung câu hỏi">
                </div>
                <div class="muc">
                    <label for="ten-hoc-sinh">Lựa chọn 1</label>
                    <input type="text" name="selection1" id="ten-hoc-sinh" placeholder="Nhập phương án A">
                </div>
                <div class="muc">
                    <label for="ngay-sinh">Lựa chọn 2</label>
                    <input type="text" name="selection2" id="ngay-sinh" placeholder="Nhập phương án B">
                </div>
                <div class="muc">
                    <label for="email">Lựa chọn 3</label>
                    <input type="text" name="selection3" id="email" placeholder="Nhập phương án C">
                </div>
                <div class="muc">
                    <label for="ten-dang-nhap">Lựa chọn 4</label>
                    <input type="text" name="selection4" id="ten-dang-nhap" placeholder="Nhập phương án D">
                </div>
                <div class="muc chon-answer">
                    <label for="phuong-an-dung">Phương án đúng</label>
                    <select name="dap-an" id="phuong-an-dung">
                        <option value="1" selected>Đáp án A</option>
                        <option value="2">Đáp án B</option>
                        <option value="3">Đáp án C</option>
                        <option value="4">Đáp án D</option>
                    </select>
                </div>
                <button class="nut-submit">Thêm</button>
            </div>
    
        </div>
         <!-- end of modal them cau hoi vao de thi -->
         
        <!-- modal SUA cau hoi vao de thi -->
        <div class="nen-xam form-sua-cau-hoi">
            <div class="form-ql-hs ">
                <div class="dau-form">
                    <p>Chỉnh sửa câu hỏi</p>
                    <i class="uil uil-times nut-dong"></i>
                </div>
                <div class="muc">
                    <label for="ho-va-ten-dem">Câu hỏi</label>
                    <input type="text" name="description" id="ho-va-ten-dem" placeholder="Nhập nội dung câu hỏi">
                </div>
                <div class="muc">
                    <label for="ten-hoc-sinh">Lựa chọn 1</label>
                    <input type="text" name="selection1" id="ten-hoc-sinh" placeholder="Nhập phương án A">
                </div>
                <div class="muc">
                    <label for="ngay-sinh">Lựa chọn 2</label>
                    <input type="text" name="selection2" id="ngay-sinh" placeholder="Nhập phương án B">
                </div>
                <div class="muc">
                    <label for="email">Lựa chọn 3</label>
                    <input type="text" name="selection3" id="email" placeholder="Nhập phương án C">
                </div>
                <div class="muc">
                    <label for="ten-dang-nhap">Lựa chọn 4</label>
                    <input type="text" name="selection4" id="ten-dang-nhap" placeholder="Nhập phương án D">
                </div>
                <div class="muc chon-answer">
                    <label for="phuong-an-dung-formsua">Phương án đúng</label>
                    <select name="dap-an" id="phuong-an-dung-formsua">
                        <option value="1">Đáp án A</option>
                        <option value="2">Đáp án B</option>
                        <option value="3">Đáp án C</option>
                        <option value="4">Đáp án D</option>
                    </select>
                </div>
                <button class="nut-submit">Luu</button>
            </div>
    
        </div>
         <!-- end of modal SUA cau hoi vao de thi -->



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
                <li class="muc-ql">
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
            <p class="ten-muc">CHI TIẾT ĐỀ THI MÃ <span id="examId">${examId}</span>:</p>
            <div class="thong-tin-chung">
                <div class="nut-ql them-moi sua-tt-dt">
                    <span>Sửa thông tin chung: </span>
                    <i class="uil uil-edit"></i>
                </div>
                <div class="nut-ql them-moi them-cau-hoi-moi">
                    <span>Thêm câu hỏi</span>
                    <i class="uil uil-plus"></i>
                </div>
            </div>


            <div class="chi-tiet-de-thi">
                <p class="ten-de">Đề thi thử môn Toán tỉnh Nam Định năm học 2022</p>
                <div class="chua-cau-hoi-dt">

                    <form>
                        <div class="cau-hoi">
                            <div class="nut-ql">
                                <i class="uil uil-edit nut-sua"></i>
                                <i class="uil uil-trash-alt nut-xoa"></i>
                            </div>
                            <p class="noi-dung-cau-hoi">
                                <b>Câu <span class="stt">1</span></b>:  1+1 = ?
                            </p>
                            <div class="phuong-an-lua-chon">
                                <div class="phuong-an">
                                    <input type="radio" id="html" name="phuong_an" value="">
                                    <label for="html">câu trả lời 1</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="css" name="phuong_an" value="">
                                    <label for="css">câu trả lời 2</label><br>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="javascript" name="phuong_an" value="">
                                    <label for="javascript">câu trả lời 3</label>
                                </div>
                                <div class="phuong-an">
                                    <input type="radio" id="abc" name="phuong_an" value="">
                                    <label for="abc">câu trả lời 4</label>
                                </div>
                            </div>
                        </div>
                    </form>
    
                </div>

            </div>

        </div>     
        
        
    </div>

    <script src="../asset/js/admin/dt.js"></script>
    <!-- <script src="asset/js/common.js"></script> -->
</body>
</html>