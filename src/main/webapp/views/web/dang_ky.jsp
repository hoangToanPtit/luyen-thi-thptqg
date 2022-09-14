<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="./asset/css/web/dangNhap.css">
    <title>Đăng ký</title>
    <link rel = "icon" href = "./asset/img/logo1.png"  type = "image/x-icon">
</head>
<body>
    


	<div class="noi-dung">
		
			<div class="dang_nhap_form">
				<div class="dau_form">
					<img src="./asset/img/logo4.png" alt=""> 
					<h2>ĐĂNG KÝ </h2>
					<small><a href="login">Đăng nhập</a> nếu bạn đã có tài khoản</small>
				</div>
				<div>
					<label for="ho_ten">Họ và Tên đệm</label>
					<input type="text" name="lastName" id="ho_ten">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="ten_goi">Tên gọi</label>
					<input type="text" name="firstName" id="ten_goi">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="dob">Ngày sinh</label>
					<input type="text" name="dateOfBirth" id="dob">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="email">Email</label>
					<input type="text" name="email" id="email">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="ten_dn">Tên đăng nhập</label>
					<input type="text" name="userName" id="ten_dn">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="mk_dn">Mật khẩu</label>
					<input type="password" name="password" id="mk_dn">
				</div>
				<small class="error" style="color: red;"></small>
				<div>
					<label for="mk_dn_nl">Nhắc lại mật khẩu</label>
					<input type="password" name="re_password" id="mk_dn_nl">
				</div>
				<small class="error" style="color: red;"></small>
				<div class="nut_dang_nhap">
					<button>Đăng ký</button>
				</div>
			</div>
		  
	</div>	


	
	<script src="./asset/js/web/dangky.js"></script>

</body>
</html>