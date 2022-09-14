const stuid = document.querySelector('.tk-dn').id.slice(2);
const domain = 'https://localhost/luyenthithptqg';

//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

const noi_dung_trai = document.querySelector('.noi-dung-trai');
const ten_tk = noi_dung_trai.querySelector('.ten-tk');

const noi_dung_phai = document.querySelector('.noi-dung-phai');
const ho_ten_dem = noi_dung_phai.querySelector('.ho_ten_dem p');
const ten_goi = noi_dung_phai.querySelector('.ten_goi p');
const dob = noi_dung_phai.querySelector('.dob p');
const email = noi_dung_phai.querySelector('.email p');

const nut_chinh_sua_tt_ca_nhan = noi_dung_phai.querySelector("button");
const form_sua_tt = document.querySelector('.form-sua-hoc-sinh');
const nut_dong_form_sua_tt = form_sua_tt.querySelector('.nut-dong');
const nut_luu_tt_moi = form_sua_tt.querySelector('button');

const tai_khoan_ca_nhan = document.querySelector('.tai-khoan-ca-nhan');
const ten_dang_nhap = tai_khoan_ca_nhan.querySelector('.ten_dang_nhap p');
const nut_doi_mk = tai_khoan_ca_nhan.querySelector("button");
const form_doi_mat_khau = document.querySelector('.form-doi-mat-khau');
const nut_dong_form_doi_mat_khau = form_doi_mat_khau.querySelector('.nut-dong');
const nut_luu_mat_khau_moi = form_doi_mat_khau.querySelector('button');

(async()=>{
    themSuKienMoDongCacForm();
 
    const response = await fetch(`${domain}/api-student?id=${stuid}`, {
        method: 'GET',
        headers: headers
    })
    
    const tk = await response.json();
    console.log(tk);

    hienThiThongTin(tk);
    themSuKienChoFormChinhSuaTTCaNhan(tk);
    themSuKienChoFormDoiMatKhau(tk);

    const res = await fetch(`${domain}/api/student_exam`, {
        method: 'GET',
        headers: headers
    })

    const bai_lam = await res.json();
    console.log(bai_lam);
    hienThiLichSuLamBai(bai_lam);


})();

function themSuKienMoDongCacForm(){
    nut_chinh_sua_tt_ca_nhan.addEventListener('click', ()=>{
        form_sua_tt.style.display = 'block';
    })
    nut_dong_form_sua_tt.addEventListener('click', ()=>{
        form_sua_tt.style.display = 'none';
    })

    nut_doi_mk.addEventListener('click', ()=>{
        form_doi_mat_khau.style.display = 'block';
    })
    nut_dong_form_doi_mat_khau.addEventListener('click', ()=> {
        form_doi_mat_khau.style.display = 'none';
    })
}

function hienThiThongTin(e){
    ten_tk.textContent = `${e.lastName} ${e.firstName}`;
    ho_ten_dem.textContent = `${e.lastName}`;
    ten_goi.textContent = `${e.firstName}`;
    dob.textContent = `${e.dateOfBirth}`;
    email.textContent = `${e.email}`;
    ten_dang_nhap.textContent = `${e.userName}`;
}

function hienThiLichSuLamBai(bai_lam){
    const bang_lich_su = document.querySelector('.bang-lich-su tbody');
    bang_lich_su.textContent = '';
    let stt = 1;
    bai_lam.forEach(e => {
        let html = `
        <tr>
            <td>${stt++}</td>
            <td>${e.exam.name}</td>
            <td>${e.score}</td>
            <td>${e.exam.time - e.submitTime}</td>
            <td><a href="https://localhost/luyenthithptqg/student_exam?exid=${e.exam.examID}">
            <i class="uil uil-eye nut-xem-chi-tiet"></i>
            </a></td>
        </tr>
        `

        bang_lich_su.insertAdjacentHTML("beforeend", html);
    });
}

function themSuKienChoFormChinhSuaTTCaNhan(tk){
    const input_form_tt = form_sua_tt.querySelectorAll('input');
    input_form_tt.forEach(e => {
        e.value = tk[e.name];
    });

    nut_luu_tt_moi.addEventListener('click', async()=>{
        input_form_tt.forEach(e => {
            if(e.value!=''){
                tk[e.name] = e.value;
            }
        });
        console.log(tk);

        const response = await fetch(`${domain}//api-student`, {
            method: 'POST',
            headers: headers,
            body: JSON.stringify(tk)
        })
        
        const tk_moi = await response.json();
        console.log(tk_moi);
        hienThiThongTin(tk_moi);
        form_sua_tt.style.display = 'none';
    })
}

function themSuKienChoFormDoiMatKhau(tk){
    const input_mat_khau = form_doi_mat_khau.querySelectorAll('input');
    const thong_bao_loi = form_doi_mat_khau.querySelectorAll('small');

    for(let i=0; i<3; i++){
        input_mat_khau[i].addEventListener('blur', ()=>{
            if(input_mat_khau[i].value==''){
                thong_bao_loi[i].textContent = '*Bắt buộc';
            }
        })
        input_mat_khau[i].addEventListener('click', ()=>{
            thong_bao_loi[i].textContent = '';
        })
    }

    input_mat_khau[2].addEventListener('blur', ()=>{
        if(input_mat_khau[1].value != input_mat_khau[2].value){
            thong_bao_loi[2].textContent = '*Nhắc lại mật khẩu không chính xác';
        }
    })

    nut_luu_mat_khau_moi.addEventListener('click', ()=> {
        thong_bao_loi.forEach(e => {
            e.textContent='';
        });
    })
}