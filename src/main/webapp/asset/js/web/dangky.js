const domain = 'https://localhost/luyenthithptqg';


//header for call api
let headers = new Headers();
headers.append("Content-Type", "application/json");

const cac_truong_nhap_dl = document.querySelectorAll('input');
const cac_loi = document.querySelectorAll('.error');
const nut_dang_ky = document.querySelector('.nut_dang_nhap button');


(()=>{
    kiemTraGiaTriFormNhap();
    nut_dang_ky.addEventListener('click', async() => {
        if(kiemTraDaNhapDu()){
            const tai_khoan = layDuLieu();

            const response = await fetch(`${domain}/api-sign-up`, {
                method: 'POST',
                headers: headers,
                body: JSON.stringify(tai_khoan)
            })

            const tk = await response.json();
            console.log(tk);

            if(tk==null){
                cac_loi[0].textContent = '*Tên đăng nhập đã tồn tại';
            }else{
                location.href="https://localhost/luyenthithptqg/login";
            }
        }
    })
 
})();

function kiemTraGiaTriFormNhap(){
    nut_dang_ky.style.backgroundColor = '#E9F4F';
    for(let i=0; i<cac_truong_nhap_dl.length; i++){
        cac_truong_nhap_dl[i].addEventListener('blur', () => {
            if(cac_truong_nhap_dl[i].value==''){
                cac_loi[i].textContent = '*Bắt buộc';
            }
        })
        cac_truong_nhap_dl[i].addEventListener('click', () => {
            cac_loi[i].textContent = '';
        })
    }
    cac_truong_nhap_dl[6].addEventListener('blur', () => {
        if(cac_truong_nhap_dl[6].value!='' 
            && cac_truong_nhap_dl[6].value!=cac_truong_nhap_dl[5].value){
            cac_loi[6].textContent = '*Nhắc lại mật khẩu không chính xác';
        }
    })
}

function layDuLieu(){
    const tai_khoan = {};
    tai_khoan.role = 'student';
    cac_truong_nhap_dl.forEach(e => {
        if(e.name!='re_password'){
            tai_khoan[e.name] = e.value;
        }
    })
    return tai_khoan;
}


function kiemTraDaNhapDu(){
    let bl = true;
    cac_loi.forEach(e => {
        if(e.textContent!='') bl = false;
    })
    return bl;
}