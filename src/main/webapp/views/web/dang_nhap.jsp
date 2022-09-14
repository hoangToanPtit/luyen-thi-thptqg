<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./asset/css/web/dangNhap.css">

    <title>Đăng nhập</title>
    <link rel = "icon" href = "./asset/img/logo1.png"  type = "image/x-icon">
</head>
<body>
    


	<div class="noi-dung">
		
			<div class="dang_nhap_form">
				<div class="dau_form">
					<img src="./asset/img/logo4.png" alt=""> 
					<h2>ĐĂNG NHẬP </h2>
					<small>Hãy <a href="signup">Đăng ký</a> nếu bạn chưa có tài khoản</small>
					<small class="error" style="color: red;"></small>
				</div>
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
				<div class="url" style="display:none;"><%= request.getAttribute("url") %></div>
				<div class="nut_dang_nhap">
					<button>Đăng nhập</button>
				</div>
			</div>
		  
	</div>	

	<script src="./asset/js/web/dangnhap2.js"></script>

</body>
</html>